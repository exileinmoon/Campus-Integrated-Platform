package stu.activityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.activityservice.DTO.ActivityDTO;
import stu.activityservice.entity.Activities;
import stu.activityservice.service.ActivitiesService;

import java.util.List;

@RestController
@RequestMapping("/api/activity")

public class ActivityController {
    @Autowired
    private ActivitiesService activitiesService;
    @GetMapping("/list")
    public List<ActivityDTO> getActivity() {
        return activitiesService.getAllActivities();


    }
}
