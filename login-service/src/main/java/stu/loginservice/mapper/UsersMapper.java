package stu.loginservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.loginservice.entity.Users;


import java.util.List;

@Mapper
public interface UsersMapper {

    @Insert("INSERT INTO users(username, email, phone, password_hash) VALUES(#{username}, #{email}, #{phone}, #{password_hash})")
    void insert(Users user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users findById(int id);

    @Select("SELECT * FROM users")
    List<Users> findAll();

    @Update("UPDATE users SET username = #{username}, email = #{email}, phone = #{phone}, password_hash = #{passwordHash}, status = #{status} WHERE id = #{id}")
    void update(Users user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(int id);

    @Select("SELECT * FROM users WHERE username = #{username}")
    Users findByUsername(String username);
}
