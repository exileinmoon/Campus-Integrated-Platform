package stu.friendservice.DTO;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class AddconmentDTO {
    private Integer userId;
    private Integer loveId;
    private String content;
}
