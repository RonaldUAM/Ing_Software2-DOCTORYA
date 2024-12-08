package com.doctorya.Demo.infraestructure.entry_points;

import com.doctorya.Demo.domain.model.dto.DoctorDto;
import com.doctorya.Demo.domain.usecase.DoctorUseCase;
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
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    private final DoctorUseCase doctorUseCase;

    @GetMapping
    public ResponseEntity<Wrapper<DoctorDto>> findAll(){
        List<DoctorDto> doctorDtos = doctorUseCase.findAll();
        if (doctorDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Wrapper<>("Doctor's",doctorDtos),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Wrapper<DoctorDto>> saveOrUpdate(@RequestBody DoctorDto doctorDto){
        log.info("Saving doctor...");
        DoctorDto doctorDto1 = doctorUseCase.saveOrUpdate(doctorDto);
        return doctorDto1.getName() == null ?
                new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE) : new ResponseEntity<>(new Wrapper<>("doctor", List.of(doctorDto1)),HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestParam Long id){
        if (doctorUseCase.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
