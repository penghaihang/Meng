package com.peng.meng.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@Order(2)
public class Security extends WebSecurityConfigurerAdapter {

  private static final Logger logger = LoggerFactory.getLogger(Security.class);

  @Override
  public void configure(WebSecurity web) throws Exception {
    // 设置不拦截规则
    web.ignoring().antMatchers("/static/**", "/resources/**", "/public/**");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/index").hasAuthority("ROLE_ADMIN")
        // .antMatchers("/j_spring_security_login").permitAll()//访问：/home 无需登录认证权限
        .anyRequest()
        .authenticated()
        // 其他所有资源都需要认证，登陆后访问
        // 登陆后之后拥有“ADMIN”权限才可以访问/hello方法，否则系统会出现“403”权限不足的提示
        .and()
        .formLogin()
        .loginPage("/login")
        // 指定登录页是”/login”
        // .loginProcessingUrl("j_spring_security_login")
        .successHandler(getLoginSuccessHandler()).failureUrl("/login?error")
        // 登录成功后可使用loginSuccessHandler()存储用户信息，可选。
        .usernameParameter("j_username").passwordParameter("j_password").permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login") // 退出登录后的默认网址是”/home”
        .permitAll().invalidateHttpSession(true).and().rememberMe()// 登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
        .tokenValiditySeconds(1209600);

    http.csrf().disable();
  }

  protected AuthenticationSuccessHandler getLoginSuccessHandler() {
    SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
    handler.setDefaultTargetUrl("/index");
    return handler;
  }

  @Autowired
  @Qualifier("customUserDetailsService")
  UserDetailsService userDetailsService;



  @Autowired
  public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
    auth.authenticationProvider(authenticationProvider());
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth)
  // throws Exception {
  // auth
  // .inMemoryAuthentication()
  // .withUser("user").password("password").roles("ADMIN");
  // }



  @Bean
  public LoggerListener loggerListener() {
    logger.info("org.springframework.security.authentication.event.LoggerListener");
    LoggerListener loggerListener = new LoggerListener();

    return loggerListener;
  }

  @Bean
  public org.springframework.security.access.event.LoggerListener eventLoggerListener() {
    logger.info("org.springframework.security.access.event.LoggerListener");
    org.springframework.security.access.event.LoggerListener eventLoggerListener =
        new org.springframework.security.access.event.LoggerListener();

    return eventLoggerListener;
  }



}
