package com.jyjy.user.feign;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Platform;
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
public interface PlatformFeign {

    /***
     * Platform分页条件搜索实现
     * @param platform
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/platform/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Platform platform, @PathVariable int page, @PathVariable int size);

    /***
     * Platform分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/platform/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param platform
     * @return
     */
    @PostMapping(value = "/platform/search" )
    Result<List<Platform>> findList(@RequestBody(required = false) Platform platform);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/platform/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Platform数据
     * @param platform
     * @param id
     * @return
     */
    @PutMapping(value="/platform/{id}")
    Result update(@RequestBody Platform platform, @PathVariable Integer id);

    /***
     * 新增Platform数据
     * @param platform
     * @return
     */
    @PostMapping("/platform")
    Result add(@RequestBody Platform platform);

    /***
     * 根据ID查询Platform数据
     * @param id
     * @return
     */
    @GetMapping("/platform/{id}")
    Result<Platform> findById(@PathVariable Integer id);

    /***
     * 查询Platform全部数据
     * @return
     */
    @GetMapping("/platform")
    Result<List<Platform>> findAll();
}