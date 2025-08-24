package com.whoisdm.characterFolder.controller;

import com.whoisdm.characterFolder.model.user.RegistrationUser;
import com.whoisdm.characterFolder.model.user.User;
import com.whoisdm.characterFolder.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/login")
    public String loginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }
        return "user/login-page";
    }

    @GetMapping("/showRegistration")
    public String showRegistrationPage(Model theModel) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }

        theModel.addAttribute("regUser", new RegistrationUser());
        return "user/registration-page";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(@Valid @ModelAttribute("regUser") RegistrationUser regUser,
                                      BindingResult theBindingResult, HttpSession session, Model theModel,
                                      RedirectAttributes redirectAttributes) {
        if (theBindingResult.hasErrors()){
            return "user/registration-page";
        }

        if (!regUser.getPassword().equals(regUser.getPasswordConfirm())){
            theModel.addAttribute("regUser", new RegistrationUser());
            theModel.addAttribute("registrationError", "Passwords do not match.");
            return "user/registration-page";
        }

        User newUser = userService.save(regUser);
        if (newUser == null) {
            theModel.addAttribute("regUser", new RegistrationUser());
            theModel.addAttribute("registrationError", "Username already exists.");
            return "user/registration-page";
        }

        redirectAttributes.addFlashAttribute("registered",true);
        return "redirect:/login";
    }
}
