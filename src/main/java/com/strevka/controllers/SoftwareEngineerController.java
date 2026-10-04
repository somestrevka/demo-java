package com.strevka.controllers;

import com.strevka.dto.SoftwareEngineerDto;
import com.strevka.services.impl.SoftwareEngineerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerServiceImpl softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerServiceImpl softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineerDto> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewSoftwareEngineer(@Valid @RequestBody SoftwareEngineerDto newEngineer) {
        softwareEngineerService.insertSoftwareEngineer(newEngineer);
    }

    @GetMapping("/{id}")
    public SoftwareEngineerDto getEngineerById(@PathVariable Long id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }
}
