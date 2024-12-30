package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import stu.friendservice.entity.PostInteractions;

@Data
@Setter
@Getter
public class PostInteractionsDTO {
    private PostInteractions postInteractions;
    private String userName;
    private String userAvatar;
    private Integer userId;
}
