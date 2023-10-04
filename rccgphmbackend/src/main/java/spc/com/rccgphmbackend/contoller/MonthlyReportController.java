/**
 * Created By SPC On
 * Date:12/09/2023
 * Time:14:55
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.model.MonthlyReport;
import spc.com.rccgphmbackend.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("api/v1/nationalMonthlyReport")
@AllArgsConstructor
public class MonthlyReportController {

    //Inject Service Layer
    private ReportService reportService;

    // Build Create Report REST API
    @PostMapping()
    public ResponseEntity<MonthlyReport> create(@RequestBody MonthlyReport monthlyReport){
        return new ResponseEntity<>(reportService.createReport(monthlyReport), HttpStatus.CREATED);
    }

    // Get All Report REST API
    @GetMapping()
    public List<MonthlyReport> getAll(){
        return reportService.getAllReport();
    }

    //Get Report By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<MonthlyReport> getReport(@PathVariable String id){
        return new ResponseEntity<>(reportService.getReportById(id), HttpStatus.OK);
    }

    //Update Report By Id API
    @PutMapping("/{id}")
    public ResponseEntity<MonthlyReport> update(@RequestBody MonthlyReport monthlyReport, @PathVariable String id){
        return new ResponseEntity<>(reportService.updateReport(monthlyReport, id), HttpStatus.OK);
    }

    //Build Delete Report By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable String id){
        reportService.deleteReport(id);
        return new ResponseEntity<>("Delete Was Successful User With ID " + id, HttpStatus.OK);
    }

}
