package stu.friendservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.friendservice.entity.UserDetails;
import java.util.List;

@Mapper
public interface UserDetailsMapper {

    @Select("SELECT * FROM user_details WHERE id = #{id}")
    UserDetails selectById(@Param("id") Integer id);

    @Select("SELECT * FROM user_details WHERE user_id = #{user_id}")
    UserDetails selectByUserId(@Param("user_id") Integer user_id);

    @Insert("INSERT INTO user_details (user_id, name, school, major, hobbies, declaration, created_at) " +
            "VALUES (#{user_id}, #{name}, #{school}, #{major}, #{hobbies}, #{declaration}, #{created_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserDetails userDetails);

    @Update("UPDATE user_details SET name = #{name}, school = #{school}, major = #{major}, " +
            "hobbies = #{hobbies}, declaration = #{declaration}, created_at = #{created_at} WHERE id = #{id}")
    int updateById(UserDetails userDetails);

    @Delete("DELETE FROM user_details WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);
    @Select("SELECT * FROM user_details ORDER BY RAND() LIMIT 5")
    List<UserDetails> selectRandom();
}
