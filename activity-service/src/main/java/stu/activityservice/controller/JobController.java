package stu.activityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.activityservice.entity.Job;
import stu.activityservice.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class JobController {
    @Autowired
    private TaskService taskService;
    @GetMapping("joblist")
    public List<Job> getJobList() {
        return taskService.getAllTasks();
    }
}


