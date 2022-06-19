package com.zsy.xyapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsy.xyapp.entity.CommodityVO;
import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.mapper.UserMapper;
import com.zsy.xyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/myuser")
    @ResponseBody
    public User MyUser(@RequestParam("username") String username){
        User user = userMapper.selectById(username);
        return user;
    }

    @PostMapping("/updatepassword")
    @ResponseBody
    public String UpdateUser(@RequestParam("username") String username,@RequestParam("password") String password){
        User user =new User();
        user.setUsername(Integer.valueOf(username));
        user.setPassword(password);
        userMapper.updateById(user);
        return "1";
    }

    @PostMapping("/updateuser")
    @ResponseBody
    public String Update(@RequestParam("username") String username,@RequestParam("name") String name
    ,@RequestParam("major") String major,@RequestParam("phone") String phone
    ,@RequestParam("qq") String qq,@RequestParam("address") String address){
        User user =new User();
        user.setUsername(Integer.valueOf(username));
        user.setName(name);
        user.setMajor(major);
        user.setPhone(phone);
        user.setQq(qq);
        user.setAddress(address);
        userMapper.updateById(user);
        return "1";
    }
}
