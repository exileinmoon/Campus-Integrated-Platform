package stu.friendservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import stu.friendservice.entity.PostInteractions;
import stu.friendservice.service.PostInteractionsService;
import stu.friendservice.mapper.PostInteractionsMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author 李
* @description 针对表【post_interactions】的数据库操作Service实现
* @createDate 2024-12-27 22:21:23
*/
@Service
public class PostInteractionsServiceImpl implements PostInteractionsService{
    @Autowired
    private PostInteractionsMapper postInteractionsMapper;

    @Override
    public void likePost(Long userId, Long postId) {
        PostInteractions postInteractions = new PostInteractions();
        postInteractions.setUser_id(Math.toIntExact(userId));
        postInteractions.setPost_id(Math.toIntExact(postId));
        postInteractions.setInteraction_type("like");
        postInteractions.setComment_text("");
        postInteractions.setCreated_at(new Date());
        postInteractionsMapper.insert(postInteractions);

    }

    @Override
    public void commentPost(Long userId, Long postId, String comment) {
        PostInteractions postInteractions = new PostInteractions();
        postInteractions.setUser_id(Math.toIntExact(userId));
        postInteractions.setPost_id(Math.toIntExact(postId));
        postInteractions.setInteraction_type("comment");
        postInteractions.setComment_text(comment);
        postInteractions.setCreated_at(new Date());
        postInteractionsMapper.insert(postInteractions);
    }
}




