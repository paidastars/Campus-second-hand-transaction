package com.zsy.xyapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     *
     */
    @TableId
    private Integer username;

    private String password;

    private String name;

    private String major;

    private String phone;

    private String qq;

    private String address;

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
        User other = (User) that;
        return (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", major=").append(major);
        sb.append(", phone=").append(phone);
        sb.append(", qq=").append(qq);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
