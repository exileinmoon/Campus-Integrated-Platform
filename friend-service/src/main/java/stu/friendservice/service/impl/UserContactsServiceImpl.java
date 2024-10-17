package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.friendservice.entity.UserContacts;
import stu.friendservice.mapper.UserContactsMapper;
import stu.friendservice.service.UserContactsService;

@Service
public class UserContactsServiceImpl implements UserContactsService {

    @Autowired
    private UserContactsMapper userContactsMapper;

    @Override
    public UserContacts getContactById(Integer id) {
        return userContactsMapper.selectById(id);
    }

    @Override
    public UserContacts getContactsByUserId(Integer user_id) {
        return userContactsMapper.selectByUserId(user_id);
    }

    @Override
    public boolean createContact(UserContacts userContacts) {
        return userContactsMapper.insert(userContacts) > 0;
    }

    @Override
    public boolean updateContact(UserContacts userContacts) {
        return userContactsMapper.updateById(userContacts) > 0;
    }

    @Override
    public boolean deleteContact(Integer id) {
        return userContactsMapper.deleteById(id) > 0;
    }
}
