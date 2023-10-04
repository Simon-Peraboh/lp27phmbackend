/**
 * Created By SPC On
 * Date:28/09/2023
 * Time:13:27
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spc.com.rccgphmbackend.model.UserLoginInfo;
import spc.com.rccgphmbackend.service.security.UserLoginInfoAddUserService;

@RestController
@RequestMapping("api/v1/userLoginInfo")
@AllArgsConstructor
public class UserLoginInfoController {

    //Inject UserLoginInfoAddUserService layer
    private UserLoginInfoAddUserService loginInfoAddUserService;

    //Create User Login details REST API
    @PostMapping()
    @PreAuthorize("hasRole('SUPERADMIN")
    public ResponseEntity<String> addNewUser(@RequestBody UserLoginInfo userLoginInfo){
        return new ResponseEntity<>(loginInfoAddUserService.addUser(userLoginInfo), HttpStatus.OK);
    }

}
