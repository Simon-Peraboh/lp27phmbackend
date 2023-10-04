/**
 * Created By SPC On
 * Date:28/09/2023
 * Time:10:47
 * Project Name:spc.com.rccgphmbackend.service.security
 */

package spc.com.rccgphmbackend.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import spc.com.rccgphmbackend.model.UserLoginInfo;
import spc.com.rccgphmbackend.repository.UserLoginInfoRepository;
import spc.com.rccgphmbackend.security.UserLoginInfoUserDetails;

import java.util.Optional;

@Component
public class UserLoginInfoDetailService implements UserDetailsService {
    @Autowired
    private UserLoginInfoRepository loginInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<UserLoginInfo> userInfo = loginInfoRepository.findByName(username);
        return userInfo.map(UserLoginInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found " + username));
    }
}
