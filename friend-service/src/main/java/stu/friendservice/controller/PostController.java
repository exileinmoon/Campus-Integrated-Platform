package stu.friendservice.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.friendservice.DTO.CommentRequest;
import stu.friendservice.DTO.PostDTO;
import stu.friendservice.DTO.PostDetiles;
import stu.friendservice.service.PostsService;

import java.util.List;

@RestController
@RequestMapping("/api/friend/posts")
public class PostController {

    @Autowired
    private PostsService postService;

    // 获取所有帖子
    @GetMapping("/list")
    public List<PostDTO> listPosts() {
        return postService.listPosts();
    }

    // 添加帖子
    @PostMapping("/add")
    public void addPost(PostDTO post) {
        postService.addPost(post);
    }

    // 根据帖子ID获取单个帖子
    @GetMapping("/{postId}")
    public PostDetiles getPostById(@PathVariable("postId") int postId) {
        return postService.getPostById(postId);
    }
    // 提交评论接口
    @PostMapping("/{postId}/comments")
    public void addComment(
            @PathVariable("postId") int postId,
            @RequestBody CommentRequest commentRequest) {
        System.out.println(commentRequest);
        // 处理评论的保存
        postService.addComment(postId, commentRequest);
    }


    // 点赞接口
    @PostMapping("/{postId}/like")
    public void likePost(@PathVariable("postId") int postId) {
        // 处理点赞的逻辑
        postService.likePost(postId);
    }
}
