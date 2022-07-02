package com.mindex.challenge.controller;


import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingStructureController {

    private static Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingService;

    @GetMapping("/reportingstructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Recieved Read Request for Reporting Structure with employeeId: " + id);

        return reportingService.read(id);
    }
}
