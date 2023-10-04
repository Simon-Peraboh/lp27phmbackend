/**
 * Created By SPC On
 * Date:22/09/2023
 * Time:19:37
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.model.MonthlyDuePayment;
import spc.com.rccgphmbackend.service.MonthlyDuePaymentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/monthlyDuesReport")
@AllArgsConstructor
public class MonthlyDuePaymentController {

    //Inject Service to use methods
    private MonthlyDuePaymentService duePaymentService;

    // Build Create Monthly Due Report REST API
    @PostMapping()
    public ResponseEntity<MonthlyDuePayment> createReport(@RequestBody MonthlyDuePayment duePayment){
        return new ResponseEntity<>(duePaymentService.saveReport(duePayment), HttpStatus.CREATED);
    }

    // Build Get All Monthly Due Report REST API
    @GetMapping()
    public List<MonthlyDuePayment> getReportAll(){
        return duePaymentService.getAll();
    }

    // Build Get Monthly Due Report By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<MonthlyDuePayment> getById(@PathVariable String id){
        return new ResponseEntity<>(duePaymentService.getReportById(id), HttpStatus.OK);
    }

    //Build Update Monthly Due Report REST API
    @PutMapping("/{id}")
    public ResponseEntity<MonthlyDuePayment> update(@RequestBody MonthlyDuePayment duePayment, @PathVariable String id){
        return new ResponseEntity<>(duePaymentService.updateReport(duePayment, id), HttpStatus.OK);
    }

    //Build Delete Monthly Due Report By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        duePaymentService.deleteReport(id);
        return new ResponseEntity<>("Delete Was Successful User With ID " + id , HttpStatus.OK);
    }
}
