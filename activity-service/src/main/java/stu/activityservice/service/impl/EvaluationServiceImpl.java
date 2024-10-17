package stu.activityservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import stu.activityservice.entity.Evaluations;
import stu.activityservice.mapper.EvaluationMapper;
import stu.activityservice.service.EvaluationService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 李
* @description 针对表【evaluations】的数据库操作Service实现
* @createDate 2024-10-17 19:14:27
*/


@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public void addEvaluation(Evaluations evaluation) {
        evaluationMapper.insertEvaluation(evaluation);
    }

    @Override
    public List<Evaluations> getEvaluationsByTaskId(int taskId) {
        return evaluationMapper.getEvaluationsByTaskId(taskId);
    }

    @Override
    public List<Evaluations> getEvaluationsByUserId(int userId) {
        return evaluationMapper.getEvaluationsByUserId(userId);
    }
}




