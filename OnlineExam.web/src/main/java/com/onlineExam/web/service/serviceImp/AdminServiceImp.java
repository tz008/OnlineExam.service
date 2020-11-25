package com.onlineExam.web.service.serviceImp;



import com.onlineExam.web.dao.AdminMapper;
import com.onlineExam.web.entity.Admin;
import com.onlineExam.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired(required = false)
    AdminMapper adminMapper;






    @Override
    public Admin selectAll() {
        return adminMapper.selectAll();
    }
}
