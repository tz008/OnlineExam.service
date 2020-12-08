package com.onlineExam.web.service;




import com.onlineExam.web.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> selectAll();

    void insertAdmin(Admin admin);

    String getPassword(int account);

    Admin selectByAccount(int account);

    Admin selectByName(String name);

    void updateAdmin(Admin admin);

    void deleteAdmin(int account);
}
