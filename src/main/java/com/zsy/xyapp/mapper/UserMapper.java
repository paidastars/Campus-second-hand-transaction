package com.zsy.xyapp.mapper;

import com.zsy.xyapp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.zsy.xyapp.entity.User
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}




