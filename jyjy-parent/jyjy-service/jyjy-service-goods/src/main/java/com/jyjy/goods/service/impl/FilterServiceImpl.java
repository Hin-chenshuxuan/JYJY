package com.jyjy.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.goods.dao.FilterMapper;
import com.jyjy.goods.pojo.Filter;
import com.jyjy.goods.service.FilterService;
import com.jyjy.user.feign.XtsFeign;
import com.jyjy.user.pojo.Xts;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Filter业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterMapper filterMapper;

    @Autowired
    private XtsFeign xtsFeign;

    /**
     * 点赞
     */
    @Override
    public Filter love(Integer id, String type) {
        Filter filter = filterMapper.selectByPrimaryKey(id);
        if(type.equals("0")){
            filter.setLove(filter.getLove() + 1);
        }
        if(type.equals("1") && filter.getLove() > 0){
            filter.setLove(filter.getLove() - 1);
        }
        filterMapper.updateByPrimaryKeySelective(filter);
        return filter;
    }

    /**
     * Filter条件+分页查询
     * @param filter 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Filter> findPage(Filter filter, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(filter);
        //执行搜索
        return new PageInfo<Filter>(filterMapper.selectByExample(example));
    }

    /**
     * Filter分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Filter> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Filter>(filterMapper.selectAll());
    }

    /**
     * Filter条件查询
     * @param filter
     * @return
     */
    @Override
    public List<Filter> findList(Filter filter){
        //构建查询条件
        Example example = createExample(filter);
        //根据构建的条件查询数据
        return filterMapper.selectByExample(example);
    }


    /**
     * Filter构建查询对象
     * @param filter
     * @return
     */
    public Example createExample(Filter filter){
        Example example=new Example(Filter.class);
        Example.Criteria criteria = example.createCriteria();
        if(filter!=null){
            // 
            if(!StringUtils.isEmpty(filter.getId())){
                    criteria.andEqualTo("id",filter.getId());
            }
            // 
            if(!StringUtils.isEmpty(filter.getXtsId())){
                    criteria.andEqualTo("xtsId",filter.getXtsId());
            }
            // 
            if(!StringUtils.isEmpty(filter.getStatus())){
                    criteria.andEqualTo("status",filter.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(filter.getName())){
                    criteria.andLike("name","%"+filter.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(filter.getImage())){
                    criteria.andEqualTo("image",filter.getImage());
            }
            // 
            if(!StringUtils.isEmpty(filter.getTag())){
                    criteria.andEqualTo("tag",filter.getTag());
            }
            // 
            if(!StringUtils.isEmpty(filter.getPrice())){
                    criteria.andEqualTo("price",filter.getPrice());
            }
            // 
            if(!StringUtils.isEmpty(filter.getLove())){
                    criteria.andEqualTo("love",filter.getLove());
            }
            // 
            if(!StringUtils.isEmpty(filter.getSold())){
                    criteria.andEqualTo("sold",filter.getSold());
            }
            // 
            if(!StringUtils.isEmpty(filter.getFile())){
                    criteria.andEqualTo("file",filter.getFile());
            }
            // 
            if(!StringUtils.isEmpty(filter.getIsDelete())){
                    criteria.andEqualTo("isDelete",filter.getIsDelete());
            }
            // 
            if(!StringUtils.isEmpty(filter.getCreateTime())){
                    criteria.andEqualTo("createTime",filter.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(filter.getUpdateTime())){
                    criteria.andEqualTo("updateTime",filter.getUpdateTime());
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
        filterMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Filter
     * @param filter
     */
    @Override
    public void update(Filter filter){
        filter.setUpdateTime(new Date());
        filterMapper.updateByPrimaryKeySelective(filter);
    }

    /**
     * 增加Filter
     * @param filter
     */
    @Override
    public void add(Filter filter){
        //修图发布一个滤镜商品+1分成长值
        if(!StringUtils.isEmpty(filter.getXtsId())){
            Result<Xts> xts = xtsFeign.findById(filter.getXtsId());
            Integer xtsValue = xts.getData().getXtsValue() + 1;
            xts.getData().setXtsValue(xtsValue);
            xtsFeign.update(xts.getData(),xts.getData().getId());
        }
        if(StringUtils.isEmpty(filter.getLove())){
            filter.setLove(0);
        }
        if(StringUtils.isEmpty(filter.getSold())){
            filter.setSold(0);
        }
        if(StringUtils.isEmpty(filter.getIsDelete())){
            filter.setIsDelete("0");
        }
        filter.setCreateTime(new Date());
        filter.setUpdateTime(new Date());
        filterMapper.insert(filter);
    }

    /**
     * 根据ID查询Filter
     * @param id
     * @return
     */
    @Override
    public Filter findById(Integer id){
        return  filterMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Filter全部数据
     * @return
     */
    @Override
    public List<Filter> findAll() {
        return filterMapper.selectAll();
    }
}
