package stu.friendservice.mapper;

import stu.friendservice.entity.Messages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 李
* @description 针对表【messages】的数据库操作Mapper
* @createDate 2024-10-13 13:12:23
* @Entity stu.friendservice.entity.Messages
*/
import org.apache.ibatis.annotations.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Mapper
public interface MessagesMapper {

    @Insert("INSERT INTO messages (sender_id, receiver_id, message_type, content, created_at) " +
            "VALUES (#{senderId}, #{receiverId}, #{messageType}, #{content},#{createdAt})")
    void addMessage(@Param("senderId") Integer senderId,
                    @Param("receiverId") Integer receiverId,
                    @Param("messageType") String messageType,
                    @Param("content") String content,
                    @Param("createdAt") Instant createdAt

    );

    @Select("SELECT * FROM messages WHERE (sender_id = #{userId} AND receiver_id = #{friendId}) OR (sender_id = #{friendId} AND receiver_id = #{userId}) ORDER BY created_at ASC")
    List<Messages> findChatMessages(@Param("userId") Integer userId, @Param("friendId") Integer friendId);
}
