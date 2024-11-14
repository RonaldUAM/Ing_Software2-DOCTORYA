package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.TestResult;

import java.util.List;

public interface TestResultGateway {
    List<TestResult> findAll();
}
