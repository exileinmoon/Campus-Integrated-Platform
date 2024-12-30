package stu.friendservice.mapper;

import org.apache.ibatis.annotations.Insert;
import stu.friendservice.entity.PostComments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 李
 * @description 针对表【post_comments(评论表)】的数据库操作Mapper
 * @createDate 2024-12-17 08:53:41
 * @Entity stu.friendservice.entity.PostComments
 */
public interface PostCommentsMapper  {

    /**
     * 根据帖子ID查询所有评论
     *
     * @param postId 帖子ID
     * @return 评论列表
     */
    @Select("SELECT * FROM post_comments WHERE post_id = #{post_id}")
    List<PostComments> selectByPostId(int postId);

    /**
     * 根据用户ID查询所有评论
     *
     * @param userId 用户ID
     * @return 评论列表
     */
    @Select("SELECT * FROM post_comments WHERE user_id = #{userId}")
    List<PostComments> selectByUserId(int userId);

    /**
     * 根据帖子ID和用户ID查询某个用户在某个帖子的评论
     *
     * @param postId 帖子ID
     * @param userId 用户ID
     * @return 评论
     */
    @Select("SELECT * FROM post_comments WHERE post_id = #{postId} AND user_id = #{userId}")
    PostComments selectByPostIdAndUserId(int postId, int userId);
    /**
     * 自定义插入评论
     *
     * @param postComment 评论实体
     * @return 插入结果
     */
    @Insert("INSERT INTO post_comments (post_id, user_id, content,parent_id) VALUES (#{post_id}, #{user_id}, #{content},#{parent_id})")
    int insertPostComment(PostComments postComment);

}
