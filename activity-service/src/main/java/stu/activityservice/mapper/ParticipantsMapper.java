package stu.activityservice.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import stu.activityservice.entity.Participants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 李
* @description 针对表【participants】的数据库操作Mapper
* @createDate 2024-12-25 20:02:24
* @Entity stu.activityservice.entity.Participants
*/
public interface ParticipantsMapper extends BaseMapper<Participants> {
    @Select("select * from participants where activity_id = #{id}")
    List<Participants> findByActivityId(Integer id);
    @Select("select * from participants where participant_id = #{userId}")
    List<Participants> findByParticipantId(Integer userId);
    @Delete("delete from participants where activity_id = #{activityId} and participant_id = #{userId}")
    void deleteByActivityIdAndParticipantId(Integer activityId, Integer userId);
    @Insert("insert into participants (activity_id, participant_id) values (#{activityId}, #{userId})")
    void insert(Integer activityId, Integer userId);
}




