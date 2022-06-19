package com.zsy.xyapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsy.xyapp.entity.Commodity;
import com.zsy.xyapp.entity.CommodityVO;
import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.mapper.CommodityMapper;
import com.zsy.xyapp.service.CommodityService;
import com.zsy.xyapp.util.PicTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ShowController {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/show")
    @ResponseBody
    public List<CommodityVO> findAll() {
        List<CommodityVO> list=new ArrayList<>();
        List<Commodity> list2=commodityMapper.selectList(null);

        //把照片路径拿出来,并且放近vo
        Object[] objects = list2.toArray();

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
            String username = commodity.getUsername();

            //转换成比特
            String a="G:/idea work/xyapp/src/main/java/com/zsy/xyapp/img/"+picture;
            byte[] bytes = PicTran.image2byte(a);

            commodityVO.setId(id);
            commodityVO.setTitle(title);
            commodityVO.setCategory(category);
            commodityVO.setPrice(price);
            commodityVO.setPhone(phone);
            commodityVO.setDescription(description);
            commodityVO.setUsername(username);
            commodityVO.setPicture(bytes);
            list.add(commodityVO);
        }
        return list;
    }

    @PostMapping("/showtype")
    @ResponseBody
    public List<CommodityVO> findType(@RequestParam("category")String category) {
        List<CommodityVO> list=new ArrayList<>();
        QueryWrapper<Commodity> wrapper=new QueryWrapper<>();
        wrapper.like("category",category);
        List<Commodity> list2=commodityMapper.selectList(wrapper);
        //把照片路径拿出来,并且放近vo
        Object[] objects = list2.toArray();

        for (int i=0;i<objects.length;i++){
            Commodity commodity=(Commodity)objects[i];

            CommodityVO commodityVO=new CommodityVO();
            String picture = commodity.getPicture();
            Integer id = commodity.getId();
            String title = commodity.getTitle();
            String category2 = commodity.getCategory();
            String price = commodity.getPrice();
            String phone = commodity.getPhone();
            String description = commodity.getDescription();
            String username = commodity.getUsername();

            //转换成比特
            String a="G:/idea work/xyapp/src/main/java/com/zsy/xyapp/img/"+picture;
            byte[] bytes = PicTran.image2byte(a);

            commodityVO.setId(id);
            commodityVO.setTitle(title);
            commodityVO.setCategory(category2);
            commodityVO.setPrice(price);
            commodityVO.setPhone(phone);
            commodityVO.setDescription(description);
            commodityVO.setUsername(username);
            commodityVO.setPicture(bytes);
            list.add(commodityVO);
        }
        return list;
    }
}
