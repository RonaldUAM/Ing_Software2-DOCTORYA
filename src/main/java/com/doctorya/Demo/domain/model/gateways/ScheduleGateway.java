package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Schedule;

import java.util.List;

public interface ScheduleGateway {
    List<Schedule> findByAll();
}
