package com.doctorya.Demo.infraestructure.entry_points;

import com.doctorya.Demo.domain.model.dto.commons.PatientDto;
import com.doctorya.Demo.domain.usecase.PatientUseCase;
import com.doctorya.Demo.infraestructure.wrapper.Wrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/v1/patient")
public class PatientController {
    private final PatientUseCase patientUseCase;

    @GetMapping()
    public ResponseEntity<Wrapper<PatientDto>> findAll(){
        log.info("Search All patient...");
        List<PatientDto> patients = patientUseCase.findAll();
        return patients.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(new Wrapper<>("patients", patients),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Wrapper<PatientDto>> findById(@RequestParam("id") Long id){
        log.info("Search patient for id...");
        PatientDto patient = patientUseCase.findById(id);
        return patient.getId() == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(new Wrapper<>("patient",List.of(patient)),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Wrapper<PatientDto>> saveOrUpdate(@RequestBody PatientDto patientDto){
        log.info("Saving patient ...");
        PatientDto patientSave = patientUseCase.saveOrUpdate(patientDto);
        return patientSave.getName() == null ?
                new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE) : new ResponseEntity<>(new Wrapper<>("patient",List.of(patientSave)),HttpStatus.CREATED);
    }
}
