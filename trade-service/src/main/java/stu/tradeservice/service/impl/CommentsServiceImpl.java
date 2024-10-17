package stu.tradeservice.service.impl;

import stu.tradeservice.entity.Comments;
import stu.tradeservice.mapper.CommentsMapper;
import stu.tradeservice.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public int insertComment(Comments comment) {
        return commentsMapper.insertComment(comment);
    }

    @Override
    public List<Comments> selectAllComments() {
        return commentsMapper.selectAllComments();
    }

    @Override
    public Comments selectCommentById(Long id) {
        return commentsMapper.selectCommentById(id);
    }

    @Override
    public int updateComment(Comments comment) {
        return commentsMapper.updateComment(comment);
    }

    @Override
    public int deleteComment(Long id) {
        return commentsMapper.deleteComment(id);
    }
}