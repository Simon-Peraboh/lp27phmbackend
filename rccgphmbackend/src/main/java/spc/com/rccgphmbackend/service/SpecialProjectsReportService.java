package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.model.SpecialProjectsReport;

import java.util.List;

public interface SpecialProjectsReportService {

    //Method to Save report details
    SpecialProjectsReport saveProjectReport (SpecialProjectsReport projectsReport);

    //Method to get all report details as list
    List<SpecialProjectsReport> getALLProjects();

    //Method to get single report by Id
    SpecialProjectsReport getSingleReport(String id);

    //Method to update or edit report details
    SpecialProjectsReport updateProjectReport(SpecialProjectsReport projectsReport, String id);

    //Method to delete report by Id
    void deleteProjectReport(String id);
}
