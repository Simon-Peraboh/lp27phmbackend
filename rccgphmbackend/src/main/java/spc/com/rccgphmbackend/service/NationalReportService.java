package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.model.NationalReport;

import java.util.List;

public interface NationalReportService {

    //Method create report
    NationalReport createReport(NationalReport nationalReport);

    //Method Get All National Report
    List<NationalReport> getAllReport();

    //Method Get A Single National Report By Id
    NationalReport getReportById(String id);

    //Method Update National Report
    NationalReport updateReport(NationalReport nationalReport, String id);

    //Method Delete Report By Id
    void deleteById(String id);
}
