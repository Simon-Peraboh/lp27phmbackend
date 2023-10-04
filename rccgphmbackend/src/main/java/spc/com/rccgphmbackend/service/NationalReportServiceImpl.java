/**
 * Created By SPC On
 * Date:14/09/2023
 * Time:22:54
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.NationalReport;
import spc.com.rccgphmbackend.repository.NationalReportRepository;

import java.util.List;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class NationalReportServiceImpl implements NationalReportService{

    //Inject Repository for db connection
    @Autowired
    private NationalReportRepository nationalReportRepository;

    @Override
    public NationalReport createReport(NationalReport nationalReport) {
        //Convert String value of generated Id into random number
        nationalReport.setId(UUID.randomUUID().toString().split("-")[0]);
        return nationalReportRepository.save(nationalReport);
    }

    @Override
    public List<NationalReport> getAllReport() {
        return nationalReportRepository.findAll();
    }

    @Override
    public NationalReport getReportById(String id) {
        //Check if Id exist with Optional method or lambda
        return nationalReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
    }

    @Override
    public NationalReport updateReport(NationalReport nationalReport, String id) {
        //Check if Id exist with Optional method or lambda
        NationalReport reportExist = nationalReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
        reportExist.setCoreDuties(nationalReport.getCoreDuties());
        reportExist.setMonthlyTask(nationalReport.getMonthlyTask());
        reportExist.setTaskDone(nationalReport.getTaskDone());
        reportExist.setStrength(nationalReport.getStrength());
        reportExist.setWeakness(nationalReport.getWeakness());
        reportExist.setOpportunities(nationalReport.getOpportunities());
        reportExist.setThreats(nationalReport.getThreats());
        reportExist.setAmountBudgeted(nationalReport.getAmountBudgeted());
        reportExist.setAmountSpent(nationalReport.getAmountSpent());
        reportExist.setRemarks(nationalReport.getRemarks());
        reportExist.setCreatedDate(nationalReport.getCreatedDate());

        //Save updated data into db
        return nationalReportRepository.save(reportExist);
    }

    @Override
    public void deleteById(String id) {
        //Check if Id exist with Optional method or lambda
        nationalReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
        nationalReportRepository.deleteById(id);
    }
}
