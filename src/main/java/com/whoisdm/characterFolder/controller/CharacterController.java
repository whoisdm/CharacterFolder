package com.whoisdm.characterFolder.controller;

import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import com.whoisdm.characterFolder.model.characters.RegistrationCharacter;
import com.whoisdm.characterFolder.service.characters.CharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CharacterController {

    private final List<String> CLASSES = List.of("artificer,barbarian,bard,cleric,druid,fighter,monk,paladin,ranger,rogue,sorcerer,warlock,wizard".split(","));
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String homePage() {
        return "home-page";
    }

    @GetMapping("/viewCharacters")
    public String viewCharacters(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<FolderCharacter> characters = characterService.findAllByUsername(username);
        model.addAttribute("characters", characters);
        return "characters/characters-view";
    }

    @GetMapping("/showCreationForm")
    public String showCreationForm(Model model) {
        model.addAttribute("classes", CLASSES);
        model.addAttribute("character", new RegistrationCharacter());
        return "characters/creation-form";
    }

    @PostMapping("/processCreationForm")
    public String processCreationForm(@Valid @ModelAttribute("character") RegistrationCharacter character, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("classes", CLASSES);
            return "characters/creation-form";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        FolderCharacter createdCharacter = characterService.saveCharacter(character, username);
        if (createdCharacter == null) {
            model.addAttribute("classes", CLASSES);
            model.addAttribute("character", new RegistrationCharacter());
            model.addAttribute("creationError", "Character creation failed! Check your data and try again.");
            return "characters/creation-form";
        }

        return "redirect:/";
    }

}
