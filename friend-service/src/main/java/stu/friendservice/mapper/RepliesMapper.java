package stu.friendservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.friendservice.entity.Replies;
import java.util.List;

@Mapper
public interface RepliesMapper {

    @Select("SELECT * FROM replies WHERE id = #{id}")
    Replies selectById(@Param("id") Integer id);

    @Select("SELECT * FROM replies WHERE comment_id = #{comment_id}")
    List<Replies> selectByCommentId(@Param("comment_id") Integer comment_id);

    @Insert("INSERT INTO replies (comment_id, user_id, content, created_at) " +
            "VALUES (#{comment_id}, #{user_id}, #{content}, #{created_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Replies replies);

    @Update("UPDATE replies SET content = #{content} WHERE id = #{id}")
    int updateById(Replies replies);

    @Delete("DELETE FROM replies WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);
}
