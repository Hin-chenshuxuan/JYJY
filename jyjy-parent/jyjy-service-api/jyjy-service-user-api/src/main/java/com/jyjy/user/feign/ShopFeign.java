package com.jyjy.user.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Shop;
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
public interface ShopFeign {

    /***
     * Shop分页条件搜索实现
     * @param shop
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/shop/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Shop shop, @PathVariable int page, @PathVariable int size);

    /***
     * Shop分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/shop/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param shop
     * @return
     */
    @PostMapping(value = "/shop/search" )
    Result<List<Shop>> findList(@RequestBody(required = false) Shop shop);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/shop/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Shop数据
     * @param shop
     * @param id
     * @return
     */
    @PutMapping(value="/shop/{id}")
    Result update(@RequestBody Shop shop, @PathVariable Integer id);

    /***
     * 新增Shop数据
     * @param shop
     * @return
     */
    @PostMapping("/shop")
    Result add(@RequestBody Shop shop);

    /***
     * 根据ID查询Shop数据
     * @param id
     * @return
     */
    @GetMapping("/shop/{id}")
    Result<Shop> findById(@PathVariable Integer id);

    /***
     * 查询Shop全部数据
     * @return
     */
    @GetMapping("/shop")
    Result<List<Shop>> findAll();
}