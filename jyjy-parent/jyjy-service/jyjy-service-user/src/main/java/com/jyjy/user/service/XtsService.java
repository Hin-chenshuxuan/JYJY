package com.jyjy.user.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Xts;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Xts业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface XtsService {

    /***
     * Xts多条件分页查询
     * @param xts
     * @param page
     * @param size
     * @return
     */
    PageInfo<Xts> findPage(Xts xts, int page, int size);

    /***
     * Xts分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Xts> findPage(int page, int size);

    /***
     * Xts多条件搜索方法
     * @param xts
     * @return
     */
    List<Xts> findList(Xts xts);

    /***
     * 删除Xts
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Xts数据
     * @param xts
     */
    void update(Xts xts);

    /***
     * 新增Xts
     * @param xts
     */
    void add(Xts xts);

    /**
     * 根据ID查询Xts
     * @param id
     * @return
     */
     Xts findById(Integer id);

    /***
     * 查询所有Xts
     * @return
     */
    List<Xts> findAll();
}
