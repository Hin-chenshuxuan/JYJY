package com.jyjy.order.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Order;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="order")
public interface OrderFeign {

    /***
     * Order分页条件搜索实现
     * @param order
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/order/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Order order, @PathVariable int page, @PathVariable int size);

    /***
     * Order分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/order/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param order
     * @return
     */
    @PostMapping(value = "/order/search" )
    Result<List<Order>> findList(@RequestBody(required = false) Order order);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/order/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Order数据
     * @param order
     * @param id
     * @return
     */
    @PutMapping(value="/order/{id}")
    Result update(@RequestBody Order order, @PathVariable Integer id);

    /***
     * 新增Order数据
     * @param order
     * @return
     */
    @PostMapping("/order")
    Result add(@RequestBody Order order);

    /***
     * 根据ID查询Order数据
     * @param id
     * @return
     */
    @GetMapping("/order/{id}")
    Result<Order> findById(@PathVariable Integer id);

    /***
     * 查询Order全部数据
     * @return
     */
    @GetMapping("/order")
    Result<List<Order>> findAll();
}