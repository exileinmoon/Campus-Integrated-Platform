package stu.activityservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JobDetails {
    Tasks task;
    Users user;
}
