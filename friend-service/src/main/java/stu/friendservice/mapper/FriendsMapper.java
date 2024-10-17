package stu.friendservice.mapper;

import stu.friendservice.entity.Friends;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 李
* @description 针对表【friends】的数据库操作Mapper
* @createDate 2024-10-13 13:12:19
* @Entity stu.friendservice.entity.Friends
*/
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendsMapper {

    @Insert("INSERT INTO friends (user_id, friend_id, created_at) VALUES (#{userId}, #{friendId}, NOW())")
    void addFriend(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    @Select("SELECT * FROM friends WHERE user_id = #{userId}")
    List<Friends> findByUserId(@Param("userId") Integer userId);

    @Delete("DELETE FROM friends WHERE id = #{id}")
    void deleteFriend(@Param("id") Integer id);

}



