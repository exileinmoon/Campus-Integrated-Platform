package stu.activityservice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import stu.activityservice.entity.TakeWork;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 李
* @description 针对表【take_work】的数据库操作Mapper
* @createDate 2024-12-25 17:30:28
* @Entity stu.activityservice.entity.TakeWork
*/
public interface TakeWorkMapper extends BaseMapper<TakeWork> {
    @Insert("insert into take_work (accepted_id, task_id) values (#{userId}, #{taskId})")
    void insertTakeWork(Integer userId, Integer taskId);
    @Select("select * from take_work where accepted_id = #{userId}")
    List<TakeWork> selectByUserId(Integer userId);
}




