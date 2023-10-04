package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.model.NationalReport;
import spc.com.rccgphmbackend.model.QuarterlyReport;

import java.util.List;

public interface QuarterlyReportService {

    //Method create Quarterly report
    QuarterlyReport createReport(QuarterlyReport quarterlyReport);

    //Method Get All Quarterly Report
    List<QuarterlyReport> getAllReport();

    //Method Get A Single Quarterly Report By Id
    QuarterlyReport getReportById(String id);

    //Method Update Quarterly Report
    QuarterlyReport updateReport(QuarterlyReport quarterlyReport, String id);

    //Method DeleteQuarterly Report By Id
    void deleteReport(String id);
}
