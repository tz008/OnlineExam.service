package com.onlineExam.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    自定义登录
    @Autowired
    JwtAuthenticationProvider jwtAuthenticationProvider;


    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder：Spring Security 提供的加密工具
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        使用自定义登录
        auth.authenticationProvider(jwtAuthenticationProvider);
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//        auth.userDetailsService(userService)
//                .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()   //取消csrf保护
                .authorizeRequests()
                .antMatchers("/ExamPaperAnswerController/**","/ScoreController/**").permitAll()
                .antMatchers("/ExamAnswerController/**","/ExamSetController/**","/NoticeController/**","/ExamPaperQuestionController/**","/ExamPaperController/**","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll();
    }



}