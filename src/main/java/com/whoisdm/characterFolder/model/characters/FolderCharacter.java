package com.whoisdm.characterFolder.model.characters;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class FolderCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "backstory")
    private String backstory;

    @Column(name = "owner_username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "class")
    private CharacterClass characterClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats")
    private CharacterStats characterStats;

    public FolderCharacter() {
    }

    public FolderCharacter(String name, String description, String backstory, String username, CharacterClass characterClass, CharacterStats characterStats) {
        this.name = name;
        this.description = description;
        this.backstory = backstory;
        this.username = username;
        this.characterClass = characterClass;
        this.characterStats = characterStats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public CharacterStats getCharacterStats() {
        return characterStats;
    }

    public void setCharacterStats(CharacterStats characterStats) {
        this.characterStats = characterStats;
    }

    @Override
    public String toString() {
        return "FolderCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", backstory='" + backstory + '\'' +
                ", username='" + username + '\'' +
                ", characterClass=" + characterClass +
                ", characterStats=" + characterStats +
                '}';
    }
}
