package com.zsy.xyapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsy.xyapp.entity.Commodity;
import com.zsy.xyapp.entity.CommodityVO;
import com.zsy.xyapp.mapper.CollectionMapper;
import com.zsy.xyapp.mapper.CommodityMapper;
import com.zsy.xyapp.mapper.ReviewMapper;
import com.zsy.xyapp.service.CollectionService;
import com.zsy.xyapp.service.CommodityService;
import com.zsy.xyapp.util.PicTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyCommodityController {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private CollectionService collectionService;

    @PostMapping("/mycommodity")
    @ResponseBody
    public List findCommodityByUser(@RequestParam("username")String username){
        List<CommodityVO> list2=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username",username);
        List list = commodityMapper.selectList(wrapper);

        Object[] objects = list.toArray();

        for (int i=0;i<objects.length;i++){
            Commodity commodity=(Commodity)objects[i];

            CommodityVO commodityVO=new CommodityVO();
            String picture = commodity.getPicture();
            Integer id = commodity.getId();
            String title = commodity.getTitle();
            String category = commodity.getCategory();
            String price = commodity.getPrice();
            String phone = commodity.getPhone();
            String description = commodity.getDescription();
            String username2 = commodity.getUsername();

            //转换成比特
            String a="G:/idea work/xyapp/src/main/java/com/zsy/xyapp/img/"+picture;
            byte[] bytes = PicTran.image2byte(a);

            commodityVO.setId(id);
            commodityVO.setTitle(title);
            commodityVO.setCategory(category);
            commodityVO.setPrice(price);
            commodityVO.setPhone(phone);
            commodityVO.setDescription(description);
            commodityVO.setUsername(username2);
            commodityVO.setPicture(bytes);
            list2.add(commodityVO);
        }
        return list2;
    }

    @PostMapping("/delcommodity")
    @ResponseBody
    public String delCommodity(@RequestParam("id")String id) {
        commodityMapper.deleteById(id);
        QueryWrapper map=new QueryWrapper();
        map.eq("commodityid",id);
        reviewMapper.delete(map);
        collectionService.remove(map);
        return "1";
    }
}
