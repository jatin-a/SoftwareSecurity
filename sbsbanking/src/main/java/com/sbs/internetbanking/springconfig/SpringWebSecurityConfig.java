package com.sbs.internetbanking.springconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
	auth
       .jdbcAuthentication()
       .dataSource( dataSource )
       .passwordEncoder( new ShaPasswordEncoder() );
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.exceptionHandling()
			.accessDeniedPage("/403")
			.and()
	    .authorizeRequests()
	    	.antMatchers("/resources/**").permitAll()
	    	.anyRequest().authenticated()
	    	.and()
		.formLogin().loginPage("/login").permitAll()
		    .usernameParameter("username")
		    .passwordParameter("password")
		    .defaultSuccessUrl( "/" )
		    .and()
		.logout()
			.deleteCookies( "JSESSIONID" )
            .invalidateHttpSession( true )
		    .permitAll();
		;	
	}
}