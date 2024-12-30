package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import stu.friendservice.DTO.FriendInterrectionDTO;
import stu.friendservice.DTO.FriendPostDTO;
import stu.friendservice.DTO.PostInteractionsDTO;
import stu.friendservice.client.UserClient;
import stu.friendservice.entity.FriendPosts;
import stu.friendservice.entity.PostInteractions;
import stu.friendservice.mapper.FriendsMapper;
import stu.friendservice.mapper.PostInteractionsMapper;
import stu.friendservice.service.FriendPostsService;
import stu.friendservice.mapper.FriendPostsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 李
* @description 针对表【friend_posts】的数据库操作Service实现
* @createDate 2024-12-27 22:20:59
*/
@Service
public class FriendPostsServiceImpl implements FriendPostsService{
    @Autowired
    private PostInteractionsMapper postInteractionsMapper;
    @Autowired
    private FriendPostsMapper friendPostsMapper;
    @Autowired
    private FriendsMapper friendsMapper;
    @Autowired
    private UserClient userClient;

    @Override
    public FriendInterrectionDTO getPostInteractionsByPostId(Long postId) {
        FriendInterrectionDTO friendInterrectionDTO = new FriendInterrectionDTO();
        List<PostInteractionsDTO> postInteractionsDTOs = new ArrayList<>();
        List<PostInteractions> postInteractions= postInteractionsMapper.getPostInteractionsByPostId(postId);
        for (PostInteractions postInteraction : postInteractions) {
            PostInteractionsDTO postInteractionsDTO = new PostInteractionsDTO();
            postInteractionsDTO.setPostInteractions(postInteraction);
            postInteractionsDTO.setUserId(postInteraction.getUser_id());
            postInteractionsDTO.setUserName(userClient.getUserById(postInteraction.getUser_id()).getUsername());
            postInteractionsDTO.setUserAvatar(userClient.getUserById(postInteraction.getUser_id()).getAvatar());
            postInteractionsDTOs.add(postInteractionsDTO);

        }
        friendInterrectionDTO.setPostInteractions(postInteractionsDTOs);
        return friendInterrectionDTO;
    }

    @Override
    public List<FriendPostDTO> getFriendPostsByUserId(Long userId) {
        List<FriendPosts> friendPosts= friendPostsMapper.getFriendPostsByUserId(userId);
        List<FriendPostDTO> friendPostDTOs = new ArrayList<>();
        for (FriendPosts friendPost : friendPosts) {
            FriendPostDTO friendPostDTO = new FriendPostDTO();
            friendPostDTO.setUserId(friendPost.getUser_id());
            friendPostDTO.setUserName(userClient.getUserById(friendPost.getUser_id()).getUsername());
            friendPostDTO.setUserAvatar(userClient.getUserById(friendPost.getUser_id()).getAvatar());
            friendPostDTO.setFriendPosts(friendPost);
            friendPostDTOs.add(friendPostDTO);

        }
        return friendPostDTOs;
    }

    @Override
    public List<FriendPostDTO> getMypostBuUserId(Long userId) {
        List<FriendPosts> friendPosts= friendPostsMapper.getPostByMyId(userId);
        List<FriendPostDTO> friendPostDTOs = new ArrayList<>();
        for (FriendPosts friendPost : friendPosts) {
            FriendPostDTO friendPostDTO = new FriendPostDTO();
            friendPostDTO.setUserId(friendPost.getUser_id());
            friendPostDTO.setUserName(userClient.getUserById(friendPost.getUser_id()).getUsername());
            friendPostDTO.setUserAvatar(userClient.getUserById(friendPost.getUser_id()).getAvatar());
            friendPostDTO.setFriendPosts(friendPost);
            friendPostDTOs.add(friendPostDTO);

        }
        return friendPostDTOs;
    }


}




