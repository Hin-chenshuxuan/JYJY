package com.jyjy.user.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Xts;
import com.jyjy.user.service.XtsService;
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
@Api(value = "XtsController")
@RestController
@RequestMapping("/xts")
@CrossOrigin
public class XtsController {

    @Autowired
    private XtsService xtsService;

    /***
     * Xts分页条件搜索实现
     * @param xts
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Xts条件分页查询",notes = "分页条件查询Xts方法详情",tags = {"XtsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Xts对象",value = "传入JSON数据",required = false) Xts xts, @PathVariable  int page, @PathVariable  int size){
        //调用XtsService实现分页条件查询Xts
        PageInfo<Xts> pageInfo = xtsService.findPage(xts, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Xts分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Xts分页查询",notes = "分页查询Xts方法详情",tags = {"XtsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用XtsService实现分页查询Xts
        PageInfo<Xts> pageInfo = xtsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Xts数据
     * @param xts
     * @return
     */
    @ApiOperation(value = "Xts条件查询",notes = "条件查询Xts方法详情",tags = {"XtsController"})
    @PostMapping(value = "/search" )
    public Result<List<Xts>> findList(@RequestBody(required = false) @ApiParam(name = "Xts对象",value = "传入JSON数据",required = false) Xts xts){
        //调用XtsService实现条件查询Xts
        List<Xts> list = xtsService.findList(xts);
        return new Result<List<Xts>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Xts数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Xts根据ID删除",notes = "根据ID删除Xts方法详情",tags = {"XtsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping(value = "/delete/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用XtsService实现根据主键删除
        xtsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Xts数据
     * @param xts
     * @param id
     * @return
     */
    @ApiOperation(value = "Xts根据ID修改",notes = "根据ID修改Xts方法详情",tags = {"XtsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PostMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Xts对象",value = "传入JSON数据",required = false) Xts xts,@PathVariable Integer id){
        //设置主键值
        xts.setId(id);
        //调用XtsService实现修改Xts
        xtsService.update(xts);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Xts数据
     * @param xts
     * @return
     */
    @ApiOperation(value = "Xts添加",notes = "添加Xts方法详情",tags = {"XtsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Xts对象",value = "传入JSON数据",required = true) Xts xts){
        //调用XtsService实现添加Xts
        xtsService.add(xts);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Xts数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Xts根据ID查询",notes = "根据ID查询Xts方法详情",tags = {"XtsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Xts> findById(@PathVariable Integer id){
        //调用XtsService实现根据主键查询Xts
        Xts xts = xtsService.findById(id);
        return new Result<Xts>(true,StatusCode.OK,"查询成功",xts);
    }

    /***
     * 查询Xts全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Xts",notes = "查询所有Xts方法详情",tags = {"XtsController"})
    @GetMapping
    public Result<List<Xts>> findAll(){
        //调用XtsService实现查询所有Xts
        List<Xts> list = xtsService.findAll();
        return new Result<List<Xts>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
