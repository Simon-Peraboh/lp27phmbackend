/**
 * Created By SPC On
 * Date:14/09/2023
 * Time:22:38
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
@Document( collection = "NationalReport")
public class NationalReport {

    @Id
    private String id;
    private String coreDuties;
    private String monthlyTask;
    private String taskDone;
    private String strength;
    private String weakness;
    private String opportunities;
    private String threats;
    private String amountBudgeted;
    private String amountSpent;
    private String remarks;
    private String createdDate;
}
