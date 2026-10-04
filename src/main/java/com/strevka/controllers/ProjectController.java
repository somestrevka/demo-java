package com.strevka.controllers;

import com.strevka.dto.ProjectDto;
import com.strevka.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ProjectDto getProject(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@Valid @RequestBody ProjectDto newProject) {
        projectService.addProject(newProject);
    }

    @DeleteMapping("/remove/{id}")
    public void removeProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
