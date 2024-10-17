package stu.loginservice.service;


import stu.loginservice.entity.OauthAccounts;

public interface OauthAccountsService {
    void addOauthAccount(OauthAccounts oauthAccount);
    OauthAccounts getOauthAccountById(int id);
    void deleteOauthAccount(int id);
}
