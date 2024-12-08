package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.Schedule;

import java.util.List;

public interface ScheduleGateway {
    Schedule saveOrUpdate(Schedule schedule);
}
