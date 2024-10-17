package stu.friendservice.service;

import stu.friendservice.entity.ChatSessions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 李
* @description 针对表【chat_sessions】的数据库操作Service
* @createDate 2024-10-13 13:12:01
*/
public interface ChatSessionsService{
void createChatSession(Integer userId, Integer friendId, Integer lastMessageId);
ChatSessions getChatSession(Integer userId, Integer friendId);
void updateChatSession(Integer userId, Integer friendId, Integer lastMessageId);

}
