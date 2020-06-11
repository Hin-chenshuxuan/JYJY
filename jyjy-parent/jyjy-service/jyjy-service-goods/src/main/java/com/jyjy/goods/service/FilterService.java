package com.jyjy.goods.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.goods.pojo.Filter;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Filter业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FilterService {

    /**
     * 点赞
     */
    Filter love(Integer id,String type);

    /***
     * Filter多条件分页查询
     * @param filter
     * @param page
     * @param size
     * @return
     */
    PageInfo<Filter> findPage(Filter filter, int page, int size);

    /***
     * Filter分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Filter> findPage(int page, int size);

    /***
     * Filter多条件搜索方法
     * @param filter
     * @return
     */
    List<Filter> findList(Filter filter);

    /***
     * 删除Filter
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Filter数据
     * @param filter
     */
    void update(Filter filter);

    /***
     * 新增Filter
     * @param filter
     */
    void add(Filter filter);

    /**
     * 根据ID查询Filter
     * @param id
     * @return
     */
     Filter findById(Integer id);

    /***
     * 查询所有Filter
     * @return
     */
    List<Filter> findAll();
}
