package stu.friendservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.friendservice.entity.Comments;
import java.util.List;

@Mapper
public interface CommentsMapper {

    @Select("SELECT * FROM comments WHERE id = #{id}")
    Comments selectById(@Param("id") Integer id);

    @Select("SELECT * FROM comments")
    List<Comments> selectAll();

    @Select("SELECT * FROM comments WHERE user_id = #{userId}")
    List<Comments> selectByUserId(@Param("userId") Integer userId);

    @Insert("INSERT INTO comments (user_id, target_user_id, content, likes, created_at) " +
            "VALUES (#{user_id}, #{target_user_id}, #{content}, #{likes}, #{created_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Comments comments);

    @Update("UPDATE comments SET content = #{content}, likes = #{likes} WHERE id = #{id}")
    int updateById(Comments comments);

    @Delete("DELETE FROM comments WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);
}
