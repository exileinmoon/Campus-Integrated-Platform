package stu.activityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.activityservice.DTO.TasksDTO;
import stu.activityservice.entity.Job;
import stu.activityservice.entity.JobDetails;
import stu.activityservice.entity.Tasks;
import stu.activityservice.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class JobController {

    @Autowired
    private TaskService taskService;

    // 获取所有任务
    @GetMapping("joblist")
    public List<Job> getJobList() {
        return taskService.getAllTasks();
    }

    // 获取某个任务
    @GetMapping("tasks/{id}")
    public JobDetails getTaskById(@PathVariable("id") int id) {
       return taskService.getTaskById(id);
  }
    @PostMapping("settle-task/{taskId}")
    public void settleTask(@PathVariable("taskId") Integer taskId) {
        taskService.settleTask(taskId);
    }

    // 发布新任务
    @PostMapping("publish-task/{userId}")
    public void createTask(@PathVariable("userId") Integer userId, @RequestBody TasksDTO task) {
        // 通过userId和task创建任务
        taskService.createTask(task, userId);
    }
    @PostMapping("accept-task/{userId}/{taskId}")
    public void acceptTask(@PathVariable("userId") Integer userId, @PathVariable("taskId") Integer taskId) {
        taskService.acceptTask(userId, taskId);
    }
    // 获取已发布的任务
    @GetMapping("my-published-tasks/{userId}")
    public List<Job> getPublishedTasks(@PathVariable("userId") Integer userId) {
        return taskService.getPublishedTasksByUserId(userId); // 根据 userId 查询已发布任务
    }

    // 获取已接受的任务
    @GetMapping("my-accepted-tasks/{userId}")
    public List<Job> getAcceptedTasks(@PathVariable("userId") Integer userId) {
        return taskService.getAcceptedTasksByUserId(userId); // 根据 userId 查询已接受任务
    }
//    // 更新任务
//    @PutMapping("tasks/{id}")
//    public Job updateTask(@PathVariable("id") Long id, @RequestBody Job job) {
//        return taskService.updateTask(id, job);
//    }
//
//    // 删除任务
//    @DeleteMapping("tasks/{id}")
//    public void deleteTask(@PathVariable("id") Long id) {
//        taskService.deleteTask(id);
//    }
//
//    // 完成任务
//    @PostMapping("complete-task/{id}")
//    public void completeTask(@PathVariable("id") Long id) {
//        taskService.completeTask(id);
//    }
}
