package com.jyjy.user.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Platform;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Platform业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PlatformService {

    /***
     * Platform多条件分页查询
     * @param platform
     * @param page
     * @param size
     * @return
     */
    PageInfo<Platform> findPage(Platform platform, int page, int size);

    /***
     * Platform分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Platform> findPage(int page, int size);

    /***
     * Platform多条件搜索方法
     * @param platform
     * @return
     */
    List<Platform> findList(Platform platform);

    /***
     * 删除Platform
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Platform数据
     * @param platform
     */
    void update(Platform platform);

    /***
     * 新增Platform
     * @param platform
     */
    void add(Platform platform);

    /**
     * 根据ID查询Platform
     * @param id
     * @return
     */
     Platform findById(Integer id);

    /***
     * 查询所有Platform
     * @return
     */
    List<Platform> findAll();
}
