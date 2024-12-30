package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Data
@Getter
public class CommentRequest {
    private String content;    // 评论内容
    private int user_id;       // 评论的用户ID
    private String parent_id; // 父评论ID，若是回复评论则传递，不是则为null
}
