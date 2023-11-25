package com.cody.weather.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 다른 설정들을 추가할 수 있습니다.
            .authorizeRequests()
                .antMatchers("/user/profile").authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll();
    }
    
}

//스프링 시큐리티를 사용한 비밀번호 정책 설정 예시
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.inMemoryAuthentication()
         .passwordEncoder(passwordEncoder())
         .withUser("user")
         .password(passwordEncoder().encode("password"))
         .roles("USER");
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
}