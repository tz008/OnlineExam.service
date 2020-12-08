package com.onlineExam.web.service.serviceImp;

import com.onlineExam.web.dao.NoticeMapper;
import com.onlineExam.web.entity.Notice;
import com.onlineExam.web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImp implements NoticeService {

    @Autowired(required = false)
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public Notice selectByid(int id) {
        return noticeMapper.selectByid(id);
    }

    @Override
    public List<Notice> selectByContent(String content) {
        return noticeMapper.selectByContent(content);
    }

    @Override
    public void insertNotice(Notice notice) {
        noticeMapper.insertNotice(notice);
    }

    @Override
    public void deleteNotice(int id) {
        noticeMapper.deleteNotice(id);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }
}
