package com.zsy.xyapp.entity;

import lombok.Data;

@Data
public class CommodityVO {
    private Integer id;
    private String title;
    private String category;
    private String price;
    private String phone;
    private String description;
    private byte[] picture;
    private String username;
}
