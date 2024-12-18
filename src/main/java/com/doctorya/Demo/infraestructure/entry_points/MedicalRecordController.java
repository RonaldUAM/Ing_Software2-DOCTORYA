package com.doctorya.Demo.infraestructure.entry_points;

import com.doctorya.Demo.domain.model.dto.create.MedicalRecordDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.MedicalRecordDtoFind;
import com.doctorya.Demo.domain.usecase.MedicalRecordUseCase;
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
@RequestMapping("/api/v1/medicalRecord")
public class MedicalRecordController {
    private final MedicalRecordUseCase medicalRecordUseCase;

    @PostMapping()
    public ResponseEntity<Wrapper<MedicalRecordDtoFind>> save(MedicalRecordDtoCreate medicalRecordDtoCreate){
        MedicalRecordDtoFind medicalRecordDtoFind1 = medicalRecordUseCase.save(medicalRecordDtoCreate);
        if (medicalRecordDtoFind1.getDate() == null){
            return new ResponseEntity<>(new Wrapper<>("MedicalRecord ",List.of()),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Wrapper<>("MedicalRecord ", List.of(medicalRecordDtoFind1)), HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestParam("id") Long id){
        if (medicalRecordUseCase.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
}
