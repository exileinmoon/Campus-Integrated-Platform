package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class FriendDTO {
    private Integer friendId;
    private String friendName;
    private String friendAvatar;
    private String friendSignature;


}
