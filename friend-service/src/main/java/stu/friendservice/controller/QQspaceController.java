package stu.friendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.friendservice.DTO.FriendInterrectionDTO;
import stu.friendservice.DTO.FriendPostDTO;
import stu.friendservice.entity.FriendPosts;
import stu.friendservice.entity.PostInteractions;
import stu.friendservice.service.FriendPostsService;
import stu.friendservice.service.FriendsService;
import stu.friendservice.service.PostInteractionsService;

import java.util.List;

@RestController
@RequestMapping("/api/friend/qqspace")
public class QQspaceController {
    @Autowired
    private PostInteractionsService postInteractionsService;
    @Autowired
    private FriendPostsService friendPostsService;
    @Autowired
    private FriendsService friendsService;

    @GetMapping("my-post/{userId}")
    public List<FriendPostDTO> listMyPost(@PathVariable Long userId){

        return friendPostsService.getMypostBuUserId(userId);
    }




    @GetMapping("list/{userId}")
    public List<FriendPostDTO> listQQSpacePosts(@PathVariable Long userId) {

        return friendPostsService.getFriendPostsByUserId(userId);
    }
    @GetMapping("details/{PostId}")
    public FriendInterrectionDTO listQQSpacePostsByPostId(@PathVariable Long PostId) {

        return friendPostsService.getPostInteractionsByPostId(PostId);
    }
    @GetMapping("like/{userId}/{postId}")
    public void likePost(@PathVariable Long userId, @PathVariable Long postId) {
        postInteractionsService.likePost(userId, postId);
    }
    @PostMapping("comment/{userId}/{postId}")
    public void commentPost(@PathVariable Long userId, @PathVariable Long postId, @RequestBody String comment) {
        postInteractionsService.commentPost(userId, postId, comment);
    }

}
