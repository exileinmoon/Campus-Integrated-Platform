package stu.activityservice.service;

import stu.activityservice.entity.Evaluations;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 李
* @description 针对表【evaluations】的数据库操作Service
* @createDate 2024-10-17 19:14:27
*/
import java.util.List;

public interface EvaluationService {
    void addEvaluation(Evaluations evaluation);
    List<Evaluations> getEvaluationsByTaskId(int taskId);
    List<Evaluations> getEvaluationsByUserId(int userId);
}
