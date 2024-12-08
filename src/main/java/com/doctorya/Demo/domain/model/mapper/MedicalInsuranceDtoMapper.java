package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.MedicalInsurance;
import com.doctorya.Demo.domain.model.dto.MedicalInsuranceDto;
import com.doctorya.Demo.domain.model.valueObjs.ContactPhone;
import com.doctorya.Demo.domain.model.valueObjs.EndDate;
import com.doctorya.Demo.domain.model.valueObjs.StartDate;
import com.doctorya.Demo.domain.model.valueObjs.Type;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;

public class MedicalInsuranceDtoMapper {
    public MedicalInsurance toDoMedicalInsurance(MedicalInsuranceDto medicalInsuranceDto){
        return new MedicalInsurance.Builder()
                .id(medicalInsuranceDto.getId() == null ? new Id() : new Id(medicalInsuranceDto.getId()))
                .name(new Name(medicalInsuranceDto.getName()))
                .type(new Type(medicalInsuranceDto.getType()))
                .startDate(new StartDate(medicalInsuranceDto.getStartDate()))
                .endDate(new EndDate(medicalInsuranceDto.getEndDate()))
                .contactPhone(new ContactPhone(medicalInsuranceDto.getContactPhone()))
                .build();
    }

    public MedicalInsuranceDto toDo(MedicalInsurance medicalInsurance){
        return new MedicalInsuranceDto.Builder()
                .id(medicalInsurance.getId() == null ? null : medicalInsurance.getId().getValue())
                .name(medicalInsurance.getName().getvalue())
                .type(medicalInsurance.getType().getValue())
                .startDate(medicalInsurance.getStartDate().getValue())
                .endDate(medicalInsurance.getEndDate().getValue())
                .contactPhone(medicalInsurance.getContactPhone().getValue())
                .build();
    }
}
