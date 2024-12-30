package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import stu.friendservice.entity.Posts;
import stu.friendservice.entity.Users;
@Getter
@Setter
@Data
public class PostDTO {
    private Posts post;
    private Users user;
}
