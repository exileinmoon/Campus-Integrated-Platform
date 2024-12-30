package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import stu.friendservice.entity.FriendPosts;

@Getter
@Setter
@Data
public class FriendPostDTO {
    private Integer userId;
    private String userName;
    private String userAvatar;
    private FriendPosts friendPosts;
}
