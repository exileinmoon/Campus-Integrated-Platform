package stu.activityservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.activityservice.entity.Job;
import stu.activityservice.entity.Tasks;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 李
* @description 针对表【tasks】的数据库操作Mapper
* @createDate 2024-10-17 19:14:31
* @Entity stu.activityservice.entity.Tasks
*/
@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO tasks (publisher_id, title, description, location, reward, deadline, status) " +
            "VALUES (#{publisherId}, #{title}, #{description}, #{location}, #{reward}, #{deadline}, #{status})")
    void insertTask(Tasks task);

    @Select("SELECT * FROM tasks WHERE task_id = #{taskId}")
    Tasks getTaskById(int taskId);

    @Select("SELECT * FROM tasks WHERE publisher_id = #{publisherId}")
    List<Tasks> getTasksByPublisherId(int publisherId);

    @Update("UPDATE tasks SET status = #{status} WHERE task_id = #{taskId}")
    void updateTaskStatus(@Param("taskId") int taskId, @Param("status") String status);

    @Delete("DELETE FROM tasks WHERE task_id = #{taskId}")
    void deleteTask(int taskId);

    @Select("SELECT * FROM tasks")

    List<Tasks> getAllTasks();
}




