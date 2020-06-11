package com.jyjy.goods.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.goods.pojo.Filter;
import com.jyjy.goods.service.FilterService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "FilterController")
@RestController
@RequestMapping("/filter")
@CrossOrigin
public class FilterController {

    @Autowired
    private FilterService filterService;
    /**
     * 滤镜商品点赞
     */
    @ApiOperation(value = "滤镜商品点赞",notes = "根据ID修改滤镜方法详情",tags = {"FilterController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "type", value = "0-点赞 1-取消", required = true, dataType = "String")
    })
    @PutMapping(value="/{id}/{type}")
    public Result<Filter> love(@PathVariable Integer id,@PathVariable String type){
        Filter filter = filterService.love(id, type);
        return new Result<Filter>(true,StatusCode.OK,"修改成功",filter);
    }

    /***
     * Filter分页条件搜索实现
     * @param filter
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "滤镜条件分页查询",notes = "分页条件查询滤镜方法详情",tags = {"FilterController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Filter对象",value = "传入JSON数据",required = false) Filter filter, @PathVariable  int page, @PathVariable  int size){
        //调用FilterService实现分页条件查询Filter
        PageInfo<Filter> pageInfo = filterService.findPage(filter, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Filter分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "滤镜分页查询",notes = "分页查询滤镜方法详情",tags = {"FilterController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FilterService实现分页查询Filter
        PageInfo<Filter> pageInfo = filterService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Filter数据
     * @param filter
     * @return
     */
    @ApiOperation(value = "滤镜条件查询",notes = "条件查询滤镜方法详情",tags = {"FilterController"})
    @PostMapping(value = "/search" )
    public Result<List<Filter>> findList(@RequestBody(required = false) @ApiParam(name = "Filter对象",value = "传入JSON数据",required = false) Filter filter){
        //调用FilterService实现条件查询Filter
        List<Filter> list = filterService.findList(filter);
        return new Result<List<Filter>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Filter数据
     * @param id
     * @return
     */
    @ApiOperation(value = "滤镜根据ID删除",notes = "根据ID删除滤镜方法详情",tags = {"FilterController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用FilterService实现根据主键删除
        filterService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Filter数据
     * @param filter
     * @param id
     * @return
     */
    @ApiOperation(value = "滤镜根据ID修改",notes = "根据ID修改滤镜方法详情",tags = {"FilterController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Filter对象",value = "传入JSON数据",required = false) Filter filter,@PathVariable Integer id){
        //设置主键值
        filter.setId(id);
        //调用FilterService实现修改Filter
        filterService.update(filter);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Filter数据
     * @param filter
     * @return
     */
    @ApiOperation(value = "滤镜添加",notes = "添加滤镜方法详情",tags = {"FilterController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Filter对象",value = "传入JSON数据",required = true) Filter filter){
        //调用FilterService实现添加Filter
        filterService.add(filter);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Filter数据
     * @param id
     * @return
     */
    @ApiOperation(value = "滤镜根据ID查询",notes = "根据ID查询滤镜方法详情",tags = {"FilterController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Filter> findById(@PathVariable Integer id){
        //调用FilterService实现根据主键查询Filter
        Filter filter = filterService.findById(id);
        return new Result<Filter>(true,StatusCode.OK,"查询成功",filter);
    }

    /***
     * 查询Filter全部数据
     * @return
     */
    @ApiOperation(value = "查询所有滤镜",notes = "查询所有滤镜方法详情",tags = {"FilterController"})
    @GetMapping
    public Result<List<Filter>> findAll(){
        //调用FilterService实现查询所有Filter
        List<Filter> list = filterService.findAll();
        return new Result<List<Filter>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
