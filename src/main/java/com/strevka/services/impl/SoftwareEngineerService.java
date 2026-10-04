package com.strevka.services.impl;

import com.strevka.dto.SoftwareEngineerDto;
import com.strevka.models.SoftwareEngineer;
import com.strevka.repositories.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService implements com.strevka.services.SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineerDto> getAllSoftwareEngineers() {
        return softwareEngineerRepository
                .findAll()
                .stream()
                .map(engineer -> new SoftwareEngineerDto(engineer.getName()))
                .toList();
    }

    public void insertSoftwareEngineer(SoftwareEngineerDto newEngineer) {
        softwareEngineerRepository.save(new SoftwareEngineer(newEngineer));
    }

    public SoftwareEngineerDto getSoftwareEngineerById(Integer id) {
        Optional<SoftwareEngineer> foundEngineer = softwareEngineerRepository.findById(id);
        return foundEngineer.map(softwareEngineer -> new SoftwareEngineerDto(softwareEngineer.getName()))
                .orElse(null);
    }
}
