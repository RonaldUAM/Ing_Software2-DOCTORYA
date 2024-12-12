package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.valueObjs.*;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment.AppointmentData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperAppointment {
    private final MapperDoctor mapperDoctor;
    private final MapperPatient mapperPatient;
    public Appointment toDo(AppointmentData appointmentData){
        return new Appointment.Builder()
                .id(new Id(appointmentData.getId()))
                .date(new Date(appointmentData.getDate()))
                .time(new Time(appointmentData.getTime()))
                .reason(new Reason(appointmentData.getReason()))
                .status(new Status(appointmentData.getStatus()))
                .patient(mapperPatient.toDo(appointmentData.getPatient()))
                .doctor(mapperDoctor.toDo(appointmentData.getDoctor()))
                .build();
    }

    public AppointmentData toData(Appointment appointment){
        return new AppointmentData().toBuilder()
                .id(appointment.getId().getValue())
                .date(appointment.getDate().getValue())
                .time(appointment.getTime().getValue())
                .reason(appointment.getReason().getValue())
                .status(appointment.getStatus().getValue())
                .patient(mapperPatient.toData(appointment.getPatient()))
                .doctor(mapperDoctor.toData(appointment.getDoctor()))
                .build();
    }
}
