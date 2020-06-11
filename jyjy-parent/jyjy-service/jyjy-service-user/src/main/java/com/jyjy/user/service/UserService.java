package com.jyjy.user.service;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.User;

import java.util.List;
import java.util.Map;

/****
 * @Author:chenshuxuan
 * @Description:User业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface UserService {

    /**
     * 根据前端传递的code查询openid
     */
    Map<String,String> getOpenid(String code);

    /***
     * User多条件分页查询
     * @param user
     * @param page
     * @param size
     * @return
     */
    PageInfo<User> findPage(User user, int page, int size);

    /***
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<User> findPage(int page, int size);

    /***
     * User多条件搜索方法
     * @param user
     * @return
     */
    List<User> findList(User user);

    /***
     * 删除User
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改User数据
     * @param user
     */
    void update(User user);

    /***
     * 新增User
     * @param user
     */
    void add(User user);

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
     User findById(Integer id);

    /***
     * 查询所有User
     * @return
     */
    List<User> findAll();
}
