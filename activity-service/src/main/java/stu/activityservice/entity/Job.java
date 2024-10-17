package stu.activityservice.entity;

import lombok.*;

@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Job {
    private String name;
    private String avatar;
    private Tasks tasks;
}
