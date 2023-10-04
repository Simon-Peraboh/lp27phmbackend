/**
 * Created By SPC On
 * Date:14/09/2023
 * Time:23:07
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.QuarterlyReport;
import spc.com.rccgphmbackend.repository.QuarterlyReportRepository;

import java.util.List;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class QuarterlyReportServiceImpl implements QuarterlyReportService {

    //Inject Repository for db connection
    @Autowired
    private QuarterlyReportRepository quarterlyReportRepository;

    @Override
    public QuarterlyReport createReport(QuarterlyReport quarterlyReport) {
        //Convert String value of generated Id into random number
        quarterlyReport.setId(UUID.randomUUID().toString().split("-")[0]);
        return quarterlyReportRepository.save(quarterlyReport);
    }

    @Override
    public List<QuarterlyReport> getAllReport() {
        return quarterlyReportRepository.findAll();
    }

    @Override
    public QuarterlyReport getReportById(String id) {
        //Check if Id exist with Optional method or lambda
        return quarterlyReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
    }

    @Override
    public QuarterlyReport updateReport(QuarterlyReport quarterlyReport, String id) {
        //Check if Id exist with Optional method or lambda
        QuarterlyReport reportExist = quarterlyReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
        reportExist.setPeriod(quarterlyReport.getPeriod());
        reportExist.setTotalSouls(quarterlyReport.getTotalSouls());
        reportExist.setTotalAmount(quarterlyReport.getTotalAmount());
        reportExist.setCreationDate(quarterlyReport.getCreationDate());
        reportExist.setWhichYear(quarterlyReport.getWhichYear());

        //Save Update Into db
        return quarterlyReportRepository.save(reportExist);
    }

    @Override
    public void deleteReport(String id) {
        //Check if Id exist with Optional method or lambda
        quarterlyReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID" + id + " Doesn't Exit"));
        quarterlyReportRepository.deleteById(id);

    }
}
