package com.zsy.xyapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @TableName collection
 */
@TableName(value ="collection")
@Data
public class Collection implements Serializable {

    @TableId(type = IdType.AUTO)

    @TableField(value = "`id`")
    private Integer id;

    @TableField(value = "`username`")
    private String username;

    @TableField(value = "`picture`")
    private String picture;

    @TableField(value = "`title`")
    private String title;

    @TableField(value = "`description`")
    private String description;

    @TableField(value = "`price`")
    private String price;

    @TableField(value = "`phone`")
    private String phone;

    @TableField(value = "`commodityid`")
    private Integer commodityid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
