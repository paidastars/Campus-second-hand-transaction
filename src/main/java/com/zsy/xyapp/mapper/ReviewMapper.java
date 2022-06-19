package com.zsy.xyapp.mapper;

import com.zsy.xyapp.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.zsy.xyapp.entity.Review
 */

@Mapper
@Repository
public interface ReviewMapper extends BaseMapper<Review> {

}




