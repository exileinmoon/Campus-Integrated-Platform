package stu.friendservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import stu.friendservice.entity.Emojis;
import stu.friendservice.service.EmojisService;
import stu.friendservice.mapper.EmojisMapper;
import org.springframework.stereotype.Service;

/**
* @author 李
* @description 针对表【emojis】的数据库操作Service实现
* @createDate 2024-10-14 21:32:41
*/
@Service
public class EmojisServiceImpl extends ServiceImpl<EmojisMapper, Emojis>
    implements EmojisService{

}




