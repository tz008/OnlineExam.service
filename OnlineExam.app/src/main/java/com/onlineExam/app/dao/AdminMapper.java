package com.onlineExam.app.dao;


import com.onlineExam.app.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;


@Mapper
public interface AdminMapper {
//  查询全部管理员
//@Select("select * from admin")
    Admin selectAll();
}