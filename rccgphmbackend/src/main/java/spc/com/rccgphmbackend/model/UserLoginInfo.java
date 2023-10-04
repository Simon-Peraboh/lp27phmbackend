/**
 * Created By SPC On
 * Date:27/09/2023
 * Time:22:06
 * Project Name:spc.com.rccgphmbackend.model
 */

package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserLoginInfo")
public class UserLoginInfo {

    @Id
    private String Id;
    private String name;
    private String email;
    private String password;
    private String roles;
}
