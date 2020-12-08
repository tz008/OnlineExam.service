package com.onlineExam.web.service;

import com.onlineExam.web.entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> selectAll();

    Notice selectByid(int id);

    List<Notice> selectByContent(String content);

    void insertNotice(Notice notice);

    void deleteNotice(int id);

    void updateNotice(Notice notice);
}
