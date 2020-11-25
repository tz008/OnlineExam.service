package com.onlineExam.app.service.serviceImp;


import com.onlineExam.app.dao.AdminMapper;
import com.onlineExam.app.entity.Admin;
import com.onlineExam.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired(required = false)
    AdminMapper adminMapper;






    @Override
    public Admin selectAll() {
        System.out.println(adminMapper);
        return adminMapper.selectAll();
    }
}
