package stu.activityservice.service;

import stu.activityservice.entity.Job;
import stu.activityservice.entity.Tasks;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 李
* @description 针对表【tasks】的数据库操作Service
* @createDate 2024-10-17 19:14:31
*/
import java.util.List;

public interface TaskService {
    void createTask(Tasks task);
    Tasks getTaskById(int taskId);
    List<Tasks> getTasksByPublisherId(int publisherId);
    void updateTaskStatus(int taskId, String status);
    void deleteTask(int taskId);

    List<Job> getAllTasks();
}
