package stu.loginservice.mapper;

import org.apache.ibatis.annotations.*;


import java.security.Permission;
import java.util.List;

@Mapper
public interface PermissionsMapper {

    @Insert("INSERT INTO permissions(name, description) VALUES(#{name}, #{description})")
    void insert(Permission permission);

    @Select("SELECT * FROM permissions WHERE id = #{id}")
    Permission findById(int id);

    @Select("SELECT * FROM permissions")
    List<Permission> findAll();

    @Update("UPDATE permissions SET name = #{name}, description = #{description} WHERE id = #{id}")
    void update(Permission permission);

    @Delete("DELETE FROM permissions WHERE id = #{id}")
    void delete(int id);
}
