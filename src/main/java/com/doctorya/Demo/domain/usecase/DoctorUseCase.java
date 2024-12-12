package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.dto.commons.DoctorDto;
import com.doctorya.Demo.domain.model.gateways.DoctorGateway;
import com.doctorya.Demo.domain.model.mapper.DoctorDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;


@RequiredArgsConstructor
@Log4j2
public class DoctorUseCase {
    private final DoctorGateway doctorGateway;
    private final DoctorDtoMapper doctorDtoMapper;

    public DoctorDto saveOrUpdate(DoctorDto doctorDto){
        try {
            Doctor doctor = doctorGateway.saveOrUpdate(doctorDtoMapper.toDoctor(doctorDto));
            if (doctorDto.getId() == null || doctorDto.getId().equals(Long.getLong("0"))){
                log.info("Patient create success...");
            }else {
                log.info("Patient update success...");
            }
            return doctorDtoMapper.toDo(doctor);
        }catch (Exception e){
            log.error(e.getMessage());
            return new DoctorDto();
        }
    }

    public boolean delete(Long id){
        try {
            doctorGateway.deleteById(id);
            log.info("Delete Account Doctor by ID {}",id);
            return true;
        } catch (Exception e) {
            log.error("Error delete Account Doctor : {}",e.getMessage());
            return false;
        }
    }

    public List<DoctorDto> findAll(){
        return doctorGateway.findAll().stream().map(doctorDtoMapper::toDo).toList();
    }

}
