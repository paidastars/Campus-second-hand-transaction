package com.zsy.xyapp.mapper;

import com.zsy.xyapp.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.zsy.xyapp.entity.Commodity
 */
@Mapper
@Repository
public interface CommodityMapper extends BaseMapper<Commodity> {

}




