package com.jyjy.order.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Order;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Order业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OrderService {

    /**
     * 判断用户是否可下载滤镜商品
     */
    Boolean isDownload(Integer userId,Integer filterId);

    /***
     * Order多条件分页查询
     * @param order
     * @param page
     * @param size
     * @return
     */
    PageInfo<Order> findPage(Order order, int page, int size);

    /***
     * Order分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Order> findPage(int page, int size);

    /***
     * Order多条件搜索方法
     * @param order
     * @return
     */
    List<Order> findList(Order order);

    /***
     * 删除Order
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Order数据
     * @param order
     */
    void update(Order order);

    /***
     * 新增Order
     * @param order
     */
    void add(Order order);

    /**
     * 根据ID查询Order
     * @param id
     * @return
     */
    Order findById(Integer id);

    /***
     * 查询所有Order
     * @return
     */
    List<Order> findAll();
}
