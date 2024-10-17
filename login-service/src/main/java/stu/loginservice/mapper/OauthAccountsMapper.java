package stu.loginservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.loginservice.entity.OauthAccounts;


@Mapper
public interface OauthAccountsMapper {

    @Insert("INSERT INTO oauth_accounts(user_id, oauth_provider, oauth_id) VALUES(#{userId}, #{oauthProvider}, #{oauthId})")
    void insert(OauthAccounts oauthAccounts);

    @Select("SELECT * FROM oauth_accounts WHERE user_id = #{userId}")
    OauthAccounts findByUserId(int userId);
}
