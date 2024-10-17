package stu.friendservice.DTO;

import lombok.*;
import stu.friendservice.entity.UserContacts;
import stu.friendservice.entity.UserDetails;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailDTO {
    private UserContacts userContacts;
    private UserDetails userDetails;
    private List<String> Images;
    private String username;
    private String avatar;

    public void getImages(String[] split) {
        this.Images = List.of(split);
    }
}
