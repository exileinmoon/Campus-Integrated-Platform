package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.friendservice.entity.UserDetails;
import stu.friendservice.mapper.UserDetailsMapper;
import stu.friendservice.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetails getDetailById(Integer id) {
        return userDetailsMapper.selectById(id);
    }

    @Override
    public UserDetails getDetailsByUserId(Integer user_id) {
        return userDetailsMapper.selectByUserId(user_id);
    }

    @Override
    public boolean createDetail(UserDetails userDetails) {
        return userDetailsMapper.insert(userDetails) > 0;
    }

    @Override
    public boolean updateDetail(UserDetails userDetails) {
        return userDetailsMapper.updateById(userDetails) > 0;
    }

    @Override
    public boolean deleteDetail(Integer id) {
        return userDetailsMapper.deleteById(id) > 0;
    }
}
