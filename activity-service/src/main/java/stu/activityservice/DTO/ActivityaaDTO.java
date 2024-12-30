package stu.activityservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@Data
// 活动DTO
public class ActivityaaDTO {
    private String id;
    private String name;
    private ActivityDTO activity;
    private CreatorDTO creator;
    private List<ParticipantDTO> participants;

}

// 活动详细信息DTO

