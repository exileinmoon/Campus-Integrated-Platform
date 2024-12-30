package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import stu.friendservice.entity.PostComments;
import stu.friendservice.entity.Users;
@Data
@Setter
@Getter
public class PostCommentDTO {
    private PostComments comment;
    private Users user;
}
