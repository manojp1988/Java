package net.viralpatel.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static String REALM="MY_TEST_REALM";
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("tom").password("password").roles("USER");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/customers/**").hasRole("ADMIN")
        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
    }
     
    /*
     * 
     * Spring security generates html based error message. For rest api, we dont need html tags. So to
     * provide simple message we need this.
     */
 
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

}
