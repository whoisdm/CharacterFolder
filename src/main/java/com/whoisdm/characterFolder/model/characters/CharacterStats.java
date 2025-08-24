package com.whoisdm.characterFolder.model.characters;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stats")
public class CharacterStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stats_id")
    private int id;

    @Column(name = "strength")
    private int strength;

    @Column(name = "dexterity")
    private int dexterity;

    @Column(name = "constitution")
    private int constitution;

    @Column(name = "intelligence")
    private int intelligence;

    @Column(name = "wisdom")
    private int wisdom;

    @Column(name = "charisma")
    private int charisma;

    public CharacterStats() {}

    public CharacterStats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public CharacterStats(List<Integer> stats) {
        this.strength = stats.get(0);
        this.dexterity = stats.get(1);
        this.constitution = stats.get(2);
        this.intelligence = stats.get(3);
        this.wisdom = stats.get(4);
        this.charisma = stats.get(5);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CharacterStats{" +
                "STR=" + strength +
                ", DEX=" + dexterity +
                ", CON=" + constitution +
                ", INT=" + intelligence +
                ", WIS=" + wisdom +
                ", CHA=" + charisma +
                '}';
    }
}
