package stu.friendservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 评论表
 * @TableName post_comments
 */
@TableName(value ="post_comments")
@Data
@Setter
@Getter
public class PostComments implements Serializable {
    /**
     * 评论ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 帖子ID
     */
    @TableField(value = "post_id")
    private Long post_id;

    /**
     * 评论用户ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 父评论ID(用于回复功能)
     */
    @TableField(value = "parent_id")
    private Long parent_id;

    /**
     * 点赞数
     */
    @TableField(value = "likes")
    private Integer likes;

    /**
     * 状态:0-删除,1-正常
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date created_at;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



}