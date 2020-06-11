package com.jyjy.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.user.dao.ShopMapper;
import com.jyjy.user.pojo.Shop;
import com.jyjy.user.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Shop业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    /**
     * Shop条件+分页查询
     * @param shop 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Shop> findPage(Shop shop, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(shop);
        //执行搜索
        return new PageInfo<Shop>(shopMapper.selectByExample(example));
    }

    /**
     * Shop分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Shop> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Shop>(shopMapper.selectAll());
    }

    /**
     * Shop条件查询
     * @param shop
     * @return
     */
    @Override
    public List<Shop> findList(Shop shop){
        //构建查询条件
        Example example = createExample(shop);
        //根据构建的条件查询数据
        return shopMapper.selectByExample(example);
    }


    /**
     * Shop构建查询对象
     * @param shop
     * @return
     */
    public Example createExample(Shop shop){
        Example example=new Example(Shop.class);
        Example.Criteria criteria = example.createCriteria();
        if(shop!=null){
            // 
            if(!StringUtils.isEmpty(shop.getId())){
                    criteria.andEqualTo("id",shop.getId());
            }
            // 
            if(!StringUtils.isEmpty(shop.getName())){
                    criteria.andLike("name","%"+shop.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(shop.getMobile())){
                    criteria.andEqualTo("mobile",shop.getMobile());
            }
            // 
            if(!StringUtils.isEmpty(shop.getShopLevel())){
                    criteria.andEqualTo("shopLevel",shop.getShopLevel());
            }
            // 
            if(!StringUtils.isEmpty(shop.getShopValue())){
                    criteria.andEqualTo("shopValue",shop.getShopValue());
            }
            // 
            if(!StringUtils.isEmpty(shop.getShopScale())){
                    criteria.andEqualTo("shopScale",shop.getShopScale());
            }
            // 
            if(!StringUtils.isEmpty(shop.getShopIncome())){
                    criteria.andEqualTo("shopIncome",shop.getShopIncome());
            }
            // 
            if(!StringUtils.isEmpty(shop.getCreateTime())){
                    criteria.andEqualTo("createTime",shop.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(shop.getUpdateTime())){
                    criteria.andEqualTo("updateTime",shop.getUpdateTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        shopMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Shop
     * @param shop
     */
    @Override
    public void update(Shop shop){
        shop.setUpdateTime(new Date());
        shopMapper.updateByPrimaryKeySelective(shop);
    }

    /**
     * 增加Shop
     * @param shop
     */
    @Override
    public void add(Shop shop){
        if(StringUtils.isEmpty(shop.getShopLevel())){
            shop.setShopLevel("0");
        }
        if(StringUtils.isEmpty(shop.getShopValue())){
            shop.setShopValue(20);
        }
        if(StringUtils.isEmpty(shop.getShopScale())){
            shop.setShopScale("0.20");
        }
        if(StringUtils.isEmpty(shop.getShopIncome())){
            shop.setShopIncome("0");
        }
        shop.setCreateTime(new Date());
        shop.setUpdateTime(new Date());
        shopMapper.insert(shop);
    }

    /**
     * 根据ID查询Shop
     * @param id
     * @return
     */
    @Override
    public Shop findById(Integer id){
        return  shopMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Shop全部数据
     * @return
     */
    @Override
    public List<Shop> findAll() {
        return shopMapper.selectAll();
    }
}
