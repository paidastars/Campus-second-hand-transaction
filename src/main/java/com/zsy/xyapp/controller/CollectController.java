package com.zsy.xyapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsy.xyapp.entity.Collection;
import com.zsy.xyapp.entity.Commodity;
import com.zsy.xyapp.entity.CommodityVO;
import com.zsy.xyapp.mapper.CollectionMapper;
import com.zsy.xyapp.mapper.CommodityMapper;
import com.zsy.xyapp.util.PicTran;
import net.sf.jsqlparser.statement.select.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CollectController {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    @PostMapping ("/addcollection")
    @ResponseBody
    public String AddCollection(@RequestParam("id") String id,@RequestParam("username") String username){
        //通过商品id查找
        Commodity commodity = commodityMapper.selectById(id);
        Collection collection =new Collection();
        collection.setTitle(commodity.getTitle());
        collection.setUsername(username);
        collection.setPicture(commodity.getPicture());
        collection.setPhone(commodity.getPhone());
        collection.setDescription(commodity.getDescription());
        collection.setPrice(commodity.getPrice());
        collection.setCommodityid(Integer.valueOf(id));
        //添加数据库
        collectionMapper.insert(collection);
        return "1";
    }

    @PostMapping("/getcollection")
    @ResponseBody
    public List<CommodityVO> showCollection(@RequestParam("username") String username){
        List<CommodityVO> list=new ArrayList<>();
        QueryWrapper<Collection> wrapper=new QueryWrapper<>();
        wrapper.like("username",username);
        //查出来
        List<Collection> list2 = collectionMapper.selectList(wrapper);
        //把照片路径拿出来,并且放近vo
        Object[] objects = list2.toArray();

        for (int i=0;i<objects.length;i++){
            Collection collection=(Collection)objects[i];

            CommodityVO commodityVO=new CommodityVO();
            String picture = collection.getPicture();
            String title = collection.getTitle();
            String price = collection.getPrice();
            String phone = collection.getPhone();
            String description = collection.getDescription();
            Integer id = collection.getId();
            //转换成比特
            String a="G:/idea work/xyapp/src/main/java/com/zsy/xyapp/img/"+picture;
            byte[] bytes = PicTran.image2byte(a);

            commodityVO.setTitle(title);
            commodityVO.setPrice(price);
            commodityVO.setPhone(phone);
            commodityVO.setDescription(description);
            commodityVO.setUsername(username);
            commodityVO.setPicture(bytes);
            commodityVO.setId(id);

            list.add(commodityVO);
        }
        return list;
    }


    @PostMapping("/delcollection")
    @ResponseBody
    public String delCollection(@RequestParam("id") Integer id){
        collectionMapper.deleteById(id);
        return "1";
    }
}
