package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.IBrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;
    /**
     *  查询所有的 Brand
     * */
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {  //个人觉得此处需要加上判断

        if(pageNum <0 || pageSize <=0) {  //防止非法数据
            return  null;
        }
        PageHelper.startPage(pageNum,pageSize);  //使用 PageHelper  设置查询 的当前页面与每页显示的记录数

        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null); // 查询数据，并转换为 page  类型

        return new PageResult(page.getTotal(),page.getResult(),pageNum,pageSize);
    }

    /**
     *  添加品牌
     * */
    public int addBrand(TbBrand brand) {
        return tbBrandMapper.insert(brand);
    }

    /**
     *  根据Id 查询数据
     * */
    public TbBrand findOne(Long id) {
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);

        return tbBrand;
    }

    /**
     *  更新数据
     * */
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

     /**
      * 删除品牌
      * */
    public void deleteBrandByIds(long[] ids) {

        List<Long>  idList = new ArrayList<>();
        for (Long id : ids) {
             idList.add(id);
        }
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria().andIdIn(idList);  // 根据条件删除指定品牌
        tbBrandMapper.deleteByExample(tbBrandExample);
    }

    /**
     *  带条件的分页查询
     * */
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);  //使用 PageHelper  设置查询 的当前页面与每页显示的记录数

        TbBrandExample tbBrandExample = new TbBrandExample();
        if(tbBrand != null) {
            TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
            if(!StringUtils.isEmpty(tbBrand.getName())) {
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if(!StringUtils.isEmpty(tbBrand.getFirstChar())){
                criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(tbBrandExample); // 查询数据，并转换为 page  类型

        return new PageResult(page.getTotal(),page.getResult(),pageNum,pageSize);

    }
}
