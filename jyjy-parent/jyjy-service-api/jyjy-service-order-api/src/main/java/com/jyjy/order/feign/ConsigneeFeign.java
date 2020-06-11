package com.jyjy.order.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Consignee;
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
public interface ConsigneeFeign {

    /***
     * Consignee分页条件搜索实现
     * @param consignee
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/consignee/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Consignee consignee, @PathVariable int page, @PathVariable int size);

    /***
     * Consignee分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/consignee/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param consignee
     * @return
     */
    @PostMapping(value = "/consignee/search" )
    Result<List<Consignee>> findList(@RequestBody(required = false) Consignee consignee);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/consignee/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Consignee数据
     * @param consignee
     * @param id
     * @return
     */
    @PutMapping(value="/consignee/{id}")
    Result update(@RequestBody Consignee consignee, @PathVariable Integer id);

    /***
     * 新增Consignee数据
     * @param consignee
     * @return
     */
    @PostMapping("/consignee")
    Result add(@RequestBody Consignee consignee);

    /***
     * 根据ID查询Consignee数据
     * @param id
     * @return
     */
    @GetMapping("/consignee/{id}")
    Result<Consignee> findById(@PathVariable Integer id);

    /***
     * 查询Consignee全部数据
     * @return
     */
    @GetMapping("/consignee")
    Result<List<Consignee>> findAll();
}