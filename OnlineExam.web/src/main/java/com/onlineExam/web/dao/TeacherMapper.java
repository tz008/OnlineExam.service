package com.onlineExam.web.dao;


import com.onlineExam.web.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    List<Teacher> selectAll();

    Teacher selectByTeacherNumber(int teacherNumber);

    void insertTeacher(Teacher teacher);

    void deleteTeacher(int teacherNumber);

    void updateTeacher(Teacher teacher);

//    找回密码
    String getPassword(int teacherNumber);
}