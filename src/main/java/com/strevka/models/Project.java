package com.strevka.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "project_requirement",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> requiredSkills = new HashSet<>();

    public Set<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
