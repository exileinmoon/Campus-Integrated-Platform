package stu.activityservice.mapper;

import stu.activityservice.entity.Evaluations;

/**
* @author 李
* @description 针对表【evaluations】的数据库操作Mapper
* @createDate 2024-10-17 19:14:27
* @Entity stu.activityservice.entity.Evaluations
*/
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface EvaluationMapper {
    @Insert("INSERT INTO evaluations (task_id, user_id, rating, comment) " +
            "VALUES (#{taskId}, #{userId}, #{rating}, #{comment})")
    void insertEvaluation(Evaluations evaluation);

    @Select("SELECT * FROM evaluations WHERE task_id = #{taskId}")
    List<Evaluations> getEvaluationsByTaskId(int taskId);

    @Select("SELECT * FROM evaluations WHERE user_id = #{userId}")
    List<Evaluations> getEvaluationsByUserId(int userId);
}
