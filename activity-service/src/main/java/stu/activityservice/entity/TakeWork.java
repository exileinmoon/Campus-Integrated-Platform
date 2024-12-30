package stu.activityservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName take_work
 */
@TableName(value ="take_work")
@Data
public class TakeWork implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 
     */
    @TableField(value = "task_id")
    private Integer task_id;

    /**
     * 
     */
    @TableField(value = "accepted_id")
    private Integer accepted_id;

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
        TakeWork other = (TakeWork) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTask_id() == null ? other.getTask_id() == null : this.getTask_id().equals(other.getTask_id()))
            && (this.getAccepted_id() == null ? other.getAccepted_id() == null : this.getAccepted_id().equals(other.getAccepted_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTask_id() == null) ? 0 : getTask_id().hashCode());
        result = prime * result + ((getAccepted_id() == null) ? 0 : getAccepted_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", task_id=").append(task_id);
        sb.append(", accepted_id=").append(accepted_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}