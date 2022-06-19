package com.zsy.xyapp.mapper;

import com.zsy.xyapp.entity.Collection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.zsy.xyapp.entity.Collection
 */

@Mapper
@Repository
public interface CollectionMapper extends BaseMapper<Collection> {
}




