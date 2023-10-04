/**
 * Created By SPC On
 * Date:27/09/2023
 * Time:14:51
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.SpecialProjectsReport;
import spc.com.rccgphmbackend.repository.SpecialProjectsReportRepository;

import java.util.List;
import java.util.UUID;
@Service
public class SpecialProjectsReportServiceImpl implements SpecialProjectsReportService{

    //Inject Repository for bd connection
    @Autowired
    private SpecialProjectsReportRepository projectsReportRepository;

    @Override
    public SpecialProjectsReport saveProjectReport(SpecialProjectsReport projectsReport) {
        //Convert String Id to random Number
        projectsReport.setId(UUID.randomUUID().toString().split("-")[0]);
        return projectsReportRepository.save(projectsReport);
    }

    @Override
    public List<SpecialProjectsReport> getALLProjects() {
        return projectsReportRepository.findAll();
    }

    @Override
    public SpecialProjectsReport getSingleReport(String id) {
        //Check if Id exist before attempting get with lambda expression
        return projectsReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
    }

    @Override
    public SpecialProjectsReport updateProjectReport(SpecialProjectsReport projectsReport, String id) {
        //Check if Id exist before attempting to update with lambda expression
        SpecialProjectsReport projectExist = projectsReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));

        projectExist.setProjectName(projectsReport.getProjectName());
        projectExist.setProjectLocation(projectsReport.getProjectLocation());
        projectExist.setState(projectsReport.getState());
        projectExist.setProjectDescription(projectsReport.getProjectDescription());
        projectExist.setProjectStartDate(projectsReport.getProjectStartDate());
        projectExist.setProjectCompletedDate(projectsReport.getProjectCompletedDate());
        projectExist.setProjectEstimate(projectsReport.getProjectEstimate());
        projectExist.setProjectCost(projectsReport.getProjectCost());
        projectExist.setProjectManager(projectsReport.getProjectManager());
        projectExist.setProjectAid(projectsReport.getProjectAid());
        projectExist.setProjectRemarks(projectsReport.getProjectRemarks());

        // Save Update to db
        return projectsReportRepository.save(projectExist);
    }

    @Override
    public void deleteProjectReport(String id) {
        //Check if Id exist before attempting to delete with lambda expression
        projectsReportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
        projectsReportRepository.deleteById(id);
    }
}
