package stu.activityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.activityservice.DTO.TasksDTO;
import stu.activityservice.client.UserClient;
import stu.activityservice.entity.Job;
import stu.activityservice.entity.JobDetails;
import stu.activityservice.entity.TakeWork;
import stu.activityservice.entity.Tasks;
import stu.activityservice.mapper.TakeWorkMapper;
import stu.activityservice.mapper.TaskMapper;
import stu.activityservice.service.TaskService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TasksServiceImpl implements TaskService {
    @Autowired
    private TaskMapper TasksMapper;
    @Autowired
    private UserClient userClient;
    @Autowired
    private TakeWorkMapper takeWorkMapper;




    @Override
    public void createTask(TasksDTO tasksDTO, Integer userId) {
        Tasks task = new Tasks();

        // 将 reward 从 String 转换为 BigDecimal
        String rewardStr = tasksDTO.getReward();  // 假设 getReward() 返回一个 String
        BigDecimal reward = new BigDecimal(rewardStr);
        task.setReward(reward);  // 设置任务的奖励

        // 将 deadline 从 String 转换为 Date
        String deadlineStr = tasksDTO.getDeadline();  // 假设 getDeadline() 返回一个 String
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // 根据日期格式进行匹配
        Date deadline = null;

        try {
            deadline = dateFormat.parse(deadlineStr);  // 将字符串解析为 Date
        } catch (ParseException e) {
            e.printStackTrace();
            // 处理日期解析失败的情况，可以根据需要抛出异常或使用默认值
        }

        task.setDeadline(deadline);  // 设置任务的截止日期

        // 设置其他任务字段
        task.setPublisher_id(userId);
        task.setTitle(tasksDTO.getTitle());
        task.setDescription(tasksDTO.getDescription());
        task.setLocation(tasksDTO.getLocation());
        task.setStatus("待处理");

        // 插入任务到数据库
        TasksMapper.insertTask(task);
    }

    @Override
    public JobDetails getTaskById(int TasksId) {

        Tasks tasks= TasksMapper.getTaskById(TasksId);
        JobDetails jobDetails = new JobDetails();
        jobDetails.setUser(userClient.getUserById(tasks.getPublisher_id()));
        jobDetails.setTask(tasks);
        return jobDetails;

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

    @Override
    public List<Job> getPublishedTasksByUserId(Integer userId) {

       List<Tasks> tasks= TasksMapper.getTasksByPublisherId(userId);
        List<Job> jobList = new ArrayList<>();
        for (Tasks task : tasks) {
            Job job = new Job();
            job.setName(userClient.getUserById(task.getPublisher_id()).getUsername());
            job.setAvatar(userClient.getUserById(task.getPublisher_id()).getAvatar());
            job.setTasks(task);
            jobList.add(job);
        }
        return jobList;
    }

    @Override
    public List<Job> getAcceptedTasksByUserId(Integer userId) {
        List<TakeWork> takeWorks = takeWorkMapper.selectByUserId(userId);
        List<Job> jobList = new ArrayList<>();
        for (TakeWork takeWork : takeWorks) {
            Job job = new Job();
            job.setName(userClient.getUserById(takeWork.getAccepted_id()).getUsername());
            job.setAvatar(userClient.getUserById(takeWork.getAccepted_id()).getAvatar());
            job.setTasks(TasksMapper.getTaskById(takeWork.getTask_id()));
            jobList.add(job);
        }
        return jobList;
    }

    @Override
    public void acceptTask(Integer userId, Integer taskId) {
        TakeWork takeWork = new TakeWork();
        takeWork.setTask_id(taskId);
        takeWork.setAccepted_id(userId);
        takeWorkMapper.insertTakeWork(userId,taskId);
        TasksMapper.updateTaskStatus(taskId,"进行中");

    }

    @Override
    public void settleTask(Integer taskId) {
        TasksMapper.updateTaskStatus(taskId,"已完成");
    }
}
