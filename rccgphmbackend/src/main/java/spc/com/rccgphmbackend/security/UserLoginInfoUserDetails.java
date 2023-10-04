/**
 * Created By SPC On
 * Date:28/09/2023
 * Time:11:12
 * Project Name:spc.com.rccgphmbackend.security
 */

package spc.com.rccgphmbackend.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spc.com.rccgphmbackend.model.UserLoginInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserLoginInfoUserDetails implements UserDetails {

    private final String name;
    private final String password;
    private final List<GrantedAuthority> authorities;

    //Add Constructor

    public UserLoginInfoUserDetails(UserLoginInfo userLoginInfo) {
        name = userLoginInfo.getName();
        password = userLoginInfo.getPassword();
        authorities = Arrays.stream(userLoginInfo.getRoles().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
