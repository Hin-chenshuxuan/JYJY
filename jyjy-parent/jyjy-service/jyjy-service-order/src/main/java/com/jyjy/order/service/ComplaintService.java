package com.jyjy.order.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Complaint;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Complaint业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ComplaintService {

    /***
     * Complaint多条件分页查询
     * @param complaint
     * @param page
     * @param size
     * @return
     */
    PageInfo<Complaint> findPage(Complaint complaint, int page, int size);

    /***
     * Complaint分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Complaint> findPage(int page, int size);

    /***
     * Complaint多条件搜索方法
     * @param complaint
     * @return
     */
    List<Complaint> findList(Complaint complaint);

    /***
     * 删除Complaint
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Complaint数据
     * @param complaint
     */
    void update(Complaint complaint);

    /***
     * 新增Complaint
     * @param complaint
     */
    void add(Complaint complaint);

    /**
     * 根据ID查询Complaint
     * @param id
     * @return
     */
     Complaint findById(Integer id);

    /***
     * 查询所有Complaint
     * @return
     */
    List<Complaint> findAll();
}
