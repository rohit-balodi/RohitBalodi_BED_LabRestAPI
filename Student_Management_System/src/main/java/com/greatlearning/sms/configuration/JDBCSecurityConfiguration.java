package com.greatlearning.sms.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@EnableWebSecurity
@Configuration
public class JDBCSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
              .jdbcAuthentication()
              .dataSource(dataSource)
              .withDefaultSchema()
              .withUser(User.withUsername("rohit").password("rohit").roles("USER"))
              .withUser(User.withUsername("rohit").password("rohit").roles("ADMIN"));
  }

}
