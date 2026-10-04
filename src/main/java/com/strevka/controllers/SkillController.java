package com.strevka.controllers;

import com.strevka.dto.SkillDto;
import com.strevka.services.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/{id}")
    public SkillDto getSkill(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSkill(@Valid @RequestBody SkillDto newSkill) {
        skillService.addSkill(newSkill);
    }

    @DeleteMapping("/remove/{id}")
    public void removeSkill(@PathVariable("id") Long skillId) {
        skillService.deleteSkill(skillId);
    }
}
