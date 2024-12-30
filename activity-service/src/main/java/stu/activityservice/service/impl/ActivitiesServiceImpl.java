package stu.activityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.activityservice.DTO.ActivityDTO;

import stu.activityservice.DTO.ActivityaaDTO;
import stu.activityservice.DTO.CreatorDTO;
import stu.activityservice.DTO.ParticipantDTO;
import stu.activityservice.client.UserClient;
import stu.activityservice.entity.Activities;
import stu.activityservice.entity.Participants;
import stu.activityservice.entity.Users;
import stu.activityservice.mapper.ActivitiesMapper;
import stu.activityservice.mapper.ParticipantsMapper;
import stu.activityservice.service.ActivitiesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {

    @Autowired
    private ActivitiesMapper activitiesMapper;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ParticipantsMapper participantsMapper;

    public List<ActivityaaDTO> getAllActivities() {
        List<Activities> activities = activitiesMapper.findAll();
        List<ActivityaaDTO> activityaaDTOS = new ArrayList<>();
        for( Activities activity : activities) {
            ActivityaaDTO activityaaDTO = new ActivityaaDTO();
            activityaaDTO.setId(String.valueOf(activity.getId()));
            activityaaDTO.setName(activity.getName());
            ActivityDTO activityDTO = new ActivityDTO();
            activityDTO.setStart_time(activity.getStart_time());
            activityDTO.setEnd_time(activity.getEnd_time());
            activityDTO.setStatus((String) activity.getStatus());
            activityDTO.setAddress(activity.getAddress());
            activityDTO.setMaxParticipants(activity.getMax_participants());
            activityDTO.setType((String) activity.getType());
            activityDTO.setDescription(activity.getDescription());
            activityDTO.setOrganizerId(activity.getOrganizer_id());
            activityDTO.setName(activity.getName());
            activityDTO.setCurrentParticipants(activityDTO.getCurrentParticipants());
            activityaaDTO.setActivity(activityDTO);
            activityaaDTOS.add(activityaaDTO);
            Users user = userClient.getUserById(activity.getOrganizer_id());
            CreatorDTO creatorDTO = new CreatorDTO();
            creatorDTO.setId(String.valueOf(user.getId()));
            creatorDTO.setName(user.getUsername());
            creatorDTO.setAvatar(user.getAvatar());
            creatorDTO.setRole("organizer");
            activityaaDTO.setCreator(creatorDTO);
            System.out.println(activity.getId());
            List<Participants> participants = participantsMapper.findByActivityId(activity.getId());
            List<ParticipantDTO> participantDTOS = new ArrayList<>();
            for (Participants participant : participants) {
                Users participantUser = userClient.getUserById(participant.getParticipant_id());
                ParticipantDTO participantDTO = new ParticipantDTO();
                participantDTO.setId(String.valueOf(participantUser.getId()));
                participantDTO.setName(participantUser.getUsername());
                participantDTO.setAvatar(participantUser.getAvatar());
                participantDTO.setRole("participant");
                participantDTOS.add(participantDTO);
            }
            activityaaDTO.setParticipants(participantDTOS);
        }
        return activityaaDTOS;
    }

    @Override
    public Activities getActivityById(Integer id) {
        return activitiesMapper.findById(id);
    }

    @Override
    public void updateActivity(Activities activity) {

    }

    @Override
    public void deleteActivity(Integer id) {
        activitiesMapper.delete(id);
    }

    @Override
    public void createActivity(ActivityDTO activity, Integer userId) {
        Activities activities = new Activities();
        activities.setStart_time(activity.getStart_time());
        activities.setEnd_time(activity.getEnd_time());
        activities.setStatus("未开始");
        activities.setAddress(activity.getAddress());
        activities.setMax_participants(activity.getMaxParticipants());
        activities.setType(activity.getType());
        activities.setDescription(activity.getDescription());
        activities.setOrganizer_id(userId);
        activities.setCurrent_participants(1);

        activities.setName(activity.getName());
        System.out.println(activities);
        activitiesMapper.insert(activities);

    }

    @Override
    public List<ActivityaaDTO> getJoinedActivities(Integer userId) {
        // 根据用户ID查找用户参与的所有活动
        List<Participants> participants = participantsMapper.findByParticipantId(userId);
        List<ActivityaaDTO> activityaaDTOS = new ArrayList<>();

        // 遍历每个活动ID，获取详细信息
        for (Participants participant : participants) {
            Activities activity = activitiesMapper.findById(participant.getActivity_id());
            // 将活动信息封装到DTO中
            ActivityaaDTO activityaaDTO = new ActivityaaDTO();
            activityaaDTO.setId(String.valueOf(activity.getId()));
            activityaaDTO.setName(activity.getName());

            ActivityDTO activityDTO = new ActivityDTO();
            activityDTO.setStart_time(activity.getStart_time());
            activityDTO.setEnd_time(activity.getEnd_time());
            activityDTO.setStatus((String) activity.getStatus());
            activityDTO.setAddress(activity.getAddress());
            activityDTO.setMaxParticipants(activity.getMax_participants());
            activityDTO.setType((String) activity.getType());
            activityDTO.setDescription(activity.getDescription());
            activityDTO.setOrganizerId(activity.getOrganizer_id());
            activityDTO.setName(activity.getName());

            // 获取当前活动的参与者数量
            List<Participants> activityParticipants = participantsMapper.findByActivityId(activity.getId());
            activityDTO.setCurrentParticipants(activityParticipants.size());

            activityaaDTO.setActivity(activityDTO);

            // 获取活动创建者信息
            Users user = userClient.getUserById(activity.getOrganizer_id());
            CreatorDTO creatorDTO = new CreatorDTO();
            creatorDTO.setId(String.valueOf(user.getId()));
            creatorDTO.setName(user.getUsername());
            creatorDTO.setAvatar(user.getAvatar());
            creatorDTO.setRole("organizer");
            activityaaDTO.setCreator(creatorDTO);

            // 获取活动参与者信息
            List<ParticipantDTO> participantDTOS = new ArrayList<>();
            for (Participants p : activityParticipants) {
                Users participantUser = userClient.getUserById(p.getParticipant_id());
                ParticipantDTO participantDTO = new ParticipantDTO();
                participantDTO.setId(String.valueOf(participantUser.getId()));
                participantDTO.setName(participantUser.getUsername());
                participantDTO.setAvatar(participantUser.getAvatar());
                participantDTO.setRole("participant");
                participantDTOS.add(participantDTO);
            }

            activityaaDTO.setParticipants(participantDTOS);
            activityaaDTOS.add(activityaaDTO);
        }

        return activityaaDTOS;
    }


    @Override
    public List<ActivityaaDTO> getCreatedActivities(Integer userId) {
        // 获取该用户创建的所有活动
        List<Activities> activities = activitiesMapper.findByOrganizerId(userId);
        List<ActivityaaDTO> activityaaDTOS = new ArrayList<>();

        // 遍历每个活动，获取详细信息
        for (Activities activity : activities) {
            ActivityaaDTO activityaaDTO = new ActivityaaDTO();
            activityaaDTO.setId(String.valueOf(activity.getId()));
            activityaaDTO.setName(activity.getName());

            ActivityDTO activityDTO = new ActivityDTO();
            activityDTO.setStart_time(activity.getStart_time());
            activityDTO.setEnd_time(activity.getEnd_time());
            activityDTO.setStatus((String) activity.getStatus());
            activityDTO.setAddress(activity.getAddress());
            activityDTO.setMaxParticipants(activity.getMax_participants());
            activityDTO.setType((String) activity.getType());
            activityDTO.setDescription(activity.getDescription());
            activityDTO.setOrganizerId(activity.getOrganizer_id());
            activityDTO.setName(activity.getName());

            // 获取当前活动的参与者数量
            List<Participants> activityParticipants = participantsMapper.findByActivityId(activity.getId());
            activityDTO.setCurrentParticipants(activityParticipants.size());

            activityaaDTO.setActivity(activityDTO);

            // 获取活动创建者信息
            Users user = userClient.getUserById(activity.getOrganizer_id());
            CreatorDTO creatorDTO = new CreatorDTO();
            creatorDTO.setId(String.valueOf(user.getId()));
            creatorDTO.setName(user.getUsername());
            creatorDTO.setAvatar(user.getAvatar());
            creatorDTO.setRole("organizer");
            activityaaDTO.setCreator(creatorDTO);

            // 获取活动参与者信息
            List<ParticipantDTO> participantDTOS = new ArrayList<>();
            for (Participants p : activityParticipants) {
                Users participantUser = userClient.getUserById(p.getParticipant_id());
                ParticipantDTO participantDTO = new ParticipantDTO();
                participantDTO.setId(String.valueOf(participantUser.getId()));
                participantDTO.setName(participantUser.getUsername());
                participantDTO.setAvatar(participantUser.getAvatar());
                participantDTO.setRole("participant");
                participantDTOS.add(participantDTO);
            }

            activityaaDTO.setParticipants(participantDTOS);
            activityaaDTOS.add(activityaaDTO);
        }

        return activityaaDTOS;
    }

    @Override
    public void joinActivity(Integer activityId, Integer userId) {
        Participants participant = new Participants();
        participant.setActivity_id(activityId);
        participant.setParticipant_id(userId);
        participantsMapper.insert(activityId, userId);
    }

    @Override
    public void quitActivity(Integer activityId, Integer userId) {
        participantsMapper.deleteByActivityIdAndParticipantId(activityId, userId);

    }


}

