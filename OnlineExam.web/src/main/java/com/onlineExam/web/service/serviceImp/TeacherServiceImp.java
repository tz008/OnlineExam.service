package com.onlineExam.web.service.serviceImp;

import com.onlineExam.web.dao.TeacherMapper;
import com.onlineExam.web.entity.Teacher;
import com.onlineExam.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired(required = false)
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public Teacher selectByTeacherNumber(int teacherNumber) {
        return teacherMapper.selectByTeacherNumber(teacherNumber);
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int teacherNumber) {
        teacherMapper.deleteTeacher(teacherNumber);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public String getPassword(int teacherNumber) {
        return teacherMapper.getPassword(teacherNumber);
    }
}
