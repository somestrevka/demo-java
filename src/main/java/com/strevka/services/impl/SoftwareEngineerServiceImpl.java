package com.strevka.services.impl;

import com.strevka.dto.SkillDto;
import com.strevka.dto.SoftwareEngineerDto;
import com.strevka.exceptions.NotFoundException;
import com.strevka.models.SoftwareEngineer;
import com.strevka.repositories.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SoftwareEngineerServiceImpl implements com.strevka.services.SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerServiceImpl(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineerDto> getAllSoftwareEngineers() {
        return softwareEngineerRepository
                .findAll()
                .stream()
                .map(engineer -> fromModel2Dto(engineer))
                .toList();
    }

    public void insertSoftwareEngineer(SoftwareEngineerDto newEngineer) {
        softwareEngineerRepository.save(new SoftwareEngineer(newEngineer));
    }

    public SoftwareEngineerDto getSoftwareEngineerById(Long id) {
        Optional<SoftwareEngineer> foundEngineer = softwareEngineerRepository.findById(id);
        return foundEngineer.map(softwareEngineer -> fromModel2Dto(softwareEngineer))
                .orElseThrow(() -> new NotFoundException("Engineer " + id + " not found"));
    }

    private SoftwareEngineerDto fromModel2Dto(SoftwareEngineer engineer) {
        return new SoftwareEngineerDto(engineer.getId(),
                engineer.getName(),
                engineer.getSkills().
                        stream().
                        map(skill -> new SkillDto(skill.getName(), skill.getId())).
                        collect(Collectors.toSet()));
    }
}
