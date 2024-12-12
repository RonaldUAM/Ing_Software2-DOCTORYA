package com.doctorya.Demo.domain.model.dto.commons;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalInsuranceDto implements Serializable {
    private Long id;
    private String name;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private String contactPhone;

    public MedicalInsuranceDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private MedicalInsuranceDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.contactPhone = builder.contactPhone;

    }

    public static class Builder extends AbstractBuilder<MedicalInsuranceDto> {
        private Long id;
        private String name;
        private String type;
        private LocalDate startDate;
        private LocalDate endDate;
        private String contactPhone;

        public MedicalInsuranceDto.Builder id(Long id){
            this.id = id;
            return this;
        }

        public MedicalInsuranceDto.Builder name(String name){
            this.name = name;
            return this;
        }

        public MedicalInsuranceDto.Builder type(String type){
            this.type = type;
            return this;
        }

        public MedicalInsuranceDto.Builder startDate(LocalDate startDate){
            this.startDate = startDate;
            return this;
        }

        public MedicalInsuranceDto.Builder endDate(LocalDate endDate){
            this.endDate = endDate;
            return this;
        }

        public MedicalInsuranceDto.Builder contactPhone(String contactPhone){
            this.contactPhone = contactPhone;
            return this;
        }

        @Override
        public MedicalInsuranceDto build() {
            return new MedicalInsuranceDto(this);
        }
    }
}
