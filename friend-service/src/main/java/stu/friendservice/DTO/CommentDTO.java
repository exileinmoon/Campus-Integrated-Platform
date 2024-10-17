package stu.friendservice.DTO;

import lombok.*;
import stu.friendservice.entity.Comments;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Comments comments;
    private String username;
    private String avatar;
}
