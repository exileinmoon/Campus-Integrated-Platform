package stu.activityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.activityservice.DTO.ActivityDTO;
import stu.activityservice.client.UserClient;
import stu.activityservice.entity.Activities;
import stu.activityservice.mapper.ActivitiesMapper;
import stu.activityservice.service.ActivitiesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {

    @Autowired
    private ActivitiesMapper activitiesMapper;
    @Autowired
    private UserClient userClient;

    public List<ActivityDTO> getAllActivities() {
        List<Activities> activities = activitiesMapper.getActivities();
        List<ActivityDTO> activityDTOS = new ArrayList<ActivityDTO>();
        for (Activities activity : activities) {
         String username=userClient.getUserById(activity.getJoin_user_id()).getUsername();
         String avatar=userClient.getUserById(activity.getJoin_user_id()).getAvatar();
          activityDTOS.add(new ActivityDTO(username,avatar,activity));
        }
        return activityDTOS;
    }

    @Override
    public Activities getActivityById(Integer id) {
        return activitiesMapper.findById(id);
    }

    @Override
    public void createActivity(Activities activity) {
        activitiesMapper.insert(activity);
    }

    @Override
    public void updateActivity(Activities activity) {
        activitiesMapper.update(activity);
    }

    @Override
    public void deleteActivity(Integer id) {
        activitiesMapper.delete(id);
    }
}

