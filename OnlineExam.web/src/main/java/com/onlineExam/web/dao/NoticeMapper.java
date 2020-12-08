package com.onlineExam.web.dao;


import com.onlineExam.web.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<Notice>selectAll();

    Notice selectByid(int id);

    List<Notice> selectByContent(String content);

    void insertNotice(Notice notice);

    void deleteNotice(int id);

    void updateNotice(Notice notice);
}