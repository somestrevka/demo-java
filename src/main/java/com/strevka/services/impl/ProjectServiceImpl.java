package com.strevka.services.impl;

import com.strevka.dto.ProjectDto;
import com.strevka.dto.SkillDto;
import com.strevka.exceptions.NotFoundException;
import com.strevka.models.Project;
import com.strevka.repositories.ProjectRepository;
import com.strevka.services.ProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository ProjectRepository;

    public ProjectServiceImpl(ProjectRepository ProjectRepository) {
        this.ProjectRepository = ProjectRepository;
    }

    @Override
    @Transactional
    public void addProject(ProjectDto newProject) {
        ProjectRepository.save(new Project(newProject));
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto getProjectById(Long ProjectId) {
        Optional<Project> foundProject = ProjectRepository.findById(ProjectId);
        return foundProject.map(foundS -> new ProjectDto(foundS.getId(),
                        foundS.getName(),
                        foundS.getRequiredSkills()
                                .stream()
                                .map(skill -> new SkillDto(skill.getName(), skill.getId()))
                                .collect(Collectors.toSet())))
                .orElseThrow(() -> new NotFoundException("Project " + ProjectId + " not found"));
    }


    @Override
    @Transactional
    public void updateProject(ProjectDto updateProject) {
        ProjectRepository.save(new Project(updateProject));
    }

    @Override
    public void deleteProject(Long ProjectId) {
        ProjectRepository.deleteById(ProjectId);
    }
}
