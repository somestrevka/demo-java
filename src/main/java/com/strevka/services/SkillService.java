package com.strevka.services;

import com.strevka.dto.SkillDto;

public interface SkillService {
    public void addSkill(SkillDto newSkill);

    public void updateSkill(SkillDto updateSkill);

    public void deleteSkill(Long skillId);

    public SkillDto getSkillById(Long skillId);
}
