package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public ReportingStructure read(String id) {
        Employee emp = employeeService.read(id);
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployeeId(emp.getEmployeeId());
        if(emp.getDirectReports().size() == 0 || emp.getDirectReports() == null)    {
            reportingStructure.setNumberOfReports(0);
            return reportingStructure;
        }
        reportingStructure.setNumberOfReports(findNumberOfReports(emp.getDirectReports()));

        return reportingStructure;
    }

private int findNumberOfReports(List<Employee> reports)   {
    if(reports == null || reports.size() == 0)   {
        return 0;
    }
    int temp = reports.size();
    for(int i = 0; i < reports.size(); i++) {
    temp += findNumberOfReports(employeeService.read(reports.get(i).getEmployeeId()).getDirectReports());
    }
    return temp;
}
}
