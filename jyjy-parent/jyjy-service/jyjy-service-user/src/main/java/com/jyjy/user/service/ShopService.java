package com.jyjy.user.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Shop;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Shop业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ShopService {

    /***
     * Shop多条件分页查询
     * @param shop
     * @param page
     * @param size
     * @return
     */
    PageInfo<Shop> findPage(Shop shop, int page, int size);

    /***
     * Shop分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Shop> findPage(int page, int size);

    /***
     * Shop多条件搜索方法
     * @param shop
     * @return
     */
    List<Shop> findList(Shop shop);

    /***
     * 删除Shop
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Shop数据
     * @param shop
     */
    void update(Shop shop);

    /***
     * 新增Shop
     * @param shop
     */
    void add(Shop shop);

    /**
     * 根据ID查询Shop
     * @param id
     * @return
     */
     Shop findById(Integer id);

    /***
     * 查询所有Shop
     * @return
     */
    List<Shop> findAll();
}
