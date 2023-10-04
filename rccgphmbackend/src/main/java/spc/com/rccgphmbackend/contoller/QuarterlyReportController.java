/**
 * Created By SPC On
 * Date:15/09/2023
 * Time:00:08
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.model.QuarterlyReport;
import spc.com.rccgphmbackend.service.QuarterlyReportService;

import java.util.List;

@RestController
@RequestMapping("api/v1/quarterlyReport")
@AllArgsConstructor
public class QuarterlyReportController {

    //Inject Service Layer
    private QuarterlyReportService quarterlyReportService;

    // Build Create Quarterly Report REST API
    @PostMapping()
    public ResponseEntity<QuarterlyReport> create(@RequestBody QuarterlyReport quarterlyReport){
        return new ResponseEntity<>(quarterlyReportService.createReport(quarterlyReport), HttpStatus.CREATED);
    }

    // Build Get All Quarterly Report REST API
    @GetMapping()
    public List<QuarterlyReport> getAll(){
        return quarterlyReportService.getAllReport();
    }

    // Build Get Quarterly Report By Id  REST API
    @GetMapping("/{id}")
    public ResponseEntity<QuarterlyReport> getById(@PathVariable String id){
        return new ResponseEntity<>(quarterlyReportService.getReportById(id), HttpStatus.OK);
    }

    //Build Update Quarterly Report REST API
    @PutMapping("/{id}")
    public ResponseEntity<QuarterlyReport> updateReport(@RequestBody QuarterlyReport quarterlyReport, @PathVariable String id){
        return new ResponseEntity<>(quarterlyReportService.updateReport(quarterlyReport, id), HttpStatus.OK);
    }

    //Build Delete Quarterly Report By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable String id){
        quarterlyReportService.deleteReport(id);
        return new ResponseEntity<>("Delete Was Successful User With ID " + id, HttpStatus.OK);
    }

}
