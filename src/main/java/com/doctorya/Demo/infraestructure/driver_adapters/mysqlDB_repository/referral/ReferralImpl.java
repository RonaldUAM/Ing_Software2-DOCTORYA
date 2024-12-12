package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.referral;

import com.doctorya.Demo.domain.model.Referral;
import com.doctorya.Demo.domain.model.gateways.ReferralGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperReferral;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReferralImpl implements ReferralGateway {
    private final ReferralDataMysqlRepository repository;
    private final MapperReferral mapper;
    @Override
    public Referral findById(Long id) {
        Optional<ReferralData> referralData = repository.findById(id);
        return referralData.isEmpty() ?
                new Referral.Builder().build() : mapper.toDo(referralData.get());
    }
}
