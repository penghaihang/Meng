package com.peng.meng.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
@Configuration  
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}
	@Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        //暂时使用基于内存ObjectPostProcessor的AuthenticationProvider  
        auth.inMemoryAuthentication().withUser("username").password("password").roles("USER");  
    }  
    @Override  
    public void configure(WebSecurity web) throws Exception {  
        web.ignoring().antMatchers("/static/**","/resources/**","/theme/**");  
    }  
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        //暂时禁用csrf,并自定义登录页和登出URL  
        http.csrf().disable()  
                .authorizeRequests().anyRequest().authenticated()  
                .and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_login").successHandler(getLoginSuccessHandler()).failureUrl("/login?error").usernameParameter("username").passwordParameter("password").permitAll()  
                .and().logout().logoutUrl("/logout").permitAll();  
    }
    
    protected AuthenticationSuccessHandler getLoginSuccessHandler()
    {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/index");
        return handler;
    }
}
