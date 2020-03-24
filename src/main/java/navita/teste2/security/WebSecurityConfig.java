package navita.teste2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	 @Autowired
	    private CustomAuthenticationProvider authProvider;

	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authProvider);
	    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            
               .authorizeRequests()
               .antMatchers(HttpMethod.GET, "/marca/**").hasRole("USER")
               .antMatchers(HttpMethod.POST, "/marca/**").hasRole("USER")
               .antMatchers(HttpMethod.PUT, "/marca/**").hasRole("USER")
               .antMatchers(HttpMethod.PATCH, "/marca/**").hasRole("USER")
               .antMatchers(HttpMethod.DELETE, "/marca/**").hasRole("USER")
               
               .antMatchers(HttpMethod.GET, "/patrimonio/**").hasRole("USER")
               .antMatchers(HttpMethod.POST, "/patrimonio/**").hasRole("USER")
               .antMatchers(HttpMethod.PUT, "/patrimonio/**").hasRole("USER")
               .antMatchers(HttpMethod.PATCH, "/patrimonio/**").hasRole("USER")
               .antMatchers(HttpMethod.DELETE, "/patrimonio/**").hasRole("USER")
            
               
               .antMatchers(HttpMethod.GET, "/usuario/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/usuario/**").hasRole("USER")
               .antMatchers(HttpMethod.PATCH, "/usuario/**").hasRole("USER")
               .antMatchers(HttpMethod.DELETE, "/usuario/**").hasRole("USER")
            
               
               .anyRequest().permitAll()
             .and()
             .httpBasic()
             .and()
             .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }

}