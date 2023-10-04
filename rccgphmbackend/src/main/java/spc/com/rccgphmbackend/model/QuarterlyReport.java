/**
 * Created By SPC On
 * Date:14/09/2023
 * Time:22:31
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
@Document(collection = "QuarterlyReport")
public class QuarterlyReport {

    @Id
    private String id;
    private String whichYear;
    private String period;
    private String totalSouls;
    private String totalAmount;
    private String creationDate;

}
