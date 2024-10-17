package stu.friendservice.service;

import stu.friendservice.DTO.AddconmentDTO;
import stu.friendservice.DTO.CommentDTO;
import stu.friendservice.entity.Comments;
import java.util.List;

public interface CommentsService {

    Comments getCommentById(Integer id);

    List<Comments> getAllComments();

    boolean createComment(Comments comments);

    boolean updateComment(Comments comments);

    boolean deleteComment(Integer id);
    void addComment(AddconmentDTO comments);

    List<CommentDTO> getComments(Integer id);
}
