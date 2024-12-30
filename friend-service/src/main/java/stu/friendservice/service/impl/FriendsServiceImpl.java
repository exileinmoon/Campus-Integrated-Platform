package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import stu.friendservice.DTO.FriendDTO;
import stu.friendservice.DTO.FriendRecomendDTO;
import stu.friendservice.client.UserClient;
import stu.friendservice.entity.Friends;
import stu.friendservice.entity.Messages;
import stu.friendservice.entity.UserDetails;
import stu.friendservice.entity.Users;
import stu.friendservice.mapper.ChatSessionsMapper;
import stu.friendservice.mapper.MessagesMapper;
import stu.friendservice.mapper.UserDetailsMapper;
import stu.friendservice.service.FriendsService;
import stu.friendservice.mapper.FriendsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author 李
* @description 针对表【friends】的数据库操作Service实现
* @createDate 2024-10-13 13:12:19
*/
@Service
public class FriendsServiceImpl implements FriendsService{
    @Autowired
    private MessagesMapper messagesMapper;
    @Autowired
    private FriendsMapper friendMapper;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ChatSessionsMapper chatSessionsMapper;
    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Override
    public void addFriend(Integer userId, Integer friendId) {
        friendMapper.addFriend(userId, friendId);
    }

    @Override
    public List<FriendDTO> getFriendsByUserId(Integer userId) {
        List<FriendDTO> friendDTOList = new ArrayList<>();
        for(Friends friend : friendMapper.findByUserId(userId)){
            Users users =userClient.getUserById(friend.getFriend_id());
            FriendDTO friendDTO = new FriendDTO();
            friendDTO.setFriendAvatar(users.getAvatar());
            friendDTO.setFriendId(users.getId());
            friendDTO.setFriendName(users.getUsername());
            friendDTOList.add(friendDTO);

        }
        return friendDTOList;
    }

    @Override
    public void removeFriend(Integer id) {
        friendMapper.deleteFriend(id);
    }

    @Override
    public List<Messages> getMessageById(Integer Id, Integer friendId) {
        return messagesMapper.findChatMessages(Id,friendId);

    }

    @Override
    public List<FriendRecomendDTO> getRecommendation(Integer userId) {
        List<FriendRecomendDTO> friendRecomendDTOList = new ArrayList<>();
        List<UserDetails> userDetailsList = userDetailsMapper.selectRandom();
        for(UserDetails userDetails : userDetailsList){
            Users users = userClient.getUserById(userDetails.getUser_id());
            FriendRecomendDTO friendRecomendDTO = new FriendRecomendDTO();
            friendRecomendDTO.setUser(users);
            friendRecomendDTO.setUserDetails(userDetails);
            friendRecomendDTOList.add(friendRecomendDTO);

        }
        return friendRecomendDTOList;

    }
}




