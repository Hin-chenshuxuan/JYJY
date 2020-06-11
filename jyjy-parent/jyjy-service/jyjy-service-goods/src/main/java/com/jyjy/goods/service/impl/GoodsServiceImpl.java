package com.jyjy.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.goods.dao.GoodsMapper;
import com.jyjy.goods.pojo.Goods;
import com.jyjy.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Goods业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * Goods条件+分页查询
     * @param goods 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Goods> findPage(Goods goods, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goods);
        //执行搜索
        return new PageInfo<Goods>(goodsMapper.selectByExample(example));
    }

    /**
     * Goods分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Goods> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Goods>(goodsMapper.selectAll());
    }

    /**
     * Goods条件查询
     * @param goods
     * @return
     */
    @Override
    public List<Goods> findList(Goods goods){
        //构建查询条件
        Example example = createExample(goods);
        //根据构建的条件查询数据
        return goodsMapper.selectByExample(example);
    }


    /**
     * Goods构建查询对象
     * @param goods
     * @return
     */
    public Example createExample(Goods goods){
        Example example=new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        if(goods!=null){
            // 
            if(!StringUtils.isEmpty(goods.getId())){
                    criteria.andEqualTo("id",goods.getId());
            }
            // 
            if(!StringUtils.isEmpty(goods.getUserId())){
                    criteria.andEqualTo("userId",goods.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(goods.getXtsId())){
                    criteria.andEqualTo("xtsId",goods.getXtsId());
            }
            // 
            if(!StringUtils.isEmpty(goods.getStatus())){
                    criteria.andEqualTo("status",goods.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(goods.getGoodsType())){
                    criteria.andEqualTo("goodsType",goods.getGoodsType());
            }
            // 
            if(!StringUtils.isEmpty(goods.getName())){
                    criteria.andLike("name","%"+goods.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(goods.getDetail())){
                    criteria.andEqualTo("detail",goods.getDetail());
            }
            // 
            if(!StringUtils.isEmpty(goods.getType())){
                    criteria.andEqualTo("type",goods.getType());
            }
            // 
            if(!StringUtils.isEmpty(goods.getLink())){
                    criteria.andEqualTo("link",goods.getLink());
            }
            // 
            if(!StringUtils.isEmpty(goods.getImage())){
                    criteria.andEqualTo("image",goods.getImage());
            }
            // 
            if(!StringUtils.isEmpty(goods.getXtsLevel())){
                    criteria.andEqualTo("xtsLevel",goods.getXtsLevel());
            }
            // 
            if(!StringUtils.isEmpty(goods.getPrice())){
                    criteria.andEqualTo("price",goods.getPrice());
            }
            // 
            if(!StringUtils.isEmpty(goods.getUrgentLevel())){
                    criteria.andEqualTo("urgentLevel",goods.getUrgentLevel());
            }
            // 
            if(!StringUtils.isEmpty(goods.getAmount())){
                    criteria.andEqualTo("amount",goods.getAmount());
            }
            // 
            if(!StringUtils.isEmpty(goods.getMobile())){
                    criteria.andEqualTo("mobile",goods.getMobile());
            }
            // 
            if(!StringUtils.isEmpty(goods.getFile())){
                    criteria.andEqualTo("file",goods.getFile());
            }
            // 
            if(!StringUtils.isEmpty(goods.getIsDelete())){
                    criteria.andEqualTo("isDelete",goods.getIsDelete());
            }
            // 
            if(!StringUtils.isEmpty(goods.getCreateTime())){
                    criteria.andEqualTo("createTime",goods.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(goods.getUpdateTime())){
                    criteria.andEqualTo("updateTime",goods.getUpdateTime());
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
        goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Goods
     * @param goods
     */
    @Override
    public void update(Goods goods){
        goods.setUpdateTime(new Date());
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /**
     * 增加Goods
     * @param goods
     */
    @Override
    public void add(Goods goods){
        if(StringUtils.isEmpty(goods.getXtsLevel())){
            goods.setXtsLevel("0");
        }
        if(StringUtils.isEmpty(goods.getUrgentLevel())){
            goods.setUrgentLevel("0");
        }
        if(StringUtils.isEmpty(goods.getAmount())){
            goods.setAmount(1);
        }
        if(StringUtils.isEmpty(goods.getIsDelete())){
            goods.setIsDelete("0");
        }
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        goodsMapper.insert(goods);
    }

    /**
     * 根据ID查询Goods
     * @param id
     * @return
     */
    @Override
    public Goods findById(Integer id){
        return  goodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Goods全部数据
     * @return
     */
    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectAll();
    }
}
