package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Test;
import com.doctorya.Demo.domain.model.valueObjs.Cost;
import com.doctorya.Demo.domain.model.valueObjs.InsuranceCoverage;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test.TestData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperTest {
    private final MapperMedicalRecord mapperMedicalRecord;
    public Test toDo(TestData testData){
        return new Test.Builder()
                .id(new Id(testData.getId()))
                .name(new Name(testData.getName()))
                .cost(new Cost(testData.getCost()))
                .insuranceCoverage(new InsuranceCoverage(testData.getInsurance_coverage()))
                .status(new Status(testData.getStatus()))
                .medicalRecord(mapperMedicalRecord.toDo(testData.getMedicalRecordData()))
                .build();
    }
}
