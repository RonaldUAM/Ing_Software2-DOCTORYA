package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test_result;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test.TestData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Test_Results")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TestResultData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String diagnosis;
    private String possible_treatment;

    @OneToOne
    @JoinColumn(name = "test_id",referencedColumnName = "id")
    private TestData testData;

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private DoctorData doctorData;
}
