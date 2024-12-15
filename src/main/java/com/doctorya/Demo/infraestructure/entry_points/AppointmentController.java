package com.doctorya.Demo.infraestructure.entry_points;

import com.doctorya.Demo.domain.model.dto.create.AppointmentDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.AppointmentDtoFind;
import com.doctorya.Demo.domain.model.dto.commons.DoctorDto;
import com.doctorya.Demo.domain.usecase.AppointmentUseCase;
import com.doctorya.Demo.infraestructure.wrapper.Wrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    private final AppointmentUseCase appointmentUseCase;

    @GetMapping
    public ResponseEntity<Wrapper<AppointmentDtoFind>> findAll(){
        return new ResponseEntity<>(new Wrapper<>("Appointment's ",appointmentUseCase.findAll()),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Wrapper<AppointmentDtoFind>> createAppointmet(@RequestBody AppointmentDtoCreate appointmentDtoCreate){
        AppointmentDtoFind appointmentDtoFind1 = appointmentUseCase.createAppointment(appointmentDtoCreate);
        if (appointmentDtoFind1.getId() == null){
            return new ResponseEntity<>(new Wrapper<>("Appointment", List.of()), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(new Wrapper<>("Appoinment", List.of(appointmentDtoFind1)),HttpStatus.CREATED);
    }

    @GetMapping("/searchDoctorAvailable")
    public ResponseEntity<Wrapper<DoctorDto>> findDoctorByAppointmentAvailable(@RequestParam("time")LocalTime time, @RequestParam("date")LocalDate date){
        List<DoctorDto> doctorAvailable = appointmentUseCase.findDoctorByAppointmentAvailable(time,date);
        if (doctorAvailable.isEmpty()){
            return new ResponseEntity<>(new Wrapper<>("Appointment -> [Doctor_Available]", List.of()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Wrapper<>("Appointment -> [Doctor_Available]", doctorAvailable), HttpStatus.CREATED);
    }

    @GetMapping("/searchAppoinmentPatient")
    public ResponseEntity<Wrapper<AppointmentDtoFind>> findByPatient(@RequestParam("patient_id") Long patient_id){
        return new ResponseEntity<>(new Wrapper<>("Appointment -> [Patient]",appointmentUseCase.findByPatient(patient_id)),HttpStatus.OK);
    }

}
