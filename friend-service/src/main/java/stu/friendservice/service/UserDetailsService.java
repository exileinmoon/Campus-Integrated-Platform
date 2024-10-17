package stu.friendservice.service;

import stu.friendservice.entity.UserDetails;

public interface UserDetailsService {

    UserDetails getDetailById(Integer id);

    UserDetails getDetailsByUserId(Integer user_id);

    boolean createDetail(UserDetails userDetails);

    boolean updateDetail(UserDetails userDetails);

    boolean deleteDetail(Integer id);
}
