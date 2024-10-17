package stu.loginservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.loginservice.entity.Roles;


import java.util.List;

@Mapper
public interface RolesMapper {

    @Insert("INSERT INTO Roles(name, description) VALUES(#{name}, #{description})")
    void insert(Roles Roles);

    @Select("SELECT * FROM Roles WHERE id = #{id}")
    Roles findById(int id);

    @Select("SELECT * FROM Roles")
    List<Roles> findAll();

    @Update("UPDATE Roles SET name = #{name}, description = #{description} WHERE id = #{id}")
    void update(Roles Roles);

    @Delete("DELETE FROM Roles WHERE id = #{id}")
    void delete(int id);
}
