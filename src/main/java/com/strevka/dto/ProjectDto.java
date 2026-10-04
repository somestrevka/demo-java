package com.strevka.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record ProjectDto(Long id, @NotBlank @Size(max = 255) String name,
                         @NotNull Set<SkillDto> skills) {
}
