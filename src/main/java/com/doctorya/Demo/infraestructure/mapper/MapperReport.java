package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Report;
import com.doctorya.Demo.domain.model.valueObjs.Content;
import com.doctorya.Demo.domain.model.valueObjs.Type;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.report.ReportData;
import org.springframework.stereotype.Component;

@Component
public class MapperReport {
    public Report toDo(ReportData reportData){
        return new Report.Builder()
                .id(new Id(reportData.getId()))
                .date(new Date(reportData.getDate()))
                .type(new Type(reportData.getReport_type()))
                .content(new Content(reportData.getContent()))
                .build();
    }
}
