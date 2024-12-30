package stu.tradeservice.DTO;

import lombok.*;
import stu.tradeservice.entity.Comments;
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentsDTO {
    Comments comments;
    String avatar;
    String username;
    Integer flowers;
}
