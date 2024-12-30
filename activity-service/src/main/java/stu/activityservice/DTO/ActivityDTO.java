package stu.activityservice.DTO;

import lombok.*;
import stu.activityservice.entity.Activities;
import stu.activityservice.entity.Activity;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private Date start_time;
    private Date end_time;
    private String status;
    private String address;
    private int maxParticipants;
    private String type;
    private String description;
    private Integer organizerId;
    private int currentParticipants;
    private String name;
}