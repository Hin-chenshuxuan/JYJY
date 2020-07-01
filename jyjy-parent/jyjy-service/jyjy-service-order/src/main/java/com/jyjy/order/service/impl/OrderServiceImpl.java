package com.jyjy.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.goods.feign.FilterFeign;
import com.jyjy.goods.feign.GoodsFeign;
import com.jyjy.goods.pojo.Filter;
import com.jyjy.goods.pojo.Goods;
import com.jyjy.order.dao.OrderMapper;
import com.jyjy.order.pojo.Order;
import com.jyjy.order.service.OrderService;
import com.jyjy.user.feign.PlatformFeign;
import com.jyjy.user.feign.ShopFeign;
import com.jyjy.user.feign.UserFeign;
import com.jyjy.user.feign.XtsFeign;
import com.jyjy.user.pojo.Platform;
import com.jyjy.user.pojo.Shop;
import com.jyjy.user.pojo.User;
import com.jyjy.user.pojo.Xts;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Order业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private XtsFeign xtsFeign;

    @Autowired
    private ShopFeign shopFeign;

    @Autowired
    private PlatformFeign platformFeign;

    @Autowired
    private FilterFeign filterFeign;

    @Autowired
    private GoodsFeign goodsFeign;

    /**
     * 判断用户是否可下载滤镜商品
     */
    @Override
    public Boolean isDownload(Integer userId, Integer filterId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderType("0");
        order.setConnectId(filterId);
        order.setStatus("2"); //订单状态2-已完成
        boolean b = orderMapper.existsWithPrimaryKey(order);
        return b;
    }

    /**
     * Order条件+分页查询
     * @param order 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Order> findPage(Order order, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(order);
        //执行搜索
        List<Order> orders = orderMapper.selectByExample(example);
        for (Order item : orders) {
            getOrderPro(item);
        }
        return new PageInfo<Order>(orders);
    }

    /**
     * Order分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Order> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        List<Order> orders = orderMapper.selectAll();
        for (Order item : orders) {
            getOrderPro(item);
        }
        return new PageInfo<Order>(orders);
    }

    /**
     * Order条件查询
     * @param order
     * @return
     */
    @Override
    public List<Order> findList(Order order){
        //构建查询条件
        Example example = createExample(order);
        //根据构建的条件查询数据
        List<Order> orders = orderMapper.selectByExample(example);
        for (Order item : orders) {
            getOrderPro(item);
        }
        return orders;
    }


    /**
     * Order构建查询对象
     * @param order
     * @return
     */
    public Example createExample(Order order){
        Example example=new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if(order!=null){
            // 
            if(!StringUtils.isEmpty(order.getId())){
                    criteria.andEqualTo("id",order.getId());
            }
            // 
            if(!StringUtils.isEmpty(order.getUserId())){
                    criteria.andEqualTo("userId",order.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(order.getXtsId())){
                    criteria.andEqualTo("xtsId",order.getXtsId());
            }
            //
            if(!StringUtils.isEmpty(order.getJtsId())){
                criteria.andEqualTo("jtsId",order.getJtsId());
            }
            //
            if(!StringUtils.isEmpty(order.getConsigneeId())){
                criteria.andEqualTo("consigneeId",order.getConsigneeId());
            }
            // 
            if(!StringUtils.isEmpty(order.getConnectId())){
                    criteria.andEqualTo("connectId",order.getConnectId());
            }
            // 
            if(!StringUtils.isEmpty(order.getOrderType())){
                    criteria.andEqualTo("orderType",order.getOrderType());
            }
            // 
            if(!StringUtils.isEmpty(order.getSubPrice())){
                    criteria.andEqualTo("subPrice",order.getSubPrice());
            }
            // 
            if(!StringUtils.isEmpty(order.getAddPrice())){
                    criteria.andEqualTo("addPrice",order.getAddPrice());
            }
            // 
            if(!StringUtils.isEmpty(order.getDisPrice())){
                    criteria.andEqualTo("disPrice",order.getDisPrice());
            }
            // 
            if(!StringUtils.isEmpty(order.getTotalPrice())){
                    criteria.andEqualTo("totalPrice",order.getTotalPrice());
            }
            // 
            if(!StringUtils.isEmpty(order.getFilterCommentValue())){
                    criteria.andEqualTo("filterCommentValue",order.getFilterCommentValue());
            }
            // 
            if(!StringUtils.isEmpty(order.getFilterCommentDetail())){
                    criteria.andEqualTo("filterCommentDetail",order.getFilterCommentDetail());
            }
            // 
            if(!StringUtils.isEmpty(order.getXtsCommentValue())){
                    criteria.andEqualTo("xtsCommentValue",order.getXtsCommentValue());
            }
            // 
            if(!StringUtils.isEmpty(order.getXtsCommentDetail())){
                    criteria.andEqualTo("xtsCommentDetail",order.getXtsCommentDetail());
            }
            // 
            if(!StringUtils.isEmpty(order.getJtsCommentValue())){
                    criteria.andEqualTo("jtsCommentValue",order.getJtsCommentValue());
            }
            // 
            if(!StringUtils.isEmpty(order.getJtsCommentDetail())){
                    criteria.andEqualTo("jtsCommentDetail",order.getJtsCommentDetail());
            }
            //
            if(!StringUtils.isEmpty(order.getPayStatus())){
                criteria.andEqualTo("payStatus",order.getPayStatus());
            }
            // 
            if(!StringUtils.isEmpty(order.getStatus())){
                    criteria.andEqualTo("status",order.getStatus());
            }
            //
            if(!StringUtils.isEmpty(order.getIsSettle())){
                criteria.andEqualTo("isSettle",order.getIsSettle());
            }
            //
            if(!StringUtils.isEmpty(order.getIsComplaint())){
                criteria.andEqualTo("isComplaint",order.getIsComplaint());
            }
            // 
            if(!StringUtils.isEmpty(order.getIsDelete())){
                    criteria.andEqualTo("isDelete",order.getIsDelete());
            }
            // 
            if(!StringUtils.isEmpty(order.getCreateTime())){
                    criteria.andEqualTo("createTime",order.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(order.getUpdateTime())){
                    criteria.andEqualTo("updateTime",order.getUpdateTime());
            }
            //
            if(!StringUtils.isEmpty(order.getUserInfo())){
                criteria.andEqualTo("userInfo",order.getUserInfo());
            }
            //
            if(!StringUtils.isEmpty(order.getXtsInfo())){
                criteria.andEqualTo("xtsInfo",order.getXtsInfo());
            }
            //
            if(!StringUtils.isEmpty(order.getJtsInfo())){
                criteria.andEqualTo("jtsInfo",order.getJtsInfo());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Order
     * @param order
     */
    @Override
    public void update(Order order){
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKeySelective(order);
        Order newOrder = findById(order.getId());
        //如果滤镜/修图服务商品ID 订单类型 订单状态 订单结算 为空，则返回
        if(StringUtils.isEmpty(newOrder.getConnectId()) || StringUtils.isEmpty(newOrder.getOrderType()) || StringUtils.isEmpty(newOrder.getStatus()) || StringUtils.isEmpty(newOrder.getIsSettle())){
            return;
        }

        //格式化，取小数点后两位
        DecimalFormat df = new java.text.DecimalFormat("#.00");

        //订单支付成功 订单为滤镜商品订单 且 支付状态为1-支付成功 ，则 订单状态改为1-制作中
        if(newOrder.getOrderType().equals("0") && newOrder.getPayStatus().equals("1") && newOrder.getStatus().equals("0")){
            //修改订单状态
            newOrder.setStatus("2");
            newOrder.setUpdateTime(new Date());
            orderMapper.updateByPrimaryKeySelective(newOrder);
        }

        //订单支付成功 订单为修图服务订单 且 支付状态为1-支付成功 ，则订单状态改为1-制作中
        if(newOrder.getOrderType().equals("1") && newOrder.getPayStatus().equals("1") && newOrder.getStatus().equals("0")){
            //修改订单状态
            newOrder.setStatus("1");
            newOrder.setUpdateTime(new Date());
            orderMapper.updateByPrimaryKeySelective(newOrder);
        }

        //订单为滤镜订单 且 修改订单状态为2-已完成 且 订单收益尚未结算时
        if(newOrder.getOrderType().equals("0") && newOrder.getStatus().equals("2") && newOrder.getIsSettle().equals("0")){
            //订单总收益
            Double totalPrice = Double.valueOf(newOrder.getTotalPrice());
            Double xtsAdd = 0.00;
            Double shopAdd = 0.00;
            //修图师、小店收益计算
            if(!StringUtils.isEmpty(newOrder.getXtsId())){
                //修图师收益计算
                Result<Xts> xts = xtsFeign.findById(newOrder.getXtsId());
                Double xtsScale = Double.valueOf(xts.getData().getXtsScale());
                xtsAdd = totalPrice * xtsScale;
                df.format(xtsAdd);
                Double xtsIncome = Double.valueOf(xts.getData().getXtsIncome()) + xtsAdd;
                //修图师收益更新
                xts.getData().setXtsIncome(xtsIncome.toString());
                xtsFeign.update(xts.getData(),xts.getData().getId());
                //增加滤镜商品已售数目
                Result<Filter> filter = filterFeign.findById(newOrder.getConnectId());
                Integer sold = filter.getData().getSold() + 1;
                //滤镜商品更新
                filter.getData().setSold(sold);
                filterFeign.update(filter.getData(),filter.getData().getId());
                //小店收益计算
                Result<Shop> shop = shopFeign.findById(xts.getData().getShopId());
                Double shopScale = Double.valueOf(shop.getData().getShopScale());
                shopAdd = totalPrice * shopScale;
                df.format(shopAdd);
                Double shopIncome = Double.valueOf(shop.getData().getShopIncome()) +shopAdd;
                //小店收益更新
                shop.getData().setShopIncome(shopIncome.toString());
                shopFeign.update(shop.getData(),shop.getData().getId());
            }
            //平台收益计算
            Result<Platform> platform = platformFeign.findById(1);
            //Double platformScale = Double.valueOf(platform.getData().getPlatformScale());
            Double platformAdd = totalPrice -xtsAdd - shopAdd;
            Double platformIncome = Double.valueOf(platform.getData().getPlatformIncome()) + platformAdd;
            //平台收益更新
            platform.getData().setPlatformIncome(platformIncome.toString());
            platformFeign.update(platform.getData(),platform.getData().getId());

            //修改订单结算状态
            newOrder.setIsSettle("1");
            newOrder.setUpdateTime(new Date());
            orderMapper.updateByPrimaryKeySelective(newOrder);
        }
        //订单为修图服务订单 且 修改订单状态为2-已完成 且 订单收益尚未结算时
        if(newOrder.getOrderType().equals("1") && newOrder.getStatus().equals("2") && newOrder.getIsSettle().equals("0")){
            //订单总收益
            Double totalPrice = Double.valueOf(newOrder.getTotalPrice());
            Double xtsAdd = 0.00;
            Double jtsAdd = 0.00;
            Double shopAdd = 0.00;

            //修图师、小店收益计算
            if(!StringUtils.isEmpty(newOrder.getXtsId())){
                //修图师收益计算
                Result<Xts> xts = xtsFeign.findById(newOrder.getXtsId());
                Double xtsScale = Double.valueOf(xts.getData().getXtsScale());
                xtsAdd = totalPrice * xtsScale;
                System.out.println("修图师佣金比例:" + xtsScale);
                df.format(xtsAdd);
                System.out.println("修图师收益:" + xtsAdd);
                Double xtsIncome = Double.valueOf(xts.getData().getXtsIncome()) + xtsAdd;
                //修图师收益更新
                xts.getData().setXtsIncome(xtsIncome.toString());
                xtsFeign.update(xts.getData(),xts.getData().getId());
                System.out.println("修图师收益更新");
                //小店收益计算
                Result<Shop> shop = shopFeign.findById(xts.getData().getShopId());
                Double shopScale = Double.valueOf(shop.getData().getShopScale());
                shopAdd = totalPrice * shopScale;
                df.format(shopAdd);
                Double shopIncome = Double.valueOf(shop.getData().getShopIncome()) +shopAdd;
                //小店收益更新
                shop.getData().setShopIncome(shopIncome.toString());
                shopFeign.update(shop.getData(),shop.getData().getId());
                System.out.println("小店收益更新");
            }

            //鉴图师收益计算
            if(!StringUtils.isEmpty(newOrder.getXtsId())){
                Result<Xts> jts = xtsFeign.findById(newOrder.getJtsId());
                Double jtsScale = Double.valueOf(jts.getData().getJtsScale());
                jtsAdd = totalPrice * jtsScale;
                df.format(jtsAdd);
                Double jtsIncome = Double.valueOf(jts.getData().getJtsIncome()) + jtsAdd;
                //鉴图师收益更新
                jts.getData().setJtsIncome(jtsIncome.toString());
                xtsFeign.update(jts.getData(),jts.getData().getId());
                System.out.println("鉴图师收益更新");
            }

            //平台收益计算
            Result<Platform> platform = platformFeign.findById(1);
            //Double platformScale = Double.valueOf(platform.getData().getPlatformScale());
            Double platformAdd = totalPrice -xtsAdd -jtsAdd - shopAdd;
            Double platformIncome = Double.valueOf(platform.getData().getPlatformIncome()) + platformAdd;
            //平台收益更新
            platform.getData().setPlatformIncome(platformIncome.toString());
            platformFeign.update(platform.getData(),platform.getData().getId());
            System.out.println("平台收益更新");

            //修改订单结算状态
            newOrder.setIsSettle("1");
            newOrder.setUpdateTime(new Date());
            orderMapper.updateByPrimaryKeySelective(newOrder);
        }

        //订单为滤镜商品订单 且 修改订单状态为3-已评分 且 订单已结算收益尚未结算评分
        if(newOrder.getOrderType().equals("0") && newOrder.getStatus().equals("3") && newOrder.getIsSettle().equals("1")){
            //修图师成长值
            if(!StringUtils.isEmpty(newOrder.getFilterCommentValue())){
                Result<Xts> xts = xtsFeign.findById(newOrder.getXtsId());
                //修图师成长值计算
                Integer xtsValue = xts.getData().getXtsValue() + newOrder.getFilterCommentValue() + 2; //修图师完成一个滤镜商品+2分成长值+订单修图师评分
                //滤镜商品被投诉-5分
                if(newOrder.getIsComplaint().equals("1")){
                    xtsValue = xtsValue - 5;
                }
                //修图师成长值更新
                xts.getData().setXtsValue(xtsValue);
                xtsFeign.update(xts.getData(),xts.getData().getId());
            }
            //修改订单结算状态
            newOrder.setIsSettle("2");
            newOrder.setUpdateTime(new Date());
            orderMapper.updateByPrimaryKeySelective(newOrder);
        }

        //订单为修图服务订单 且 修改订单状态为3-已评分 且 订单已结算收益尚未结算评分
        if(newOrder.getOrderType().equals("1") && newOrder.getStatus().equals("3") && newOrder.getIsSettle().equals("1")){

            //修图师成长值
            if(!StringUtils.isEmpty(newOrder.getXtsCommentValue())){
                Result<Xts> xts = xtsFeign.findById(newOrder.getXtsId());
                //修图师成长值计算
                Integer xtsValue = xts.getData().getXtsValue() + newOrder.getXtsCommentValue() + 5; //修图师完成一个修图商品+5分成长值+订单修图师评分
                //修图服务商品被投诉修图师-10分
                if(newOrder.getIsComplaint().equals("1")){
                    xtsValue = xtsValue - 10;
                }
                //修图师成长值更新
                xts.getData().setXtsValue(xtsValue);
                xtsFeign.update(xts.getData(),xts.getData().getId());
            }

            //鉴图师成长值
            if(!StringUtils.isEmpty(newOrder.getJtsCommentValue())){
                Result<Xts> jts = xtsFeign.findById(newOrder.getJtsId());
                //鉴图师成长值计算
                Integer jtsValue = jts.getData().getXtsValue() + newOrder.getJtsCommentValue() + 2; //鉴图师完成一次鉴图+2分成长值+订单鉴图师评分
                //修图服务商品被投诉鉴图师-2分
                if(newOrder.getIsComplaint().equals("1")){
                    jtsValue = jtsValue - 2;
                }
                //鉴图师成长值更新
                jts.getData().setJtsValue(jtsValue);
                xtsFeign.update(jts.getData(),jts.getData().getId());
            }

            //修改订单结算状态
            newOrder.setIsSettle("2");
            newOrder.setUpdateTime(new Date());
            orderMapper.updateByPrimaryKeySelective(newOrder);
        }
    }

    /**
     * 增加Order
     * @param order
     */
    @Override
    public void add(Order order){
        //滤镜商品
        if(order.getOrderType().equals("0")){
            Result<Filter> filter = filterFeign.findById(order.getConnectId()); //滤镜商品对象
            Double filterPrice = Double.valueOf(filter.getData().getPrice()); //滤镜商品价格
            Double subPrice = filterPrice;
            Double addPrice = 0.00;
            Double disPrice = 0.00;
            Double totalPrice = subPrice + addPrice + disPrice;
            order.setSubPrice(subPrice.toString());
            order.setAddPrice(addPrice.toString());
            order.setDisPrice(disPrice.toString());
            order.setTotalPrice(totalPrice.toString());
        }
        //修图服务商品
        if(order.getOrderType().equals("1")){
            Result<Goods> goods = goodsFeign.findById(order.getConnectId());
            Double goodsPrice = Double.valueOf(goods.getData().getPrice());
            Integer goodsNum = goods.getData().getAmount();
            Double servicePrice = 0.00;
            switch (goods.getData().getUrgentLevel()){
                case "0":
                    servicePrice = 0.00;
                    break;
                case "1":
                    servicePrice = 0.50;
                    break;
                case "2":
                    servicePrice = 2.00;
                    break;
                case "3":
                    servicePrice = 5.00;
                    break;
            }
            Double subPrice = goodsPrice * goodsNum;
            Double addPrice = servicePrice * goodsNum;
            Double disPrice = 0.00;
            Double totalPrice = subPrice + addPrice - disPrice;
            order.setSubPrice(subPrice.toString());
            order.setAddPrice(addPrice.toString());
            order.setDisPrice(disPrice.toString());
            order.setTotalPrice(totalPrice.toString());
            order.setIsSettle("0");
        }
        if(StringUtils.isEmpty(order.getSubPrice())){
            order.setSubPrice("0");
        }
        if(StringUtils.isEmpty(order.getAddPrice())){
            order.setAddPrice("0");
        }
        if(StringUtils.isEmpty(order.getDisPrice())){
            order.setDisPrice("0");
        }
        if(StringUtils.isEmpty(order.getTotalPrice())){
            order.setTotalPrice("0");
        }
        if(StringUtils.isEmpty(order.getPayStatus())){
            order.setPayStatus("0");
        }
        if(StringUtils.isEmpty(order.getStatus())){
            order.setStatus("0");
        }
        if(StringUtils.isEmpty(order.getIsSettle())){
            order.setIsSettle("0");
        }
        if(StringUtils.isEmpty(order.getIsComplaint())){
            order.setIsComplaint("0");
        }
        if(StringUtils.isEmpty(order.getIsDelete())){
            order.setIsDelete("0");
        }
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.insert(order);
    }

    /**
     * 根据ID查询Order
     * @param id
     * @return
     */
    @Override
    public Order findById(Integer id){
        Order order = orderMapper.selectByPrimaryKey(id);
        getOrderPro(order);
        return order;
    }

    /**
     * 查询Order全部数据
     * @return
     */
    @Override
    public List<Order> findAll() {
        List<Order> orders = orderMapper.selectAll();
        for (Order item : orders) {
            getOrderPro(item);
        }
        return orders;
    }

    /**
     * Order查询并添加滤镜/商品、用户、修图师、鉴图师信息
     */
    private void getOrderPro(Order order) {
        if(order.getOrderType().equals("0")&&!StringUtils.isEmpty(order.getConnectId())){
            Result<Filter> filter = filterFeign.findById(order.getConnectId());
            order.setFilter(filter.getData());
        }
        if(order.getOrderType().equals("1")&&!StringUtils.isEmpty(order.getConnectId())){
            Result<Goods> goods = goodsFeign.findById(order.getConnectId());
            order.setGoods(goods.getData());
        }
        if(!StringUtils.isEmpty(order.getUserId())) {
            Result<User> user = userFeign.findById(order.getUserId());
            order.setUserInfo(user.getData());
        }
        if(!StringUtils.isEmpty(order.getXtsId())) {
            Result<Xts> xts = xtsFeign.findById(order.getXtsId());
            order.setXtsInfo(xts.getData());
        }
        if(!StringUtils.isEmpty(order.getJtsId())) {
            Result<Xts> jts = xtsFeign.findById(order.getJtsId());
            order.setJtsInfo(jts.getData());
        }
    }
}
