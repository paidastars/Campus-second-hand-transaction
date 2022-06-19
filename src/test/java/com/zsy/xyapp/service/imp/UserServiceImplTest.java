package com.zsy.xyapp.service.imp;

import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
@Autowired
    private UserMapper userMapper;
@Test
private String findAll(){
    User user=new User();
    user=userMapper.selectById(1);
    System.out.println(user);
    return "1";
}
}
