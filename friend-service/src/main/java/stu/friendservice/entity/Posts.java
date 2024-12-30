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
 * 帖子表
 * @TableName posts
 */
@TableName(value ="posts")
@Data
@Getter
@Setter
public class Posts implements Serializable {
    /**
     * 帖子ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属板块ID
     */
    @TableField(value = "section_id")
    private String section_id;

    /**
     * 发帖用户ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 浏览量
     */
    @TableField(value = "views")
    private Integer views;

    /**
     * 评论数
     */
    @TableField(value = "comments")
    private Integer comments;

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
     * 是否置顶:0-否,1-是
     */
    @TableField(value = "is_top")
    private Integer is_top;

    /**
     * 是否热门:0-否,1-是
     */
    @TableField(value = "is_hot")
    private Integer is_hot;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date created_at;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updated_at;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}