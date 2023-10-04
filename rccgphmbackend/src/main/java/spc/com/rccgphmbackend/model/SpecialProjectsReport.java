/**
 * Created By SPC On
 * Date:27/09/2023
 * Time:12:59
 * Project Name:spc.com.rccgphmbackend.model
 */

package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SpecialProjects")
public class SpecialProjectsReport {

    private String id;
    private String projectName;
    private String projectDescription;
    private String projectLocation;
    private String state;
    private String projectEstimate;
    private String projectCost;
    private String projectStartDate;
    private String projectCompletedDate;
    private String projectManager;
    private String projectAid;
    private String projectRemarks;

}
