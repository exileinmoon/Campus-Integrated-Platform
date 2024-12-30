package stu.activityservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.activityservice.entity.Activities;
import stu.activityservice.entity.Participants;

import java.util.List;

@Mapper
public interface ActivitiesMapper {

    // 获取所有活动
    @Select("SELECT * FROM activities")
    List<Activities> findAll();

    // 根据 ID 获取活动
    @Select("SELECT * FROM activities WHERE id = #{id}")
    Activities findById(Integer id);

    // 插入新活动
    @Insert("INSERT INTO activities (name,current_participants, start_time, end_time, status, address, max_participants, type, description, organizer_id) " +
            "VALUES (#{name},#{current_participants}, #{start_time}, #{end_time}, #{status}, #{address}, #{max_participants}, #{type}, #{description}, #{organizer_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // 自动生成主键
    void insert(Activities activity);

    // 更新活动
    @Update("UPDATE activities SET name = #{name}, current_participants = #{current_participants}, start_time = #{start_time}, end_time = #{end_time}, status = #{status}, address = #{address}, max_participants = #{max_participants}, type = #{type}, description = #{description}, organizer_id = #{organizer_id} WHERE id = #{id}")
    void update(Activities activity);

    // 删除活动
    @Delete("DELETE FROM activities WHERE id = #{id}")
    void delete(Integer id);

    @Select("SELECT * FROM activities")
    List<Activities> getActivities();
    @Select("SELECT * FROM participants WHERE activity_id = #{id}")
    List<Participants> findParticipantsByActivityId(Integer id);
    @Select("SELECT * FROM activities WHERE organizer_id = #{userId}")
    List<Activities> findByOrganizerId(Integer userId);
}
