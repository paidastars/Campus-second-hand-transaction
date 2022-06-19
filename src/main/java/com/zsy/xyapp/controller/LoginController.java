package com.zsy.xyapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.mapper.UserMapper;
import com.zsy.xyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @RequestMapping("/all")
    @ResponseBody
    public List<User> findAll(){
        return userMapper.selectByMap(null);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username")String username,@RequestParam("password") String password){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        wrapper.eq("password",password);
        //去数据库查找是否有
        User user= userService.getOne(wrapper);
        if(user!=null){
            return "2";
        }else {
            return "1";
        }
    }
}
