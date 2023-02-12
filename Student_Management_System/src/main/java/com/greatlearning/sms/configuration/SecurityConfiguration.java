package com.greatlearning.sms.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication().withUser("abhay").password(encoder.encode("abhay")).roles("USER")
        .and()
        .withUser("rohan").password(encoder.encode("password")).roles("ADMIN")
        ;
    }

//    @Bean
//    PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(
                        "/collegefest/students/new",
                        "/collegefest/students/insert",
                        "/collegefest/students/update/{id}",
                        "/collegefest/students/delete/{id}"
                        ).hasRole("ADMIN")
                .antMatchers(
                        "/collegefest/students"
                ).hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll().and().formLogin();

    }
	
}
