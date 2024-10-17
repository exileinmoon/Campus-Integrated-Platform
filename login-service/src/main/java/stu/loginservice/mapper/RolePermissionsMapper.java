package stu.loginservice.mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RolePermissionsMapper {

    @Insert("INSERT INTO role_permissions(role_id, permission_id) VALUES(#{roleId}, #{permissionId})")
    void insert(int roleId, int permissionId);

    @Delete("DELETE FROM role_permissions WHERE role_id = #{roleId} AND permission_id = #{permissionId}")
    void delete(int roleId, int permissionId);

    @Select("SELECT permission_id FROM role_permissions WHERE role_id = #{roleId}")
    List<Integer> findPermissionsByRoleId(int roleId);
}
