package com.jyjy.goods.controller;

import com.github.pagehelper.PageInfo;
import com.jyjy.goods.pojo.Goods;
import com.jyjy.goods.service.GoodsService;
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
@Api(value = "GoodsController")
@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /***
     * Goods分页条件搜索实现
     * @param goods
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "修图服务商品条件分页查询",notes = "分页条件查询修图服务商品方法详情",tags = {"GoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Goods对象",value = "传入JSON数据",required = false) Goods goods, @PathVariable  int page, @PathVariable  int size){
        //调用GoodsService实现分页条件查询Goods
        PageInfo<Goods> pageInfo = goodsService.findPage(goods, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Goods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "修图服务商品分页查询",notes = "分页查询修图服务商品方法详情",tags = {"GoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodsService实现分页查询Goods
        PageInfo<Goods> pageInfo = goodsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Goods数据
     * @param goods
     * @return
     */
    @ApiOperation(value = "修图服务商品条件查询",notes = "条件查询修图服务商品方法详情",tags = {"GoodsController"})
    @PostMapping(value = "/search" )
    public Result<List<Goods>> findList(@RequestBody(required = false) @ApiParam(name = "Goods对象",value = "传入JSON数据",required = false) Goods goods){
        //调用GoodsService实现条件查询Goods
        List<Goods> list = goodsService.findList(goods);
        return new Result<List<Goods>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Goods数据
     * @param id
     * @return
     */
    @ApiOperation(value = "修图服务商品根据ID删除",notes = "根据ID删除修图服务商品方法详情",tags = {"GoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping(value = "/delete/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用GoodsService实现根据主键删除
        goodsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Goods数据
     * @param goods
     * @param id
     * @return
     */
    @ApiOperation(value = "修图服务商品根据ID修改",notes = "根据ID修改修图服务商品方法详情",tags = {"GoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PostMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Goods对象",value = "传入JSON数据",required = false) Goods goods,@PathVariable Integer id){
        //设置主键值
        goods.setId(id);
        //调用GoodsService实现修改Goods
        goodsService.update(goods);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Goods数据
     * @param goods
     * @return
     */
    @ApiOperation(value = "修图服务商品添加",notes = "添加修图服务商品方法详情",tags = {"GoodsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Goods对象",value = "传入JSON数据",required = true) Goods goods){
        //调用GoodsService实现添加Goods
        goodsService.add(goods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Goods数据
     * @param id
     * @return
     */
    @ApiOperation(value = "修图服务商品根据ID查询",notes = "根据ID查询修图服务商品方法详情",tags = {"GoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Goods> findById(@PathVariable Integer id){
        //调用GoodsService实现根据主键查询Goods
        Goods goods = goodsService.findById(id);
        return new Result<Goods>(true,StatusCode.OK,"查询成功",goods);
    }

    /***
     * 查询Goods全部数据
     * @return
     */
    @ApiOperation(value = "查询所有修图服务商品",notes = "查询所有修图服务商品方法详情",tags = {"GoodsController"})
    @GetMapping
    public Result<List<Goods>> findAll(){
        //调用GoodsService实现查询所有Goods
        List<Goods> list = goodsService.findAll();
        return new Result<List<Goods>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
