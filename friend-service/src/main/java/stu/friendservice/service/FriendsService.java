package stu.friendservice.service;

import stu.friendservice.DTO.FriendDTO;
import stu.friendservice.entity.Messages;

import java.util.List;

/**
* @author 李
* @description 针对表【friends】的数据库操作Service
* @createDate 2024-10-13 13:12:19
*/
public interface FriendsService  {
    void addFriend(Integer userId, Integer friendId);
    List<FriendDTO> getFriendsByUserId(Integer userId);
    void removeFriend(Integer id);

    List<Messages> getMessageById(Integer Id, Integer friendId);
}
