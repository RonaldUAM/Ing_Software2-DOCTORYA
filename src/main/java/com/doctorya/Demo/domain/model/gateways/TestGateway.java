package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Test;

import java.util.List;

public interface TestGateway {
    List<Test> findAll();
}
