package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import stu.friendservice.DTO.CommentRequest;
import stu.friendservice.DTO.PostCommentDTO;
import stu.friendservice.DTO.PostDTO;
import stu.friendservice.DTO.PostDetiles;
import stu.friendservice.client.UserClient;
import stu.friendservice.entity.PostComments;
import stu.friendservice.entity.Posts;
import stu.friendservice.entity.Users;
import stu.friendservice.mapper.PostCommentsMapper;
import stu.friendservice.service.PostsService;
import stu.friendservice.mapper.PostsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
* @author 李
* @description 针对表【posts(帖子表)】的数据库操作Service实现
* @createDate 2024-12-17 08:53:51
*/
@Service
public class PostsServiceImpl implements PostsService{
    @Autowired
    private PostsMapper postsMapper;
    @Autowired
    private UserClient userClient;
    @Autowired
    private PostCommentsMapper postCommentsMapper;
    @Override
    public List<PostDTO> listPosts() {
        List<Posts> postDTOS = postsMapper.findAllPosts();
        List<PostDTO> postDTOList =new ArrayList<>();
        for(Posts post:postDTOS){
            PostDTO postDTO = new PostDTO();
            postDTO.setPost(post);
            postDTO.setUser(userClient.getUserById(post.getUser_id()));
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }

    @Override
    public void addPost(PostDTO post) {

    }

    @Override
    public PostDetiles getPostById(int postId) {
        Posts post = postsMapper.findPostById((long) postId);
        Users user = userClient.getUserById(post.getUser_id());
        PostDTO postDTO = new PostDTO();
        postDTO.setPost(post);
        postDTO.setUser(user);
        PostDetiles postDetiles = new PostDetiles();
        postDetiles.setPost(postDTO);
        List<PostComments> comments = postCommentsMapper.selectByPostId(postId);
        List<PostCommentDTO> commentDTOS = new ArrayList<>();
       for(PostComments comment:comments) {
           PostCommentDTO commentDTO = new PostCommentDTO();
           commentDTO.setComment(comment);
           commentDTO.setUser(userClient.getUserById(comment.getUser_id()));
           commentDTOS.add(commentDTO);
       }
        postDetiles.setComments(commentDTOS);
        return postDetiles;
    }

    @Override
    public void addComment(int postId, String content) {

    }


    @Override
    public void addComment(int postId, CommentRequest commentRequest) {
        // 获取帖子
        Posts post = postsMapper.findPostById((long) postId);

        // 创建评论实体
        PostComments comment = new PostComments();

      System.out.println(commentRequest.getParent_id());
        if (Objects.nonNull(commentRequest.getParent_id())) {
            // 如果是回复评论
            comment.setParent_id(Long.parseLong(commentRequest.getParent_id()));
        }
        comment.setPost_id((long) postId);
        comment.setContent(commentRequest.getContent());
        comment.setUser_id(1L);
        // 保存评论到数据库
        postCommentsMapper.insertPostComment(comment);

        // 更新帖子的评论数
        post.setComments(post.getComments() + 1);
        postsMapper.updateById(post);  // 使用 MyBatis-Plus 提供的 updateById 方法来更新帖子

    }


    @Override
    public void likePost(int postId) {
        // 获取帖子
        Posts post = postsMapper.findPostById((long) postId);

        // 增加点赞数
        post.setLikes(post.getLikes() + 1);

        // 更新帖子
        postsMapper.updateById(post);
    }
}




