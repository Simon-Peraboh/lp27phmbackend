/**
 * Created By SPC On
 * Date:28/09/2023
 * Time:10:38
 * Project Name:spc.com.rccgphmbackend.security
 */

package spc.com.rccgphmbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import spc.com.rccgphmbackend.service.security.UserLoginInfoDetailService;

@Configuration
//@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        return new UserLoginInfoDetailService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers("/no-csrf"))
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/v1/userprofile/**", "/api/v1/userLoginInfo/**").permitAll()
                        .requestMatchers("/api/v1/secretaryNote/**").hasRole("SECRETARY")
                        .requestMatchers("/api/v1/monthlyDues/**").hasRole("TREASURER")
                        .requestMatchers("/api/v1/nationMonthlyReport/**").hasRole("LEADERS")
                        .requestMatchers("/api/v1/quarterlyReport/**", "/api/v1/nationalReport/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/**").hasRole("SUPERADMIN")
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}

