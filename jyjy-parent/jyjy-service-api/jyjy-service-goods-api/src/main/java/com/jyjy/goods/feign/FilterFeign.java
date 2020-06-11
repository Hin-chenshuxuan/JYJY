package com.jyjy.goods.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.goods.pojo.Filter;
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
public interface FilterFeign {

    /***
     * Filter分页条件搜索实现
     * @param filter
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/filter/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Filter filter, @PathVariable int page, @PathVariable int size);

    /***
     * Filter分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/filter/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param filter
     * @return
     */
    @PostMapping(value = "/filter/search" )
    Result<List<Filter>> findList(@RequestBody(required = false) Filter filter);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/filter/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Filter数据
     * @param filter
     * @param id
     * @return
     */
    @PutMapping(value="/filter/{id}")
    Result update(@RequestBody Filter filter, @PathVariable Integer id);

    /***
     * 新增Filter数据
     * @param filter
     * @return
     */
    @PostMapping("/filter")
    Result add(@RequestBody Filter filter);

    /***
     * 根据ID查询Filter数据
     * @param id
     * @return
     */
    @GetMapping("/filter/{id}")
    Result<Filter> findById(@PathVariable Integer id);

    /***
     * 查询Filter全部数据
     * @return
     */
    @GetMapping("/filter")
    Result<List<Filter>> findAll();
}