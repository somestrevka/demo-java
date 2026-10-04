package com.strevka.services;

import com.strevka.dto.SoftwareEngineerDto;
import java.util.List;

public interface SoftwareEngineerService {
    public List<SoftwareEngineerDto> getAllSoftwareEngineers();

    public void insertSoftwareEngineer(SoftwareEngineerDto newEngineer);

    public SoftwareEngineerDto getSoftwareEngineerById(Long id);
}
