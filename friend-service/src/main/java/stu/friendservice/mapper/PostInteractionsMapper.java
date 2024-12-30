package stu.friendservice.mapper;

import org.apache.ibatis.annotations.Select;
import stu.friendservice.entity.PostInteractions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 李
* @description 针对表【post_interactions】的数据库操作Mapper
* @createDate 2024-12-27 22:21:23
* @Entity stu.friendservice.entity.PostInteractions
*/
public interface PostInteractionsMapper extends BaseMapper<PostInteractions> {
    @Select("select * from post_interactions where post_id = #{postId}")
    List<PostInteractions> getPostInteractionsByPostId(Long postId);
}




