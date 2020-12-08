package com.onlineExam.web.dao;



import com.onlineExam.web.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdminMapper {

    List<Admin> selectAll();

    void insertAdmin(Admin admin);

    String getPassword(int account);

    Admin selectByAccount(int account);

    Admin selectByName(String name);

    void updateAdmin(Admin admin);

    void deleteAdmin(int account);
}