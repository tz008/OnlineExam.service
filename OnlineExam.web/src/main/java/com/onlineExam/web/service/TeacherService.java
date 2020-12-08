package com.onlineExam.web.service;

import com.onlineExam.web.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectAll();

    Teacher selectByTeacherNumber(int teacherNumber);

    void insertTeacher(Teacher teacher);

    void deleteTeacher(int teacherNumber);

    void updateTeacher(Teacher teacher);

    //    找回密码
    String getPassword(int teacherNumber);
}
