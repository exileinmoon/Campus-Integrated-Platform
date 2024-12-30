package stu.friendservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import stu.friendservice.entity.Posts;


import java.util.List;

/**
 * @author 李
 * @description 针对表【posts(帖子表)】的数据库操作Mapper
 * @createDate 2024-12-17 08:42:33
 * @Entity stu.activityservice.entity.Posts
 */
@Mapper
public interface PostsMapper  {

    // 自定义查询：查询所有帖子
    @Select("SELECT * FROM posts")
    List<Posts> findAllPosts();

    // 自定义查询：根据用户ID查询帖子
    @Select("SELECT * FROM posts WHERE user_id = #{user_id}")
    List<Posts> findPostsByUserId(@Param("user_id") Long userId);

    // 自定义查询：根据帖子ID查询单个帖子
    @Select("SELECT * FROM posts WHERE id = #{id}")
    Posts findPostById(@Param("id") Long id);

    // 自定义插入：插入单个帖子
    @Insert("INSERT INTO posts (section_id, user_id, title, content, views, comments, likes, status, is_top, is_hot, created_at, updated_at) " +
            "VALUES (#{sectionId}, #{userId}, #{title}, #{content}, #{views}, #{comments}, #{likes}, #{status}, #{isTop}, #{isHot}, #{created_at}, #{updated_at})")
    int insertPost(Posts post);



    // 自定义删除：根据帖子ID删除帖子
    @Delete("DELETE FROM posts WHERE id = #{id}")
    int deletePost(@Param("id") Long id);


    /**
     * 根据帖子ID更新帖子信息
     *
     * @param post 帖子实体
     * @return 更新结果
     */
    @Update("UPDATE posts SET title = #{title}, content = #{content}, updated_at = #{updated_at} WHERE id = #{id}")
    int updateById(Posts post);

}
