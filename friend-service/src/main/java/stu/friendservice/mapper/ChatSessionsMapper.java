package stu.friendservice.mapper;

import stu.friendservice.entity.ChatSessions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 李
* @description 针对表【chat_sessions】的数据库操作Mapper
* @createDate 2024-10-13 13:12:01
* @Entity stu.friendservice.entity.ChatSessions
*/
import org.apache.ibatis.annotations.*;

@Mapper
public interface ChatSessionsMapper {

    @Insert("INSERT INTO chat_sessions (user_id, friend_id, last_message_id, updated_at) " +
            "VALUES (#{userId}, #{friendId}, #{lastMessageId}, NOW())")
    void createChatSession(@Param("userId") Integer userId,
                           @Param("friendId") Integer friendId,
                           @Param("lastMessageId") Integer lastMessageId);

    @Select("SELECT * FROM chat_sessions WHERE user_id = #{userId} AND friend_id = #{friendId}")
    ChatSessions findByUserIdAndFriendId(@Param("userId") Integer userId,
                                        @Param("friendId") Integer friendId);

    @Update("UPDATE chat_sessions SET last_message_id = #{lastMessageId}, updated_at = NOW() " +
            "WHERE user_id = #{userId} AND friend_id = #{friendId}")
    void updateChatSession(@Param("userId") Integer userId,
                           @Param("friendId") Integer friendId,
                           @Param("lastMessageId") Integer lastMessageId);
}


