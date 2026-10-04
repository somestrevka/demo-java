package com.strevka.services;

import com.strevka.dto.ProjectDto;

public interface ProjectService {
    public void addProject(ProjectDto newProject);

    public void updateProject(ProjectDto updateProject);

    public void deleteProject(Long projectId);

    public ProjectDto getProjectById(Long projectId);
}
