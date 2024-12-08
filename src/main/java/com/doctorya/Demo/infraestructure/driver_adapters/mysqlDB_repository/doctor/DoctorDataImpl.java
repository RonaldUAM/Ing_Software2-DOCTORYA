package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.gateways.DoctorGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperDoctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class DoctorDataImpl implements DoctorGateway {

    private final DoctorDataMysqlRepository repository;
    private final MapperDoctor mapper;

    @Override
    public Doctor findById(Long id) {
        Optional<DoctorData> doctorData = repository.findById(id);
        return doctorData.isEmpty() ?
                new Doctor.Builder().build() : mapper.toDo(doctorData.get());
    }

    @Override
    public List<Doctor> findAll() {
        return repository.findAll().stream().map(mapper::toDo).toList();
    }

    @Override
    public Doctor saveOrUpdate(Doctor doctor) {
        return mapper.toDo(repository.save(mapper.toData(doctor)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
