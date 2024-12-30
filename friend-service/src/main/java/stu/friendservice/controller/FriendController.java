package stu.friendservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu.friendservice.DTO.FriendDTO;
import stu.friendservice.DTO.FriendRecomendDTO;
import stu.friendservice.entity.ChatMessage;
import stu.friendservice.entity.Messages;
import stu.friendservice.service.FriendsService;

import java.util.List;

@RestController
@RequestMapping("/api/friend")
// 好友管理Controller，提供添加好友、获取好友列表、删除好友等功能
public class FriendController {
    @Autowired
    private FriendsService friendService;

    // 添加好友
    @PostMapping("/addFriend/{userId}/{friendId}")
    public ResponseEntity<Void> addFriend(@PathVariable Integer userId, @PathVariable Integer friendId) {
        friendService.addFriend(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recommendation/{userId}")
    public List<FriendRecomendDTO> getRecommendation(@PathVariable Integer userId) {
        List<FriendRecomendDTO> friends = friendService.getRecommendation(userId);
        return friends;
    }
    // 获取好友列表
    @GetMapping("/{userId}")
    public ResponseEntity<List<FriendDTO>> getFriends(@PathVariable Integer userId) {
        List<FriendDTO> friends = friendService.getFriendsByUserId(userId);
        return ResponseEntity.ok(friends);
    }
    @GetMapping("/message/{currentUserId}/{friendId}")
    public List<Messages> getMessageById(
            @PathVariable Integer currentUserId,
            @PathVariable Integer friendId) {

        List<Messages> messages = friendService.getMessageById(currentUserId, friendId);
        return messages;
    }

    // 删除好友
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFriend(@PathVariable Integer id) {
        friendService.removeFriend(id);
        return ResponseEntity.ok().build();
    }


}
