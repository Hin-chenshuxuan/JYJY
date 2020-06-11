package com.jyjy.user.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Xts;
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
public interface XtsFeign {

    /***
     * Xts分页条件搜索实现
     * @param xts
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/xts/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Xts xts, @PathVariable int page, @PathVariable int size);

    /***
     * Xts分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/xts/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param xts
     * @return
     */
    @PostMapping(value = "/xts/search" )
    Result<List<Xts>> findList(@RequestBody(required = false) Xts xts);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/xts/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Xts数据
     * @param xts
     * @param id
     * @return
     */
    @PutMapping(value="/xts/{id}")
    Result update(@RequestBody Xts xts, @PathVariable Integer id);

    /***
     * 新增Xts数据
     * @param xts
     * @return
     */
    @PostMapping("/xts")
    Result add(@RequestBody Xts xts);

    /***
     * 根据ID查询Xts数据
     * @param id
     * @return
     */
    @GetMapping("/xts/{id}")
    Result<Xts> findById(@PathVariable Integer id);

    /***
     * 查询Xts全部数据
     * @return
     */
    @GetMapping("/xts")
    Result<List<Xts>> findAll();
}