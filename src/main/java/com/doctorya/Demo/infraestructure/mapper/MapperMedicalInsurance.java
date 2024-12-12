package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.MedicalInsurance;
import com.doctorya.Demo.domain.model.valueObjs.ContactPhone;
import com.doctorya.Demo.domain.model.valueObjs.EndDate;
import com.doctorya.Demo.domain.model.valueObjs.StartDate;
import com.doctorya.Demo.domain.model.valueObjs.Type;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_insurance.MedicalInsuranceData;
import org.springframework.stereotype.Component;

@Component
public class MapperMedicalInsurance {
    public MedicalInsurance toDo(MedicalInsuranceData medicalInsuranceData){
        return new MedicalInsurance.Builder()
                .id(new Id(medicalInsuranceData.getId()))
                .name(new Name(medicalInsuranceData.getName()))
                .type(new Type(medicalInsuranceData.getType()))
                .startDate(new StartDate(medicalInsuranceData.getStart_date()))
                .endDate(new EndDate(medicalInsuranceData.getEnd_date()))
                .contactPhone(new ContactPhone(medicalInsuranceData.getContact_phone()))
                .build();
    }

    public MedicalInsuranceData toData(MedicalInsurance medicalInsurance){
        return new MedicalInsuranceData().toBuilder()
                .id(medicalInsurance.getId() == null ?  Long.getLong("") : medicalInsurance.getId().getValue())
                .name(medicalInsurance.getName().getvalue())
                .type(medicalInsurance.getType().getValue())
                .start_date(medicalInsurance.getStartDate().getValue())
                .end_date(medicalInsurance.getEndDate().getValue())
                .contact_phone(medicalInsurance.getContactPhone().getValue())
                .build();
    }
}
