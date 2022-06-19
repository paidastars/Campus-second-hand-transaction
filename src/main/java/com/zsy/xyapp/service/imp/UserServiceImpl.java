package com.zsy.xyapp.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsy.xyapp.entity.User;
import com.zsy.xyapp.service.UserService;
import com.zsy.xyapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    private UserMapper userMapper;
}




