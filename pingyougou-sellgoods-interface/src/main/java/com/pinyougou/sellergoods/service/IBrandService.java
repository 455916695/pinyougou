package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.Result;

import java.util.List;
/**
 *  品牌接口
 *
 * */
public interface IBrandService {

    /**
     *  查询所有的品牌
     * */
    public List<TbBrand> findAll();


    /**
     *   查询分页
     *  @param  pageNum  当前页
     *  @param  pageSize  每页显示的记录数
     *  @return
     * */
    public PageResult findPage (int pageNum,int pageSize);


    /**
     *  新增品牌
     *
     * */
    public int addBrand(TbBrand brand);

    /**
     *  根据id  查询品牌对象
     * */
    TbBrand findOne(Long id);

    /**
     *  更新品牌
     * */
    void update(TbBrand tbBrand);

    /**
     *  删除品牌
     * */
    void deleteBrandByIds(long[] ids);

    /**
     *  带条件的分页查询
     * */
    public PageResult findPage (TbBrand tbBrand,int pageNum,int pageSize);

}
