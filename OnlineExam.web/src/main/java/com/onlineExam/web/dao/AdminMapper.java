package com.onlineExam.web.dao;



import com.onlineExam.web.entity.Admin;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AdminMapper {
//  查询全部管理员
//@Select("select * from admin")
    Admin selectAll();
}