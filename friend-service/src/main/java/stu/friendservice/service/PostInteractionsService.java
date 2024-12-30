package stu.friendservice.service;

import stu.friendservice.entity.PostInteractions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 李
* @description 针对表【post_interactions】的数据库操作Service
* @createDate 2024-12-27 22:21:23
*/
public interface PostInteractionsService {

    void likePost(Long userId, Long postId);

    void commentPost(Long userId, Long postId, String comment);
}
