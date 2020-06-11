package com.jyjy.user.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Platform;
import com.jyjy.user.service.PlatformService;
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
@Api(value = "PlatformController")
@RestController
@RequestMapping("/platform")
@CrossOrigin
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    /***
     * Platform分页条件搜索实现
     * @param platform
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Platform条件分页查询",notes = "分页条件查询Platform方法详情",tags = {"PlatformController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Platform对象",value = "传入JSON数据",required = false) Platform platform, @PathVariable  int page, @PathVariable  int size){
        //调用PlatformService实现分页条件查询Platform
        PageInfo<Platform> pageInfo = platformService.findPage(platform, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Platform分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Platform分页查询",notes = "分页查询Platform方法详情",tags = {"PlatformController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PlatformService实现分页查询Platform
        PageInfo<Platform> pageInfo = platformService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Platform数据
     * @param platform
     * @return
     */
    @ApiOperation(value = "Platform条件查询",notes = "条件查询Platform方法详情",tags = {"PlatformController"})
    @PostMapping(value = "/search" )
    public Result<List<Platform>> findList(@RequestBody(required = false) @ApiParam(name = "Platform对象",value = "传入JSON数据",required = false) Platform platform){
        //调用PlatformService实现条件查询Platform
        List<Platform> list = platformService.findList(platform);
        return new Result<List<Platform>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Platform数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Platform根据ID删除",notes = "根据ID删除Platform方法详情",tags = {"PlatformController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PlatformService实现根据主键删除
        platformService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Platform数据
     * @param platform
     * @param id
     * @return
     */
    @ApiOperation(value = "Platform根据ID修改",notes = "根据ID修改Platform方法详情",tags = {"PlatformController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Platform对象",value = "传入JSON数据",required = false) Platform platform,@PathVariable Integer id){
        //设置主键值
        platform.setId(id);
        //调用PlatformService实现修改Platform
        platformService.update(platform);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Platform数据
     * @param platform
     * @return
     */
    @ApiOperation(value = "Platform添加",notes = "添加Platform方法详情",tags = {"PlatformController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Platform对象",value = "传入JSON数据",required = true) Platform platform){
        //调用PlatformService实现添加Platform
        platformService.add(platform);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Platform数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Platform根据ID查询",notes = "根据ID查询Platform方法详情",tags = {"PlatformController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Platform> findById(@PathVariable Integer id){
        //调用PlatformService实现根据主键查询Platform
        Platform platform = platformService.findById(id);
        return new Result<Platform>(true,StatusCode.OK,"查询成功",platform);
    }

    /***
     * 查询Platform全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Platform",notes = "查询所有Platform方法详情",tags = {"PlatformController"})
    @GetMapping
    public Result<List<Platform>> findAll(){
        //调用PlatformService实现查询所有Platform
        List<Platform> list = platformService.findAll();
        return new Result<List<Platform>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
