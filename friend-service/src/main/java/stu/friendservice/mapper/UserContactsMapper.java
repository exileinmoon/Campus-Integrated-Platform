package stu.friendservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.friendservice.entity.UserContacts;
import java.util.List;

@Mapper
public interface UserContactsMapper {

    @Select("SELECT * FROM user_contacts WHERE id = #{id}")
    UserContacts selectById(@Param("id") Integer id);

    @Select("SELECT * FROM user_contacts WHERE user_id = #{user_id}")
   UserContacts selectByUserId(@Param("user_id") Integer user_id);

    @Insert("INSERT INTO user_contacts (user_id, phone, qq, wechat, created_at, flower, view, `like`) " +
            "VALUES (#{user_id}, #{phone}, #{qq}, #{wechat}, #{created_at}, #{flower}, #{view}, #{like})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserContacts userContacts);

    @Update("UPDATE user_contacts SET phone = #{phone}, qq = #{qq}, wechat = #{wechat}, " +
            "flower = #{flower}, view = #{view}, `like` = #{like} WHERE id = #{id}")
    int updateById(UserContacts userContacts);

    @Delete("DELETE FROM user_contacts WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);
}
