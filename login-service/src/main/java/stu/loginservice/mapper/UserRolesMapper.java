package stu.loginservice.mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserRolesMapper {

    @Insert("INSERT INTO user_roles(user_id, role_id) VALUES(#{userId}, #{roleId})")
    void insert(int userId, int roleId);

    @Delete("DELETE FROM user_roles WHERE user_id = #{userId} AND role_id = #{roleId}")
    void delete(int userId, int roleId);

    @Select("SELECT role_id FROM user_roles WHERE user_id = #{userId}")
    List<Integer> findRolesByUserId(int userId);
}
