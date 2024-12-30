package stu.activityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.activityservice.DTO.ActivityDTO;
import stu.activityservice.DTO.ActivityaaDTO;
import stu.activityservice.entity.Activities;

import stu.activityservice.service.ActivitiesService;


import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivitiesService activitiesService;


    // 获取活动列表
    @GetMapping("/list")
    public List<ActivityaaDTO> getActivityList() {
        return activitiesService.getAllActivities();  // 获取所有活动
    }
    @GetMapping({"/created/{UserId}"})
    public List<ActivityaaDTO> getCreatedActivityList(@PathVariable("UserId") Integer userId) {
        return activitiesService.getCreatedActivities(userId);  // 获取所有活动
    }
    @GetMapping({"/joined/{UserId}"})
    public List<ActivityaaDTO> getJoinedActivityList(@PathVariable("UserId") Integer userId) {
        return activitiesService.getJoinedActivities(userId);  // 获取所有活动
    }
    // 创建活动
    @PostMapping("{UserId}")
    public String createActivity(@RequestBody ActivityDTO activity, @PathVariable("UserId") Integer userId) {
        activitiesService.createActivity(activity,userId);  // 发布新活动
        return "活动发布成功";
    }

    // 更新活动
    @PutMapping("/{id}")
    public String updateActivity(@PathVariable("id") Integer id, @RequestBody Activities activity) {
        activity.setId(id);  // 设置活动ID
        activitiesService.updateActivity(activity);  // 更新活动信息
        return "活动更新成功";
    }

    // 删除活动
    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable("id") Integer id) {
        activitiesService.deleteActivity(id);  // 删除活动
        return "活动删除成功";
    }

    // 报名活动
    @PostMapping("/{activityId}/join/{userId}")
    public String registerActivity(@PathVariable("activityId") Integer activityId, @PathVariable("userId") Integer userId) {
        activitiesService.joinActivity(activityId, userId);  // 报名活动
        return "报名成功";
    }

    // 取消报名
    @PostMapping("/{activityId}/quit/{userId}")
    public String unregisterActivity(@PathVariable("activityId") Integer activityId, @PathVariable("userId") Integer userId) {
        activitiesService.quitActivity(activityId, userId);  // 取消报名
        return "取消报名成功";
    }
}
