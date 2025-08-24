package com.whoisdm.characterFolder.model.characters;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class RegistrationCharacter {
    @NotNull(message = "Name is required!")
    @Size(min = 2, message = "At least 2 symbols!")
    private String name;

    @NotNull(message = "Description is required!")
    @Size(min = 5, message = "At least 5 symbols!")
    private String description;

    @NotNull(message = "Backstory is required!")
    @Size(min = 5, message = "At least 5 symbols!")
    private String backstory;

    @Pattern(regexp = "^((?!none).)*$", message = "Class is required!")
    private String className;

    @Valid
    private RegistrationStats stats;

    public RegistrationCharacter() {

    }

    public RegistrationCharacter(String name, String description, String backstory, String className) {
        this.name = name;
        this.description = description;
        this.backstory = backstory;
        this.className = className;
        this.stats = new RegistrationStats();
    }

    public List<Integer> getStatsList(){
        List<Integer> statsList = new ArrayList<>();

        statsList.add(stats.getStrength());
        statsList.add(stats.getDexterity());
        statsList.add(stats.getConstitution());
        statsList.add(stats.getIntelligence());
        statsList.add(stats.getWisdom());
        statsList.add(stats.getCharisma());

        return statsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public RegistrationStats getStats() {
        return stats;
    }

    public void setStats(RegistrationStats stats) {
        this.stats = stats;
    }
}
