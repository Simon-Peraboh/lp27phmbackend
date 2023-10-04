package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.model.MonthlyDuePayment;

import java.util.List;

public interface MonthlyDuePaymentService {

    //Method to save report into db
    MonthlyDuePayment saveReport(MonthlyDuePayment duePayment);

    //Method to get all report as list
    List<MonthlyDuePayment> getAll();

    //Method Get a single report by Id
    MonthlyDuePayment getReportById(String id);

    //Method to update or edit report
    MonthlyDuePayment updateReport(MonthlyDuePayment duePayment, String id);

    //Method to delete report by id
    void deleteReport(String id);


}
