package com.jyjy.goods.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.goods.pojo.Goods;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="goods")
public interface GoodsFeign {

    /***
     * Goods分页条件搜索实现
     * @param goods
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/goods/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Goods goods, @PathVariable int page, @PathVariable int size);

    /***
     * Goods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/goods/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goods
     * @return
     */
    @PostMapping(value = "/goods/search" )
    Result<List<Goods>> findList(@RequestBody(required = false) Goods goods);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/goods/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Goods数据
     * @param goods
     * @param id
     * @return
     */
    @PutMapping(value="/goods/{id}")
    Result update(@RequestBody Goods goods, @PathVariable Integer id);

    /***
     * 新增Goods数据
     * @param goods
     * @return
     */
    @PostMapping("/goods")
    Result add(@RequestBody Goods goods);

    /***
     * 根据ID查询Goods数据
     * @param id
     * @return
     */
    @GetMapping("/goods/{id}")
    Result<Goods> findById(@PathVariable Integer id);

    /***
     * 查询Goods全部数据
     * @return
     */
    @GetMapping("/goods")
    Result<List<Goods>> findAll();
}