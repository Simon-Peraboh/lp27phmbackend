/**
 * Created By SPC On
 * Date:12/09/2023
 * Time:00:17
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.MonthlyReport;
import spc.com.rccgphmbackend.repository.ReportRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService{

    //Inject Repository for db connection
    private ReportRepository reportRepository;

    @Override
    public MonthlyReport createReport(MonthlyReport monthlyReport) {
        monthlyReport.setId(UUID.randomUUID().toString().split("-")[0]);
        return reportRepository.save(monthlyReport);
    }

    @Override
    public List<MonthlyReport> getAllReport() {
        return reportRepository.findAll();
    }

    @Override
    public MonthlyReport getReportById(String id) {
        //Check if Id exist with Optional method or lambda
        return reportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID" + id + " Doesn't Exit"));
    }

    @Override
    public MonthlyReport updateReport(MonthlyReport monthlyReport, String id) {
        //Check if Id exist with Optional method or lambda
        MonthlyReport existingMonthlyReport = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This User With Id: " + id + " Doesn't Exist"));

        existingMonthlyReport.setState(monthlyReport.getState());
        existingMonthlyReport.setRegion(monthlyReport.getRegion());
        existingMonthlyReport.setSoulsWon(monthlyReport.getSoulsWon());
        existingMonthlyReport.setItems(monthlyReport.getItems());
        existingMonthlyReport.setTeamMembers(monthlyReport.getTeamMembers());
        existingMonthlyReport.setAmountSpent(monthlyReport.getAmountSpent());
        existingMonthlyReport.setPrisonVisited(monthlyReport.getPrisonVisited());
        existingMonthlyReport.setHospitalVisited(monthlyReport.getHospitalVisited());
        existingMonthlyReport.setPoliceStationVisited(monthlyReport.getPoliceStationVisited());
        existingMonthlyReport.setChallenges(monthlyReport.getChallenges());
        existingMonthlyReport.setRemarks(monthlyReport.getRemarks());
        existingMonthlyReport.setDate(monthlyReport.getDate());
        existingMonthlyReport.setProvince(monthlyReport.getProvince());
        existingMonthlyReport.setAmountBudgeted(monthlyReport.getAmountBudgeted());

        //Save Updated Data Into DB
        return reportRepository.save(existingMonthlyReport);
    }

    @Override
    public void deleteReport(String id) {
        //Check if Id exist with Optional method or lambda
        reportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID" + id + " Doesn't Exit"));
        reportRepository.deleteById(id);
    }
}
