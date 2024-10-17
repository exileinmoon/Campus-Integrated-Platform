package stu.tradeservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import stu.tradeservice.entity.Comments;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {

    // 增加评论
    @Insert("INSERT INTO comments(user_id, product_id, content, created_at) " +
            "VALUES(#{userId}, #{productId}, #{content}, #{createdAt})")
    int insertComment(Comments comment);

    // 查询所有评论
    @Select("SELECT * FROM comments")
    List<Comments> selectAllComments();

    // 根据 ID 查询评论
    @Select("SELECT * FROM comments WHERE id = #{id}")
    Comments selectCommentById(Long id);

    // 更新评论
    @Update("UPDATE comments SET user_id = #{userId}, product_id = #{productId}, content = #{content}, created_at = #{createdAt} WHERE id = #{id}")
    int updateComment(Comments comment);

    // 根据 ID 删除评论
    @Delete("DELETE FROM comments WHERE id = #{id}")
    int deleteComment(Long id);

    @Select("SELECT * FROM comments WHERE product_id = #{productId}")
    List<Comments> selectByProductId(Long productId);
}