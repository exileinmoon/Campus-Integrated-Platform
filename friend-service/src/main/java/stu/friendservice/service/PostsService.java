package stu.friendservice.service;

import stu.friendservice.DTO.CommentRequest;
import stu.friendservice.DTO.PostDTO;
import stu.friendservice.DTO.PostDetiles;

import java.util.List;

/**
* @author 李
* @description 针对表【posts(帖子表)】的数据库操作Service
* @createDate 2024-12-17 08:53:51
*/
public interface PostsService  {

    List<PostDTO> listPosts();

    void addPost(PostDTO post);

    PostDetiles getPostById(int postId);

    void addComment(int postId, String content);

    void addComment(int postId, CommentRequest commentRequest);

    void likePost(int postId);


}
