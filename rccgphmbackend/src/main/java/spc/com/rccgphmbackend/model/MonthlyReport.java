/**
 * Created By SPC On
 * Date:08/09/2023
 * Time:11:36
 * Project Name:spc.com.rccgphmbackend.model
 */

package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "MonthlyReport")
public class MonthlyReport {

    @Id
    private String id;
    private String state;
    private String region;
    private String province;
    private String coordinatorName;
    private String prisonVisited;
    private String hospitalVisited;
    private String policeStationVisited;
    private String others;
    private String items;
    private String amountBudgeted;
    private String amountSpent;
    private String teamMembers;
    private String soulsWon;
    private String challenges;
    private String suggestion;
    private String remarks;
    private String date;

}
