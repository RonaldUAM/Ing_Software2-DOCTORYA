package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Referral;

public interface ReferralGateway {
    Referral findById(Long id);
}
