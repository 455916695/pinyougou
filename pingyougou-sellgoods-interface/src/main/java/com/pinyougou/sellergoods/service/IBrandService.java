package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

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

}
