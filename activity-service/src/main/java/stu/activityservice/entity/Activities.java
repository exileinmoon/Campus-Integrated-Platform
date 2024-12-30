package stu.activityservice.entity;

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
 * 
 * @TableName activities
 */
@TableName(value ="activities")
@Data
@Getter
@Setter
public class Activities implements Serializable {
    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    @TableField(value = "current_participants")
    private Integer current_participants;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */

    /**
     * 
     */
    @TableField(value = "start_time")
    private Date start_time;

    /**
     * 
     */
    @TableField(value = "end_time")
    private Date end_time;

    /**
     * 
     */
    @TableField(value = "status")
    private Object status;

    /**
     * 
     */
    @TableField(value = "address")
    private String address;

    /**
     * 
     */
    @TableField(value = "max_participants")
    private Integer max_participants;

    /**
     * 
     */
    @TableField(value = "type")
    private Object type;

    /**
     * 
     */
    @TableField(value = "description")
    private String description;

    /**
     * 
     */
    @TableField(value = "organizer_id")
    private Integer organizer_id;
    @TableField(value = "point")
    private String point;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}