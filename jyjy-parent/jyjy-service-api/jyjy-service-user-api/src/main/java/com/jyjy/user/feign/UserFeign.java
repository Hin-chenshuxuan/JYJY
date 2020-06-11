package com.jyjy.user.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.User;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
public interface UserFeign {

    /***
     * User分页条件搜索实现
     * @param user
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/user/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) User user, @PathVariable int page, @PathVariable int size);

    /***
     * User分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/user/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param user
     * @return
     */
    @PostMapping(value = "/user/search" )
    Result<List<User>> findList(@RequestBody(required = false) User user);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/user/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改User数据
     * @param user
     * @param id
     * @return
     */
    @PutMapping(value="/user/{id}")
    Result update(@RequestBody User user, @PathVariable Integer id);

    /***
     * 新增User数据
     * @param user
     * @return
     */
    @PostMapping("/user")
    Result add(@RequestBody User user);

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    Result<User> findById(@PathVariable Integer id);

    /***
     * 查询User全部数据
     * @return
     */
    @GetMapping("/user")
    Result<List<User>> findAll();
}