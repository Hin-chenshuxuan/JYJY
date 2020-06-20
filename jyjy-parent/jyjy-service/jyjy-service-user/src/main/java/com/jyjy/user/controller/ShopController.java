package com.jyjy.user.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.user.pojo.Shop;
import com.jyjy.user.service.ShopService;
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
@Api(value = "ShopController")
@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @Autowired
    private ShopService shopService;

    /***
     * Shop分页条件搜索实现
     * @param shop
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Shop条件分页查询",notes = "分页条件查询Shop方法详情",tags = {"ShopController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Shop对象",value = "传入JSON数据",required = false) Shop shop, @PathVariable  int page, @PathVariable  int size){
        //调用ShopService实现分页条件查询Shop
        PageInfo<Shop> pageInfo = shopService.findPage(shop, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Shop分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Shop分页查询",notes = "分页查询Shop方法详情",tags = {"ShopController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ShopService实现分页查询Shop
        PageInfo<Shop> pageInfo = shopService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Shop数据
     * @param shop
     * @return
     */
    @ApiOperation(value = "Shop条件查询",notes = "条件查询Shop方法详情",tags = {"ShopController"})
    @PostMapping(value = "/search" )
    public Result<List<Shop>> findList(@RequestBody(required = false) @ApiParam(name = "Shop对象",value = "传入JSON数据",required = false) Shop shop){
        //调用ShopService实现条件查询Shop
        List<Shop> list = shopService.findList(shop);
        return new Result<List<Shop>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Shop数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Shop根据ID删除",notes = "根据ID删除Shop方法详情",tags = {"ShopController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping(value = "/delete/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ShopService实现根据主键删除
        shopService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Shop数据
     * @param shop
     * @param id
     * @return
     */
    @ApiOperation(value = "Shop根据ID修改",notes = "根据ID修改Shop方法详情",tags = {"ShopController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PostMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Shop对象",value = "传入JSON数据",required = false) Shop shop,@PathVariable Integer id){
        //设置主键值
        shop.setId(id);
        //调用ShopService实现修改Shop
        shopService.update(shop);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Shop数据
     * @param shop
     * @return
     */
    @ApiOperation(value = "Shop添加",notes = "添加Shop方法详情",tags = {"ShopController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Shop对象",value = "传入JSON数据",required = true) Shop shop){
        //调用ShopService实现添加Shop
        shopService.add(shop);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Shop数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Shop根据ID查询",notes = "根据ID查询Shop方法详情",tags = {"ShopController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Shop> findById(@PathVariable Integer id){
        //调用ShopService实现根据主键查询Shop
        Shop shop = shopService.findById(id);
        return new Result<Shop>(true,StatusCode.OK,"查询成功",shop);
    }

    /***
     * 查询Shop全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Shop",notes = "查询所有Shop方法详情",tags = {"ShopController"})
    @GetMapping
    public Result<List<Shop>> findAll(){
        //调用ShopService实现查询所有Shop
        List<Shop> list = shopService.findAll();
        return new Result<List<Shop>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
