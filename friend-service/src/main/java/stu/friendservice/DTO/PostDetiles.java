package stu.friendservice.DTO;

import stu.friendservice.entity.PostComments;

import java.util.List;

public class PostDetiles {
    private PostDTO post;
    private List<PostCommentDTO> comments;

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public List<PostCommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<PostCommentDTO> comments) {
        this.comments = comments;
    }
}