package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.MedicalInsurance;
import com.doctorya.Demo.domain.model.dto.MedicalInsuranceDto;
import com.doctorya.Demo.domain.model.gateways.MedicalInsuranceGateway;
import com.doctorya.Demo.domain.model.mapper.MedicalInsuranceDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class MedicalInsuranceUseCase {
    private final MedicalInsuranceGateway medicalInsuranceGateway;
    private final MedicalInsuranceDtoMapper insuranceDtoMapper;

    public MedicalInsurance save(MedicalInsuranceDto medicalInsuranceDto){
        log.info("Saving MedicalInsurance ...");
        return medicalInsuranceGateway.save(insuranceDtoMapper.toDoMedicalInsurance(medicalInsuranceDto));
    }
}
