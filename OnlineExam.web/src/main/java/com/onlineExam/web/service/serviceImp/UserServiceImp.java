//package com.onlineExam.web.service.serviceImp;
//
//import com.onlineExam.web.dao.AdminMapper;
//import com.onlineExam.web.dao.TeacherMapper;
//import com.onlineExam.web.entity.Admin;
//import com.onlineExam.web.entity.Teacher;
//import com.onlineExam.web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//public class UserServiceImp implements UserService {
//
//    @Autowired(required = false)
//    AdminMapper adminMapper;
//
//    @Autowired(required = false)
//    TeacherMapper teacherMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin = adminMapper.selectByAccount(Integer.parseInt(username));
//        Teacher teacher = teacherMapper.selectByTeacherNumber(Integer.parseInt(username));
//        if(admin == null){
//            return teacher;
//        }
//        return admin;
//    }
//}
