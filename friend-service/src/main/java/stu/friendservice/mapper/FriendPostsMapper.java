package stu.friendservice.mapper;

import org.apache.ibatis.annotations.Select;
import stu.friendservice.entity.FriendPosts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 李
* @description 针对表【friend_posts】的数据库操作Mapper
* @createDate 2024-12-27 22:20:59
* @Entity stu.friendservice.entity.FriendPosts
*/
public interface FriendPostsMapper extends BaseMapper<FriendPosts> {
    @Select("SELECT * FROM friend_posts WHERE user_id IN " +
            "(SELECT friend_id FROM friends WHERE user_id = #{userId})")
    List<FriendPosts> getFriendPostsByUserId(Long userId);
    @Select("SELECT * FROM friend_posts WHERE user_id=#{userId}" )
    List<FriendPosts> getPostByMyId(Long userId);
}




