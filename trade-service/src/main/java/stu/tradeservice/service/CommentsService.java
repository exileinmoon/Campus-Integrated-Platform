package stu.tradeservice.service;

import stu.tradeservice.entity.Comments;

import java.util.List;

public interface CommentsService {
    int insertComment(Comments comment);
    List<Comments> selectAllComments();
    Comments selectCommentById(Long id);
    int updateComment(Comments comment);
    int deleteComment(Long id);
}