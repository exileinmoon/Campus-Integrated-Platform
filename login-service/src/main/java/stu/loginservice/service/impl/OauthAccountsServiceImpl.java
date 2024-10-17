package stu.loginservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.loginservice.entity.OauthAccounts;
import stu.loginservice.mapper.OauthAccountsMapper;

import stu.loginservice.service.OauthAccountsService;

@Service
public class OauthAccountsServiceImpl implements OauthAccountsService {

    @Autowired
    private OauthAccountsMapper oauthAccountsMapper;

    @Override
    public void addOauthAccount(OauthAccounts oauthAccount) {
        oauthAccountsMapper.insert(oauthAccount);
    }

    @Override
    public OauthAccounts getOauthAccountById(int id) {
        return oauthAccountsMapper.findByUserId(id);
    }

    @Override
    public void deleteOauthAccount(int id) {

    }


}
