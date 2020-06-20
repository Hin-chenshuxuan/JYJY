package com.jyjy.order.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.order.pojo.Complaint;
import com.jyjy.order.service.ComplaintService;
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
@Api(value = "ComplaintController")
@RestController
@RequestMapping("/complaint")
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    /***
     * Complaint分页条件搜索实现
     * @param complaint
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "投诉条件分页查询",notes = "分页条件查询投诉方法详情",tags = {"ComplaintController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Complaint对象",value = "传入JSON数据",required = false) Complaint complaint, @PathVariable  int page, @PathVariable  int size){
        //调用ComplaintService实现分页条件查询Complaint
        PageInfo<Complaint> pageInfo = complaintService.findPage(complaint, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Complaint分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "投诉分页查询",notes = "分页查询投诉方法详情",tags = {"ComplaintController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ComplaintService实现分页查询Complaint
        PageInfo<Complaint> pageInfo = complaintService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Complaint数据
     * @param complaint
     * @return
     */
    @ApiOperation(value = "投诉条件查询",notes = "条件查询投诉方法详情",tags = {"ComplaintController"})
    @PostMapping(value = "/search" )
    public Result<List<Complaint>> findList(@RequestBody(required = false) @ApiParam(name = "Complaint对象",value = "传入JSON数据",required = false) Complaint complaint){
        //调用ComplaintService实现条件查询Complaint
        List<Complaint> list = complaintService.findList(complaint);
        return new Result<List<Complaint>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Complaint数据
     * @param id
     * @return
     */
    @ApiOperation(value = "投诉根据ID删除",notes = "根据ID删除投诉方法详情",tags = {"ComplaintController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping(value = "/delete/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ComplaintService实现根据主键删除
        complaintService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Complaint数据
     * @param complaint
     * @param id
     * @return
     */
    @ApiOperation(value = "投诉根据ID修改",notes = "根据ID修改投诉方法详情",tags = {"ComplaintController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PostMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Complaint对象",value = "传入JSON数据",required = false) Complaint complaint,@PathVariable Integer id){
        //设置主键值
        complaint.setId(id);
        //调用ComplaintService实现修改Complaint
        complaintService.update(complaint);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Complaint数据
     * @param complaint
     * @return
     */
    @ApiOperation(value = "投诉添加",notes = "添加投诉方法详情",tags = {"ComplaintController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Complaint对象",value = "传入JSON数据",required = true) Complaint complaint){
        //调用ComplaintService实现添加Complaint
        complaintService.add(complaint);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Complaint数据
     * @param id
     * @return
     */
    @ApiOperation(value = "投诉根据ID查询",notes = "根据ID查询投诉方法详情",tags = {"ComplaintController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Complaint> findById(@PathVariable Integer id){
        //调用ComplaintService实现根据主键查询Complaint
        Complaint complaint = complaintService.findById(id);
        return new Result<Complaint>(true,StatusCode.OK,"查询成功",complaint);
    }

    /***
     * 查询Complaint全部数据
     * @return
     */
    @ApiOperation(value = "查询所有投诉",notes = "查询所有投诉方法详情",tags = {"ComplaintController"})
    @GetMapping
    public Result<List<Complaint>> findAll(){
        //调用ComplaintService实现查询所有Complaint
        List<Complaint> list = complaintService.findAll();
        return new Result<List<Complaint>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
