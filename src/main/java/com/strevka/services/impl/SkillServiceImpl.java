package com.strevka.services.impl;

import com.strevka.dto.SkillDto;
import com.strevka.exceptions.NotFoundException;
import com.strevka.models.Skill;
import com.strevka.repositories.SkillRepository;
import com.strevka.services.SkillService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void addSkill(SkillDto newSkill) {
        skillRepository.save(new Skill(newSkill.name()));
    }

    @Override
    public SkillDto getSkillById(Long skillId) {
        Optional<Skill> foundSkill = skillRepository.findById(skillId);
        return foundSkill.map(foundS -> new SkillDto(foundS.getName(), foundS.getId()))
                .orElseThrow(() -> new NotFoundException("Skill " + skillId + " not found"));
    }


    @Override
    public void updateSkill(SkillDto updateSkill) {
        skillRepository.save(new Skill(updateSkill));
    }

    @Override
    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }
}
