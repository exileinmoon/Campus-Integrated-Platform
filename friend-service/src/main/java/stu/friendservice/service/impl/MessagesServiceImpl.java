package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import stu.friendservice.entity.Messages;
import stu.friendservice.service.MessagesService;
import stu.friendservice.mapper.MessagesMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

/**
* @author 李
* @description 针对表【messages】的数据库操作Service实现
* @createDate 2024-10-13 13:12:23
*/
@Service
public class MessagesServiceImpl implements MessagesService{
    @Autowired
    private MessagesMapper messageMapper;

    @Override
    public void sendMessage(Integer senderId, Integer receiverId, String messageType, String content, Instant createdAt) {
        messageMapper.addMessage(senderId, receiverId, messageType, content,createdAt);
    }

    public List<Messages> getMessages(Integer senderId, Integer receiverId) {
        return messageMapper.findChatMessages(senderId, receiverId);
    }



}




