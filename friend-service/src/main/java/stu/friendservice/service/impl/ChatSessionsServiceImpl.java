package stu.friendservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import stu.friendservice.entity.ChatSessions;
import stu.friendservice.service.ChatSessionsService;
import stu.friendservice.mapper.ChatSessionsMapper;
import org.springframework.stereotype.Service;

/**
* @author 李
* @description 针对表【chat_sessions】的数据库操作Service实现
* @createDate 2024-10-13 13:12:01
*/
@Service
public class ChatSessionsServiceImpl implements ChatSessionsService{
    @Autowired
    private ChatSessionsMapper chatSessionsMapper;
    @Override
    public void createChatSession(Integer userId, Integer friendId, Integer lastMessageId) {
        chatSessionsMapper.createChatSession(userId, friendId, lastMessageId);
    }


    public ChatSessions getChatSession(Integer userId, Integer friendId) {
        return chatSessionsMapper.findByUserIdAndFriendId(userId, friendId);
    }

    @Override
    public void updateChatSession(Integer userId, Integer friendId, Integer lastMessageId) {
        chatSessionsMapper.updateChatSession(userId, friendId, lastMessageId);
    }

}




