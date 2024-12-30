package stu.friendservice.service;

import stu.friendservice.DTO.FriendInterrectionDTO;
import stu.friendservice.DTO.FriendPostDTO;

import java.util.List;

/**
* @author 李
* @description 针对表【friend_posts】的数据库操作Service
* @createDate 2024-12-27 22:20:59
*/
public interface FriendPostsService  {


     FriendInterrectionDTO getPostInteractionsByPostId(Long postId) ;


    List<FriendPostDTO> getFriendPostsByUserId(Long userId);

    List<FriendPostDTO> getMypostBuUserId(Long userId);
}
