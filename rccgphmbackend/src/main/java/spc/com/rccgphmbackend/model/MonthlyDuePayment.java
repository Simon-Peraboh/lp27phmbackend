/**
 * Created By SPC On
 * Date:22/09/2023
 * Time:19:03
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
@Document(collection = "MonthlyDues")
public class MonthlyDuePayment {

    @Id
    private String id;
    private String amount;
    private String province;
    private String paymentDate;
    private String createdDate;
    private String provinceCoordinator;
    private String refMonth;
    private String whoPaid;
    private String remark;
}
