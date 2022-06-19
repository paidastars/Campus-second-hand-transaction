package com.zsy.xyapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsy.xyapp.entity.Commodity;
import com.zsy.xyapp.entity.Review;
import com.zsy.xyapp.mapper.ReviewMapper;
import com.zsy.xyapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/getReview")
    @ResponseBody
    public String AddReview(@RequestParam("username")String username,@RequestParam("currentTime")String currentTime
    ,@RequestParam("content")String content,@RequestParam("id")String id){
        Review review=new Review();
        review.setUsername(username);
        review.setContent(content);
        review.setCurrentTime(currentTime);
        review.setCommodityid(Integer.valueOf(id));

        try {
            //添加
            reviewMapper.insert(review);
            return "1";
        } catch (Exception e) {
            return "2";
        }
    }


    @PostMapping("/reviewShow")
    @ResponseBody
    public List<Review> reviewShow(@RequestParam("id")String id){
        QueryWrapper<Review> wrapper=new QueryWrapper<>();
        wrapper.like("commodityid",id);
        //查出来
        List<Review> list=reviewMapper.selectList(wrapper);
        return list;
    }
}
