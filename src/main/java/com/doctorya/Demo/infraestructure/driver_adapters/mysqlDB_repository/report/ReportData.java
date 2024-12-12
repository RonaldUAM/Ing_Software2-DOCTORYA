package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.report;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Reports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private String report_type;
    private String content;
}
