package com.zsy.xyapp.controller;

import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @ResponseBody
    public String Register(@RequestParam("username")String username, @RequestParam("password") String password){
        User user=new User();
        user.setUsername(Integer.valueOf(username));
        user.setPassword(password);
        boolean result = false;
        try {
            //数据库保存
            result = userService.save(user);
        } catch (Exception e) {
            //异常
            return "1";
        }
        //成功
        return "2";
    }
}
