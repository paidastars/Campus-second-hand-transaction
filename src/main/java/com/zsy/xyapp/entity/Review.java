package com.zsy.xyapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName review
 */
@TableName(value ="review")
@Data
public class Review implements Serializable {

    @TableId(type = IdType.AUTO)

    @TableField(value = "`id`")
    private Integer id;

    @TableField(value = "`username`")
    private String username;

    @TableField(value = "`current_time`")
    private String currentTime;

    @TableField(value = "`content`")
    private String content;


    @TableField(value = "`commodityid`")
    private Integer commodityid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
