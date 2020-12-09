package com.onlineExam.web.api;



import com.onlineExam.web.entity.Admin;
import com.onlineExam.web.entity.Teacher;
import com.onlineExam.web.service.AdminService;
import com.onlineExam.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 自定义拦截
 * 用户登录验证用户信息
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {//implements AuthenticationProvider {


    @Autowired
    AdminService adminService;

    @Autowired
    TeacherService teacherService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //用户输入的用户名
        String username = String.valueOf(authentication.getName());
        //用户输入的密码
        String password = String.valueOf(authentication.getCredentials());
//        定义加密方式
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        Object principalToReturn;

        if(StringUtils.isEmpty(username) ){
            throw new BadCredentialsException("账号为空！");
        }else if( StringUtils.isEmpty(password)){
            throw new BadCredentialsException("密码为空！");
        }
        //通过自定义UserService，以用户输入的用户名查询用户信息
        Admin admin = (Admin) adminService.selectByAccount(Integer.parseInt(username));
        Teacher teacher = (Teacher) teacherService.selectByTeacherNumber(Integer.parseInt(username));
        if(admin == null){
            if( teacher == null) {
                throw new BadCredentialsException("账号错误！");
            }else if(encode.matches(password,teacher.getPassword())) {
                principalToReturn = teacher;
                //将用户信息塞到SecurityContext中，方便获取当前用户信息  把当前用户信息放入Security全局缓存中
                return this.createSuccessAuthentication(principalToReturn, authentication, teacher);
            }else {
                throw new BadCredentialsException("密码错误！");
            }
        }else if(encode.matches(password,admin.getPassword())){
            principalToReturn = admin;
            return this.createSuccessAuthentication(principalToReturn, authentication, admin);
        }else {
            throw new BadCredentialsException("密码错误！");
        }
//        //用户输入密码加密后与数据库比较
//        if(!encode.matches(password,admin.getPassword()) ){
//            if(!encode.matches(password,teacher.getPassword())) {
//                throw new BadCredentialsException("密码错误！");
//            }else {
//                principalToReturn = teacher;
//                //将用户信息塞到SecurityContext中，方便获取当前用户信息  把当前用户信息放入Security全局缓存中
//                return this.createSuccessAuthentication(principalToReturn, authentication, teacher);
//            }
//        }else {
//            principalToReturn = admin;
//            return this.createSuccessAuthentication(principalToReturn, authentication, admin);
//        }

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
