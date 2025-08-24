package com.whoisdm.characterFolder.model.characters;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class CharacterClass {
    @Id
    @Column(name = "class_name")
    private String className;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "class_role")
    private String classRole;

    @Column(name = "main_stat")
    private String mainStat;

    @Column(name = "sub_stat")
    private String subStat;

    public CharacterClass() {
    }

    public CharacterClass(String className, String classType, String classRole, String mainStat, String subStat) {
        this.className = className;
        this.classType = classType;
        this.classRole = classRole;
        this.mainStat = mainStat;
        this.subStat = subStat;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassRole() {
        return classRole;
    }

    public void setClassRole(String classRole) {
        this.classRole = classRole;
    }

    public String getMainStat() {
        return mainStat;
    }

    public void setMainStat(String mainStat) {
        this.mainStat = mainStat;
    }

    public String getSubStat() {
        return subStat;
    }

    public void setSubStat(String subStat) {
        this.subStat = subStat;
    }

    @Override
    public String toString() {
        return "CharacterClass{" +
                "className='" + className + '\'' +
                ", classType='" + classType + '\'' +
                ", classRole='" + classRole + '\'' +
                ", mainStat='" + mainStat + '\'' +
                ", subStat='" + subStat + '\'' +
                '}';
    }
}
