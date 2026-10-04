package com.strevka.controllers;

import com.strevka.dto.SoftwareEngineerDto;
import com.strevka.services.impl.SoftwareEngineerService;
import com.strevka.models.SoftwareEngineer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineerDto> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }


    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineerDto newEngineer) {
        softwareEngineerService.insertSoftwareEngineer(newEngineer);
    }

    @GetMapping("/{id}")
    public SoftwareEngineerDto getEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }
}
