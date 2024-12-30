package stu.friendservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;
import stu.friendservice.entity.UserDetails;
import stu.friendservice.entity.Users;

@Getter
@Setter
@Data
public class FriendRecomendDTO {
    private Users user;
    private UserDetails userDetails;
}
