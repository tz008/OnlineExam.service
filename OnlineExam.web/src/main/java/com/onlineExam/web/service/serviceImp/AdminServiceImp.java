package com.onlineExam.web.service.serviceImp;



import com.onlineExam.web.dao.AdminMapper;
import com.onlineExam.web.entity.Admin;
import com.onlineExam.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired(required = false)
    AdminMapper adminMapper;

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public void insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
    }

    @Override
    public String getPassword(int account) {
        return adminMapper.getPassword(account);
    }

    @Override
    public Admin selectByAccount(int account) {
        return adminMapper.selectByAccount(account);
    }

    @Override
    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(int account) {
        adminMapper.deleteAdmin(account);
    }
}
