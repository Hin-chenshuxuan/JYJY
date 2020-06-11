package com.jyjy.order.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Complaint;
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
public interface ComplaintFeign {

    /***
     * Complaint分页条件搜索实现
     * @param complaint
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/complaint/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Complaint complaint, @PathVariable int page, @PathVariable int size);

    /***
     * Complaint分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/complaint/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param complaint
     * @return
     */
    @PostMapping(value = "/complaint/search" )
    Result<List<Complaint>> findList(@RequestBody(required = false) Complaint complaint);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/complaint/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Complaint数据
     * @param complaint
     * @param id
     * @return
     */
    @PutMapping(value="/complaint/{id}")
    Result update(@RequestBody Complaint complaint, @PathVariable Integer id);

    /***
     * 新增Complaint数据
     * @param complaint
     * @return
     */
    @PostMapping("/complaint")
    Result add(@RequestBody Complaint complaint);

    /***
     * 根据ID查询Complaint数据
     * @param id
     * @return
     */
    @GetMapping("/complaint/{id}")
    Result<Complaint> findById(@PathVariable Integer id);

    /***
     * 查询Complaint全部数据
     * @return
     */
    @GetMapping("/complaint")
    Result<List<Complaint>> findAll();
}