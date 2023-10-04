/**
 * Created By SPC On
 * Date:14/09/2023
 * Time:23:43
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.model.NationalReport;
import spc.com.rccgphmbackend.service.NationalReportService;

import java.util.List;

@RestController
@RequestMapping("api/v1/nationReport")
public class NationalReportController {

    //Inject Service Layer
    @Autowired
    private NationalReportService nationalReportService;

    // Build Create National Report REST API
    @PostMapping()
    public ResponseEntity<NationalReport> create(@RequestBody NationalReport nationalReport){
        return new ResponseEntity<>(nationalReportService.createReport(nationalReport), HttpStatus.CREATED);
    }

    // Build Get All National Report REST API
    @GetMapping()
    public List<NationalReport> getAll(){
        return nationalReportService.getAllReport();
    }

    // Build Get National Report By Id  REST API
    @GetMapping("/{id}")
    public ResponseEntity<NationalReport> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(nationalReportService.getReportById(id), HttpStatus.OK);
    }

    //Build Update National Report REST API
    @PutMapping("/{id}")
    public ResponseEntity<NationalReport> update(@RequestBody NationalReport nationalReport, @PathVariable String id){
        return new ResponseEntity<>(nationalReportService.updateReport(nationalReport, id), HttpStatus.OK);
    }

    //Build Delete National Report By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        nationalReportService.deleteById(id);
        return new ResponseEntity<>("Delete Was Successful User With ID " + id , HttpStatus.OK);
    }

}
