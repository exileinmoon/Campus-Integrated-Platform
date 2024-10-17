package stu.activityservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.activityservice.entity.Activities;

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
    @Insert("INSERT INTO activities (join_user_id, start_time, end_time, status, address, max_participants, type, description, organizer_id,point) " +
            "VALUES (#{join_user_id}, #{start_time}, #{end_time}, #{status}, #{address}, #{max_participants}, #{type}, #{description}, #{organizer_id}#{point})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // 自动生成主键
    void insert(Activities activity);

    // 更新活动
    @Update("UPDATE activities SET join_user_id = #{join_user_id}, start_time = #{start_time}, end_time = #{end_time}, " +
            "status = #{status}, address = #{address}, max_participants = #{max_participants}, type = #{type}, " +
            "description = #{description}, organizer_id = #{organizer_id} WHERE id = #{id}")
    void update(Activities activity);

    // 删除活动
    @Delete("DELETE FROM activities WHERE id = #{id}")
    void delete(Integer id);

    @Select("SELECT * FROM activities WHERE join_user_id = organizer_id")
    List<Activities> getActivities();
}
