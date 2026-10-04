package com.strevka.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SkillDto(@NotBlank @Size(max = 255) String name, Long id) {
}
