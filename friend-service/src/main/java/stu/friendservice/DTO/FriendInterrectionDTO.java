package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import stu.friendservice.entity.PostInteractions;

import java.util.List;
@Data
@Getter
@Setter
public class FriendInterrectionDTO {
    List<PostInteractionsDTO> postInteractions;
}
