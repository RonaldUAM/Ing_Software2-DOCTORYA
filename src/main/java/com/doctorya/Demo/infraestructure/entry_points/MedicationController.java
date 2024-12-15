package com.doctorya.Demo.infraestructure.entry_points;

import com.doctorya.Demo.domain.model.dto.create.MedicationDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.MedicationDtoFind;
import com.doctorya.Demo.domain.usecase.MedicationUseCase;
import com.doctorya.Demo.infraestructure.wrapper.Wrapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/api/v1/medication")
public class MedicationController {
    private final MedicationUseCase medicationUseCase;

    @PostMapping()
    public ResponseEntity<Wrapper<MedicationDtoFind>> save(MedicationDtoCreate medicationDtoCreate) {
        MedicationDtoFind medicationDtoFind = medicationUseCase.save(medicationDtoCreate);
        if (medicationDtoFind.getName() == null) {
            return new ResponseEntity<>(new Wrapper<>("Medication", List.of()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Wrapper<>("Medication", List.of(medicationDtoFind)), HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestParam("id") Long id) {
        if (medicationUseCase.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}