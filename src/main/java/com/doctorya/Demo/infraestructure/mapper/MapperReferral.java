package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Referral;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Reason;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.referral.ReferralData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperReferral {
    private final MapperMedicalRecord mapperMedicalRecord;
    private final MapperDoctor mapperDoctor;

    public Referral toDo(ReferralData referralData){
        return new Referral.Builder()
                .id(new Id(referralData.getId()))
                .date(new Date(referralData.getDate()))
                .reason(new Reason(referralData.getReason_for_referral()))
                .doctor(mapperDoctor.toDo(referralData.getDoctorData()))
                .medicalRecord(mapperMedicalRecord.toDo(referralData.getMedicalRecordData()))
                .build();
    }
}
