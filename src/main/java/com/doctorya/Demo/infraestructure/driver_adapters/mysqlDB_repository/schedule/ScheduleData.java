package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.schedule;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Schedule")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class ScheduleData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer hour;
    private Integer day;
    private Integer month;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private DoctorData doctorData;
}
