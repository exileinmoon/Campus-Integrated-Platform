package stu.activityservice.DTO;

import lombok.*;
import stu.activityservice.entity.Activities;
import stu.activityservice.entity.Activity;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ActivityDTO {
    private String name;
    private String avatar;
    private Activities activity;
}
