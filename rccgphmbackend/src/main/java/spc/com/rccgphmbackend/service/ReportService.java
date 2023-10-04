package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.model.MonthlyReport;

import java.util.List;

public interface ReportService{

    //Create & Save Report into db method
    MonthlyReport createReport(MonthlyReport monthlyReport);

    //Get All Report As List
    List<MonthlyReport> getAllReport();

    //Get a Single Report by ID
    MonthlyReport getReportById(String id);

    //Update Report By Id
    MonthlyReport updateReport(MonthlyReport monthlyReport, String id);

    //Delete Report By Id
    void deleteReport(String id);

}
