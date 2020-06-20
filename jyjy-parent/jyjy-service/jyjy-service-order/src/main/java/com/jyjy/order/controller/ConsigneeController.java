package com.jyjy.order.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Consignee;
import com.jyjy.order.service.ConsigneeService;
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
@Api(value = "ConsigneeController")
@RestController
@RequestMapping("/consignee")
@CrossOrigin
public class ConsigneeController {

    @Autowired
    private ConsigneeService consigneeService;

    /***
     * Consignee分页条件搜索实现
     * @param consignee
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "收货人信息条件分页查询",notes = "分页条件查询收货人信息方法详情",tags = {"ConsigneeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Consignee对象",value = "传入JSON数据",required = false) Consignee consignee, @PathVariable  int page, @PathVariable  int size){
        //调用ConsigneeService实现分页条件查询Consignee
        PageInfo<Consignee> pageInfo = consigneeService.findPage(consignee, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Consignee分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "收货人信息分页查询",notes = "分页查询收货人信息方法详情",tags = {"ConsigneeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ConsigneeService实现分页查询Consignee
        PageInfo<Consignee> pageInfo = consigneeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Consignee数据
     * @param consignee
     * @return
     */
    @ApiOperation(value = "收货人信息条件查询",notes = "条件查询收货人信息方法详情",tags = {"ConsigneeController"})
    @PostMapping(value = "/search" )
    public Result<List<Consignee>> findList(@RequestBody(required = false) @ApiParam(name = "Consignee对象",value = "传入JSON数据",required = false) Consignee consignee){
        //调用ConsigneeService实现条件查询Consignee
        List<Consignee> list = consigneeService.findList(consignee);
        return new Result<List<Consignee>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Consignee数据
     * @param id
     * @return
     */
    @ApiOperation(value = "收货人信息根据ID删除",notes = "根据ID删除收货人信息方法详情",tags = {"ConsigneeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping(value = "/delete/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ConsigneeService实现根据主键删除
        consigneeService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Consignee数据
     * @param consignee
     * @param id
     * @return
     */
    @ApiOperation(value = "收货人信息根据ID修改",notes = "根据ID修改收货人信息方法详情",tags = {"ConsigneeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PostMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Consignee对象",value = "传入JSON数据",required = false) Consignee consignee,@PathVariable Integer id){
        //设置主键值
        consignee.setId(id);
        //调用ConsigneeService实现修改Consignee
        consigneeService.update(consignee);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Consignee数据
     * @param consignee
     * @return
     */
    @ApiOperation(value = "收货人信息添加",notes = "添加收货人信息方法详情",tags = {"ConsigneeController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Consignee对象",value = "传入JSON数据",required = true) Consignee consignee){
        //调用ConsigneeService实现添加Consignee
        consigneeService.add(consignee);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Consignee数据
     * @param id
     * @return
     */
    @ApiOperation(value = "收货人信息根据ID查询",notes = "根据ID查询收货人信息方法详情",tags = {"ConsigneeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Consignee> findById(@PathVariable Integer id){
        //调用ConsigneeService实现根据主键查询Consignee
        Consignee consignee = consigneeService.findById(id);
        return new Result<Consignee>(true,StatusCode.OK,"查询成功",consignee);
    }

    /***
     * 查询Consignee全部数据
     * @return
     */
    @ApiOperation(value = "查询所有收货人信息",notes = "查询所有收货人信息方法详情",tags = {"ConsigneeController"})
    @GetMapping
    public Result<List<Consignee>> findAll(){
        //调用ConsigneeService实现查询所有Consignee
        List<Consignee> list = consigneeService.findAll();
        return new Result<List<Consignee>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
