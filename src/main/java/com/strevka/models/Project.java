package com.strevka.models;

import com.strevka.dto.ProjectDto;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Project() {

    }

    public Project(String name) {
        this.name = name;
    }

    public Project(ProjectDto projectDto) {
        this.name = projectDto.name();
        this.id = projectDto.id();
        this.requiredSkills = projectDto.skills().
                stream().
                map(skillDto -> new Skill(skillDto)).
                collect(Collectors.toSet());
    }

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

    @ManyToMany
    @JoinTable(name = "project_requirement",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> requiredSkills = new HashSet<>();
}
