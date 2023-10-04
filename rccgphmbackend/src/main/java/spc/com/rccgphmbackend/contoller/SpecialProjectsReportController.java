/**
 * Created By SPC On
 * Date:27/09/2023
 * Time:15:11
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.model.SpecialProjectsReport;
import spc.com.rccgphmbackend.service.SpecialProjectsReportService;

import java.util.List;

@RestController
@RequestMapping("api/v1/specialProjects")
@AllArgsConstructor
public class SpecialProjectsReportController {

    //Inject Service Layer
    private SpecialProjectsReportService projectsReportService;

    // Build Create Report REST API
    @PostMapping()
    public ResponseEntity<SpecialProjectsReport> createReport(@RequestBody SpecialProjectsReport projectsReport){
        return new ResponseEntity<>(projectsReportService.saveProjectReport(projectsReport), HttpStatus.CREATED);
    }

    // Get All Project Report REST API
    @GetMapping()
    public List<SpecialProjectsReport> getAll(){
        return projectsReportService.getALLProjects();
    }

    //Get Project Report By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<SpecialProjectsReport> getSingle(@PathVariable String id){
        return new ResponseEntity<>(projectsReportService.getSingleReport(id), HttpStatus.OK);
    }

    //Update Project Report By Id API
    @PutMapping("/{id}")
    public ResponseEntity<SpecialProjectsReport> updateProject(@RequestBody SpecialProjectsReport projectsReport, @PathVariable String id){
        return new ResponseEntity<>(projectsReportService.updateProjectReport(projectsReport, id), HttpStatus.OK);
    }

    //Delete Project Report By Id API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable String id){
        projectsReportService.deleteProjectReport(id);
        return new ResponseEntity<>("User Deleted Successful " + id, HttpStatus.OK);
    }
}
