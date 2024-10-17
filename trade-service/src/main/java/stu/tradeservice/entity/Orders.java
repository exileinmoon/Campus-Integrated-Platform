package stu.tradeservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
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
    @TableField(value = "product_id")
    private Integer product_id;

    /**
     * 
     */
    @TableField(value = "status")
    private Object status;

    /**
     * 
     */
    @TableField(value = "recipient_name")
    private String recipient_name;

    /**
     * 
     */
    @TableField(value = "recipient_address")
    private String recipient_address;

    /**
     * 
     */
    @TableField(value = "recipient_phone")
    private String recipient_phone;

    /**
     * 
     */
    @TableField(value = "payment_method")
    private Object payment_method;

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
        Orders other = (Orders) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getProduct_id() == null ? other.getProduct_id() == null : this.getProduct_id().equals(other.getProduct_id()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecipient_name() == null ? other.getRecipient_name() == null : this.getRecipient_name().equals(other.getRecipient_name()))
            && (this.getRecipient_address() == null ? other.getRecipient_address() == null : this.getRecipient_address().equals(other.getRecipient_address()))
            && (this.getRecipient_phone() == null ? other.getRecipient_phone() == null : this.getRecipient_phone().equals(other.getRecipient_phone()))
            && (this.getPayment_method() == null ? other.getPayment_method() == null : this.getPayment_method().equals(other.getPayment_method()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getProduct_id() == null) ? 0 : getProduct_id().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecipient_name() == null) ? 0 : getRecipient_name().hashCode());
        result = prime * result + ((getRecipient_address() == null) ? 0 : getRecipient_address().hashCode());
        result = prime * result + ((getRecipient_phone() == null) ? 0 : getRecipient_phone().hashCode());
        result = prime * result + ((getPayment_method() == null) ? 0 : getPayment_method().hashCode());
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
        sb.append(", product_id=").append(product_id);
        sb.append(", status=").append(status);
        sb.append(", recipient_name=").append(recipient_name);
        sb.append(", recipient_address=").append(recipient_address);
        sb.append(", recipient_phone=").append(recipient_phone);
        sb.append(", payment_method=").append(payment_method);
        sb.append(", created_at=").append(created_at);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}