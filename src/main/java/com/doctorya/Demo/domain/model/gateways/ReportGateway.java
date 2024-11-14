package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Report;

import java.util.List;

public interface ReportGateway {
    List<Report> findAll();
}
