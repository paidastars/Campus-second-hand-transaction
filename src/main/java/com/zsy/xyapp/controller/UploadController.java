package com.zsy.xyapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsy.xyapp.entity.Commodity;
import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.mapper.CommodityMapper;
import com.zsy.xyapp.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


@Controller
public class UploadController {

    private String name="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityService commodityService;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("title")String title,@RequestParam("category") String category
    ,@RequestParam("price") String price,@RequestParam("phone") String phone
    ,@RequestParam("description") String description,@RequestParam("username") String username){
        Commodity commodity=new Commodity();
        commodity.setTitle(title);
        commodity.setCategory(category);
        commodity.setPrice(price);
        commodity.setPhone(phone);
        commodity.setDescription(description);
        commodity.setUsername(username);
        commodity.setPicture(name);
        commodityService.save(commodity);
        return "1";
    }


    @RequestMapping("/uploadAudio")
    @ResponseBody
    public void uploadAudio(@RequestParam MultipartFile file) {
        System.out.println(file.getOriginalFilename());

        if (!file.isEmpty()) {

            String uuid = UUID.randomUUID().toString().replace("-","");
            setName(uuid+".jpg");

            try {
                String fileurl = "G:/idea work/xyapp/src/main/java/com/zsy/xyapp/img/"+name;
                File f = new File(fileurl);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
                if (!f.exists()) {
                    try {
                        f.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("上传失败，因为文件是空的.");
        }
    }
}
