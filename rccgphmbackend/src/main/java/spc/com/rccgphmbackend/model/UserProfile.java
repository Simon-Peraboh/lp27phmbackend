/**
 * Created By SPC On
 * Date:08/09/2023
 * Time:11:55
 * Project Name:spc.com.rccgphmbackend.model
 */

package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "NationalDB")
public class UserProfile {

    @Id
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String state;
    private String region;
    private String lga;
    private String province;
    private String zone;
    private String area;
    private String parish;
    private String position;
    private String joinMinistry;
    private String occupation;
    private String dob;
    private String phoneNumber;
    private String SMHandle;
    private String homeAddress;
    private String officeAddress;
    private String nextOfKin;
    private String nextOfKinPhone;
    private String image;

    @DBRef
    private Region selectedRegion; // Store the selected region, e.g., "region1"
    private String selectedProvince; // Store the selected province, e.g., "Lagos1"


}
