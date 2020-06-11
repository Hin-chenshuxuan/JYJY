package com.jyjy.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.order.dao.ConsigneeMapper;
import com.jyjy.order.pojo.Consignee;
import com.jyjy.order.service.ConsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Consignee业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ConsigneeServiceImpl implements ConsigneeService {

    @Autowired
    private ConsigneeMapper consigneeMapper;


    /**
     * Consignee条件+分页查询
     * @param consignee 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Consignee> findPage(Consignee consignee, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(consignee);
        //执行搜索
        return new PageInfo<Consignee>(consigneeMapper.selectByExample(example));
    }

    /**
     * Consignee分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Consignee> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Consignee>(consigneeMapper.selectAll());
    }

    /**
     * Consignee条件查询
     * @param consignee
     * @return
     */
    @Override
    public List<Consignee> findList(Consignee consignee){
        //构建查询条件
        Example example = createExample(consignee);
        //根据构建的条件查询数据
        return consigneeMapper.selectByExample(example);
    }


    /**
     * Consignee构建查询对象
     * @param consignee
     * @return
     */
    public Example createExample(Consignee consignee){
        Example example=new Example(Consignee.class);
        Example.Criteria criteria = example.createCriteria();
        if(consignee!=null){
            // 
            if(!StringUtils.isEmpty(consignee.getId())){
                    criteria.andEqualTo("id",consignee.getId());
            }
            // 
            if(!StringUtils.isEmpty(consignee.getName())){
                    criteria.andLike("name","%"+consignee.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(consignee.getMobile())){
                    criteria.andEqualTo("mobile",consignee.getMobile());
            }
            // 
            if(!StringUtils.isEmpty(consignee.getEmail())){
                    criteria.andEqualTo("email",consignee.getEmail());
            }
            // 
            if(!StringUtils.isEmpty(consignee.getMessage())){
                    criteria.andEqualTo("message",consignee.getMessage());
            }
            // 
            if(!StringUtils.isEmpty(consignee.getAddress())){
                    criteria.andEqualTo("address",consignee.getAddress());
            }
            // 
            if(!StringUtils.isEmpty(consignee.getCreateTime())){
                    criteria.andEqualTo("createTime",consignee.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(consignee.getUpdateTime())){
                    criteria.andEqualTo("updateTime",consignee.getUpdateTime());
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
        consigneeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Consignee
     * @param consignee
     */
    @Override
    public void update(Consignee consignee){
        consigneeMapper.updateByPrimaryKey(consignee);
    }

    /**
     * 增加Consignee
     * @param consignee
     */
    @Override
    public void add(Consignee consignee){
        consigneeMapper.insert(consignee);
    }

    /**
     * 根据ID查询Consignee
     * @param id
     * @return
     */
    @Override
    public Consignee findById(Integer id){
        return  consigneeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Consignee全部数据
     * @return
     */
    @Override
    public List<Consignee> findAll() {
        return consigneeMapper.selectAll();
    }
}
