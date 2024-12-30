package stu.tradeservice.entity;

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
 * @TableName comments
 */
@TableName(value ="comments")
@Data
@Getter
@Setter
public class Comments implements Serializable {
    @TableField(value = "star")
    private Integer star;
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "product_id")
    private Integer product_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "content")
    private String content;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date created_at;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Comments(  Integer product_id, Integer user_id, String content, Integer star, Date created_at, Integer id) {

        this.product_id = product_id;
        this.user_id = user_id;
        this.content = content;
        this.star = star;
        this.created_at = created_at;
        this.id = id;
    }
    public Comments() {
    }
}