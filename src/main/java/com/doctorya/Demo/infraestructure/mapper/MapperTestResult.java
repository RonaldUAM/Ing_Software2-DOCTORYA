package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Test;
import com.doctorya.Demo.domain.model.TestResult;
import com.doctorya.Demo.domain.model.valueObjs.PossibleTreatment;
import com.doctorya.Demo.domain.model.valueObjs.commons.Diagnosis;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test_result.TestResultData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperTestResult {
    private final MapperDoctor mapperDoctor;
    private final MapperTest mapperTest;

    public TestResult toDo(TestResultData testResultData){
        return new TestResult.Builder()
                .id(new Id(testResultData.getId()))
                .diagnosis(new Diagnosis(testResultData.getDiagnosis()))
                .possibleTreatment(new PossibleTreatment(testResultData.getPossible_treatment()))
                .test(mapperTest.toDo(testResultData.getTestData()))
                .doctor(mapperDoctor.toDo(testResultData.getDoctorData()))
                .build();
    }
}
