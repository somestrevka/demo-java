package com.strevka.models;

import com.strevka.dto.SoftwareEngineerDto;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "engineer_skill",
            joinColumns = @JoinColumn(name = "engineer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(SoftwareEngineerDto softwareEngineerDto) {
        this.name = softwareEngineerDto.name();
        this.skills = softwareEngineerDto.skills().
                stream().
                map(skillDto -> new Skill(skillDto)).
                collect(Collectors.toSet());;
    }

    public SoftwareEngineer(Long id,
                            String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
