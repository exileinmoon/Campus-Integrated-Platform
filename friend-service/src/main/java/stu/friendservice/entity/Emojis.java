package stu.friendservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName emojis
 */
@TableName(value ="emojis")
@Data
public class Emojis implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "emoji_code")
    private String emoji_code;

    /**
     * 
     */
    @TableField(value = "emoji_url")
    private String emoji_url;

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
        Emojis other = (Emojis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmoji_code() == null ? other.getEmoji_code() == null : this.getEmoji_code().equals(other.getEmoji_code()))
            && (this.getEmoji_url() == null ? other.getEmoji_url() == null : this.getEmoji_url().equals(other.getEmoji_url()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmoji_code() == null) ? 0 : getEmoji_code().hashCode());
        result = prime * result + ((getEmoji_url() == null) ? 0 : getEmoji_url().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", emoji_code=").append(emoji_code);
        sb.append(", emoji_url=").append(emoji_url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}