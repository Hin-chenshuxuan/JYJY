package com.jyjy.order.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Consignee;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Consignee业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ConsigneeService {

    /***
     * Consignee多条件分页查询
     * @param consignee
     * @param page
     * @param size
     * @return
     */
    PageInfo<Consignee> findPage(Consignee consignee, int page, int size);

    /***
     * Consignee分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Consignee> findPage(int page, int size);

    /***
     * Consignee多条件搜索方法
     * @param consignee
     * @return
     */
    List<Consignee> findList(Consignee consignee);

    /***
     * 删除Consignee
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Consignee数据
     * @param consignee
     */
    void update(Consignee consignee);

    /***
     * 新增Consignee
     * @param consignee
     */
    void add(Consignee consignee);

    /**
     * 根据ID查询Consignee
     * @param id
     * @return
     */
     Consignee findById(Integer id);

    /***
     * 查询所有Consignee
     * @return
     */
    List<Consignee> findAll();
}
