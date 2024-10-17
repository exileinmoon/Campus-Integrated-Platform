package stu.activityservice.mapper;

/**
* @author 李
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-10-17 19:14:35
* @Entity stu.activityservice.entity.Users1
*/
import org.apache.ibatis.annotations.*;
import stu.activityservice.entity.Users1;

import java.util.List;
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO users (user_id, username, phone_number, role) " +
            "VALUES (#{userId}, #{username}, #{phoneNumber}, #{role})")
    void insertUser(Users1 user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users1 getUserById(int id);

    @Select("SELECT * FROM users WHERE username = #{username}")
    Users1 getUserByUsername(String username);

    @Select("SELECT * FROM users")
    List<Users1> getAllUsers();

    @Update("UPDATE users SET phone_number = #{phoneNumber}, role = #{role} WHERE id = #{id}")
    void updateUser(@Param("id") int id, @Param("phoneNumber") String phoneNumber, @Param("role") String role);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(int id);
}

