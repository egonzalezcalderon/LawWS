package com.atos.lawws.config;

import com.atos.lawws.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String MAINTENANCE_ROL = "MANTENIMIENTO";
    public static final String ADMINISTRATION_ROL = "ADMINISTRACION";
    
    @Autowired
    protected AccessDeniedHandler accessDeniedHandler;

    @Autowired
    protected CustomUserDetailsService customUserDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/respond/**").permitAll()
                .antMatchers("/datatable/**").permitAll()
                .antMatchers("/bootstrap/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/jquery/**").permitAll()
                .antMatchers("/jquery_validation/**").permitAll()
                .antMatchers("/services/**").permitAll()
                .antMatchers("/maintenance/**").hasAnyAuthority(MAINTENANCE_ROL)
                .antMatchers("/administration/**").hasAnyAuthority(ADMINISTRATION_ROL)
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

}
