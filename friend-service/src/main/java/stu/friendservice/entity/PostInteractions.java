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
 * @TableName post_interactions
 */
@TableName(value ="post_interactions")
@Data
public class PostInteractions implements Serializable {
    /**
     * 
     */
    @TableId(value = "interaction_id", type = IdType.AUTO)
    private Integer interaction_id;

    /**
     * 
     */
    @TableField(value = "post_id")
    private Integer post_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "interaction_type")
    private Object interaction_type;

    /**
     * 
     */
    @TableField(value = "comment_text")
    private String comment_text;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date created_at;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        PostInteractions other = (PostInteractions) that;
        return (this.getInteraction_id() == null ? other.getInteraction_id() == null : this.getInteraction_id().equals(other.getInteraction_id()))
            && (this.getPost_id() == null ? other.getPost_id() == null : this.getPost_id().equals(other.getPost_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getInteraction_type() == null ? other.getInteraction_type() == null : this.getInteraction_type().equals(other.getInteraction_type()))
            && (this.getComment_text() == null ? other.getComment_text() == null : this.getComment_text().equals(other.getComment_text()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInteraction_id() == null) ? 0 : getInteraction_id().hashCode());
        result = prime * result + ((getPost_id() == null) ? 0 : getPost_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getInteraction_type() == null) ? 0 : getInteraction_type().hashCode());
        result = prime * result + ((getComment_text() == null) ? 0 : getComment_text().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", interaction_id=").append(interaction_id);
        sb.append(", post_id=").append(post_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", interaction_type=").append(interaction_type);
        sb.append(", comment_text=").append(comment_text);
        sb.append(", created_at=").append(created_at);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}