package stu.activityservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName participants
 */
@TableName(value ="participants")
@Data
public class Participants implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "activity_id")
    private Integer activity_id;

    /**
     * 
     */
    @TableField(value = "participant_id")
    private Integer participant_id;

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
        Participants other = (Participants) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivity_id() == null ? other.getActivity_id() == null : this.getActivity_id().equals(other.getActivity_id()))
            && (this.getParticipant_id() == null ? other.getParticipant_id() == null : this.getParticipant_id().equals(other.getParticipant_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivity_id() == null) ? 0 : getActivity_id().hashCode());
        result = prime * result + ((getParticipant_id() == null) ? 0 : getParticipant_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activity_id=").append(activity_id);
        sb.append(", participant_id=").append(participant_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}