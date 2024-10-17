package stu.activityservice.service;

import stu.activityservice.DTO.ActivityDTO;
import stu.activityservice.entity.Activities;

import java.util.List;

public interface ActivitiesService {
    List<ActivityDTO> getAllActivities();
    Activities getActivityById(Integer id);
    void createActivity(Activities activity);
    void updateActivity(Activities activity);
    void deleteActivity(Integer id);
}
