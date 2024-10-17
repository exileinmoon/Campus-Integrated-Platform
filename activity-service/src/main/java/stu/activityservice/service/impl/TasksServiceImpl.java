package stu.activityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.activityservice.client.UserClient;
import stu.activityservice.entity.Job;
import stu.activityservice.entity.Tasks;
import stu.activityservice.mapper.TaskMapper;
import stu.activityservice.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksServiceImpl implements TaskService {
    @Autowired
    private TaskMapper TasksMapper;
    @Autowired
    private UserClient userClient;
    @Override
    public void createTask(Tasks Tasks) {
        TasksMapper.insertTask(Tasks);
    }

    @Override
    public Tasks getTaskById(int TasksId) {
        return TasksMapper.getTaskById(TasksId);
    }

    @Override
    public List<Tasks> getTasksByPublisherId(int publisherId) {
        return TasksMapper.getTasksByPublisherId(publisherId);
    }

    @Override
    public void updateTaskStatus(int TasksId, String status) {
        TasksMapper.updateTaskStatus(TasksId, status);
    }

    @Override
    public void deleteTask(int TasksId) {
        TasksMapper.deleteTask(TasksId);
    }
    @Override
    public List<Job> getAllTasks() {
        List<Job> jobList = new ArrayList<>();
        for (Tasks task : TasksMapper.getAllTasks()) {
            Job job = new Job();
            job.setName(userClient.getUserById(task.getPublisher_id()).getUsername());
            job.setAvatar(userClient.getUserById(task.getPublisher_id()).getAvatar());
            job.setTasks(task);
            jobList.add(job);
        }
        return jobList;

    }
}
