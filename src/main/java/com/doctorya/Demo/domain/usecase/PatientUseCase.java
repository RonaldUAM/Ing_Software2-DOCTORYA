package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.MedicalInsurance;
import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.dto.commons.PatientDto;
import com.doctorya.Demo.domain.model.gateways.PatientGateway;
import com.doctorya.Demo.domain.model.mapper.PatientDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
public class PatientUseCase {
    private final PatientGateway patientGateway;
    private final PatientDtoMapper patientDtoMapper;
    private final MedicalInsuranceUseCase insuranceUseCase;

    //Pruebas
    public PatientDto findById(Long id){
        try {
            return patientDtoMapper.toDo(patientGateway.findById(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return new PatientDto.Builder().build();
        }
    }

    public PatientDto saveOrUpdate(PatientDto patientDto){
        try {
            MedicalInsurance medicalInsurance = insuranceUseCase.save(patientDto.getInsurance());
            patientDto.getInsurance().setId(medicalInsurance.getId().getValue());
            Patient patient1 = patientGateway.saveOrUpdate(patientDtoMapper.toDoPatient(patientDto));
            if (patientDto.getId() == null || patientDto.getId().equals(Long.getLong("0"))){
                log.info("Patient create success...");
            }else {
                log.info("Patient update success...");
            }
            return patientDtoMapper.toDo(patient1);
        }catch (Exception e){
            log.info(e.getMessage());
            return new PatientDto.Builder().build();
        }
    }

    public void delete(Long id){
        try {
            patientGateway.deleteById(id);
            log.info("Delete patient by {}", id);
        }catch (Exception e){
            log.error("Error delete by {}",id);
            log.error(e.getMessage());
        }
    }

    //Pruebas
    public List<PatientDto> findAll(){
        return patientGateway.findAll().stream().map(patientDtoMapper::toDo).toList();
    }
}
