package stu.friendservice.service;

import stu.friendservice.entity.Messages;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

/**
* @author 李
* @description 针对表【messages】的数据库操作Service
* @createDate 2024-10-13 13:12:23
*/
public interface MessagesService {
    List<Messages> getMessages(Integer senderId, Integer receiverId);

    void sendMessage(Integer senderId, Integer receiverId, String messageType, String content, Instant createdAt);


}
