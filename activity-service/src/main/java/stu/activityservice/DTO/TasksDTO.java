package stu.activityservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Data
@Getter
public class TasksDTO {
    // 任务的截止时间
    private String deadline;

    // 任务描述
    private String description;

    // 任务地点
    private String location;

    // 任务奖励
    private String reward;

    // 任务标题
    private String title;

    // 发布者的 ID
    private Integer publisherId;

    // 无参构造函数
    public TasksDTO() {
    }

    // 带参构造函数
    public TasksDTO(String deadline, String description, String location, String reward, String title, Integer publisherId) {
        this.deadline = deadline;
        this.description = description;
        this.location = location;
        this.reward = reward;
        this.title = title;
        this.publisherId = publisherId;
    }
}

