package stu.activityservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import stu.activityservice.entity.Participants;
import stu.activityservice.service.ParticipantsService;
import stu.activityservice.mapper.ParticipantsMapper;
import org.springframework.stereotype.Service;

/**
* @author 李
* @description 针对表【participants】的数据库操作Service实现
* @createDate 2024-12-25 20:02:24
*/
@Service
public class ParticipantsServiceImpl extends ServiceImpl<ParticipantsMapper, Participants>
    implements ParticipantsService{

}




