package stu.friendservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comments
 */
@TableName(value ="comments")
@Data
public class Comments implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "target_user_id")
    private Integer target_user_id;

    /**
     * 
     */
    @TableField(value = "content")
    private String content;

    /**
     * 
     */
    @TableField(value = "likes")
    private Integer likes;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date created_at;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Comments(Integer id, Integer userId, String comments) {
        this.target_user_id=id;
        this.user_id = userId;
        this.content = comments;
        this.likes = 0;
        this.created_at = new Date();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Comments other = (Comments) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getTarget_user_id() == null ? other.getTarget_user_id() == null : this.getTarget_user_id().equals(other.getTarget_user_id()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getLikes() == null ? other.getLikes() == null : this.getLikes().equals(other.getLikes()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getTarget_user_id() == null) ? 0 : getTarget_user_id().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getLikes() == null) ? 0 : getLikes().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", target_user_id=").append(target_user_id);
        sb.append(", content=").append(content);
        sb.append(", likes=").append(likes);
        sb.append(", created_at=").append(created_at);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}