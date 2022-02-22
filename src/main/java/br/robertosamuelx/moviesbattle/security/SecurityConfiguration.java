package br.robertosamuelx.moviesbattle.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // TODO Auto-generated method stub
    super.configure(auth);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/console/**")
        .permitAll();
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // TODO Auto-generated method stub
    super.configure(web);
  }
}
