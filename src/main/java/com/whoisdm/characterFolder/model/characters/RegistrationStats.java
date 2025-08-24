package com.whoisdm.characterFolder.model.characters;

import jakarta.validation.constraints.Min;

public class RegistrationStats {
    @Min(value = 1, message = "Stats are required!")
    private int strength;

    @Min(value = 1, message = "Stats are required!")
    private int dexterity;

    @Min(value = 1, message = "Stats are required!")
    private int constitution;

    @Min(value = 1, message = "Stats are required!")
    private int intelligence;

    @Min(value = 1, message = "Stats are required!")
    private int wisdom;

    @Min(value = 1, message = "Stats are required!")
    private int charisma;

    public RegistrationStats() {
    }

    public RegistrationStats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
