/**
 * Created By SPC On
 * Date:28/09/2023
 * Time:13:00
 * Project Name:spc.com.rccgphmbackend.service.security
 */

package spc.com.rccgphmbackend.service.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.UserLoginInfo;
import spc.com.rccgphmbackend.repository.UserLoginInfoRepository;

@Service
@AllArgsConstructor
public class UserLoginInfoAddUserService {

    //Inject repository
    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;
    //Inject PasswordEncoder to manage password
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser (UserLoginInfo userLoginInfo){
        userLoginInfo.setPassword(passwordEncoder.encode(userLoginInfo.getPassword()));
        userLoginInfoRepository.save(userLoginInfo);
        return "User Added To System";
    }

}
