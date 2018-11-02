package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.IBrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private IBrandService brandServiceImpl;


    @RequestMapping("/findAll")
    public List<TbBrand> findAll () {
        List<TbBrand> all = brandServiceImpl.findAll();
        return  all;
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size) {
         return  brandServiceImpl.findPage(page, size);
    }

    @RequestMapping("/addBrand")
    public Result addBrand(@RequestBody TbBrand  tbBrand){  //此处存在一个问题 RequestBody  可以将前台传递的JSON  绑定在指定的 TbBrand 对象中
        int i = brandServiceImpl.addBrand(tbBrand);
        if( i == 1) {
            return  new Result(200,"添加成功");
        }else {
            return new Result(500,"添加失败");
        }
    }


    /**
     *  根据Id查询数据
     * */
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        TbBrand  tbBrand = brandServiceImpl.findOne(id);
        return  tbBrand;
    }

    /**
     *  更新品牌数据
     * */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandServiceImpl.update(tbBrand);
            return  new Result(200,"修改成功");
        }catch (Exception e){
            return  new Result(400,"修改失败");
        }
    }


    /**
     *  根据id 删除品牌
     * */
    @RequestMapping("/deleteBrandByIds")  //注意此处传递参数，可能会有问题
    public  Result deleteBrandByIds( long[] ids) {  //这个参数问题,不可以直接使用List 去接收前台传递的id，  其本质还是  request.getParameter("name") 而集合没有name
        try {                                        //方法一：使用数组接收再转化为集合，方法二：使用@RequeatBody List  ids 接收，前台需要使用post方法 方法三：将list封装到对象中
            brandServiceImpl.deleteBrandByIds(ids);
            return  new Result(200,"删除成功");
        }catch (Exception e){
            return  new Result(400,"删除失败");
        }
    }

    /**
     *  待条件的分页查询
     * */
    @RequestMapping("/search")
    public  PageResult search(@RequestBody TbBrand tbBrand,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size) {
        return   brandServiceImpl.findPage(tbBrand, page, size);

    }


}
