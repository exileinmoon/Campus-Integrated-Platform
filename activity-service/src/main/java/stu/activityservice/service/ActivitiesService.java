package stu.activityservice.service;

import stu.activityservice.DTO.ActivityDTO;
import stu.activityservice.DTO.ActivityaaDTO;
import stu.activityservice.entity.Activities;

import java.util.List;

public interface ActivitiesService {
    List<ActivityaaDTO> getAllActivities();
    Activities getActivityById(Integer id);

    void updateActivity(Activities activity);
    void deleteActivity(Integer id);



    void createActivity(ActivityDTO activity, Integer userId);

    List<ActivityaaDTO> getJoinedActivities(Integer userId);

    List<ActivityaaDTO> getCreatedActivities(Integer userId);

    void joinActivity(Integer activityId, Integer userId);

    void quitActivity(Integer activityId, Integer userId);
}
