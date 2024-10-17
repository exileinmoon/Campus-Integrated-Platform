package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.friendservice.DTO.AddconmentDTO;
import stu.friendservice.DTO.CommentDTO;
import stu.friendservice.client.UserClient;
import stu.friendservice.entity.Comments;
import stu.friendservice.mapper.CommentsMapper;
import stu.friendservice.service.CommentsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private UserClient userClient;

    @Override
    public Comments getCommentById(Integer id) {
        return commentsMapper.selectById(id);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentsMapper.selectAll();
    }

    @Override
    public boolean createComment(Comments comments) {
        return commentsMapper.insert(comments) > 0;
    }

    @Override
    public boolean updateComment(Comments comments) {
        return commentsMapper.updateById(comments) > 0;
    }

    @Override
    public boolean deleteComment(Integer id) {
        return commentsMapper.deleteById(id) > 0;
    }

    @Override
    public void addComment(AddconmentDTO comments) {
        Comments comment=new Comments(comments.getUserId(), comments.getLoveId(), comments.getContent());
        commentsMapper.insert(comment);
    }

    @Override
    public List<CommentDTO> getComments(Integer id) {
        List<CommentDTO> list= new ArrayList<CommentDTO>();
        for(Comments comments: commentsMapper.selectByUserId(id)){
            CommentDTO comment = new CommentDTO();
            comment.setComments(comments);
            comment.setUsername(userClient.getUserById(comments.getTarget_user_id()).getUsername());
            comment.setAvatar(userClient.getUserById(comments.getTarget_user_id()).getAvatar());
            list.add(comment);
        }
        return list;
    }
}
