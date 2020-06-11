package com.jyjy.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.user.dao.XtsMapper;
import com.jyjy.user.pojo.Xts;
import com.jyjy.user.service.XtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Xts业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class XtsServiceImpl implements XtsService {

    @Autowired
    private XtsMapper xtsMapper;


    /**
     * Xts条件+分页查询
     * @param xts 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Xts> findPage(Xts xts, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(xts);
        //执行搜索
        return new PageInfo<Xts>(xtsMapper.selectByExample(example));
    }

    /**
     * Xts分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Xts> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Xts>(xtsMapper.selectAll());
    }

    /**
     * Xts条件查询
     * @param xts
     * @return
     */
    @Override
    public List<Xts> findList(Xts xts){
        //构建查询条件
        Example example = createExample(xts);
        //根据构建的条件查询数据
        return xtsMapper.selectByExample(example);
    }


    /**
     * Xts构建查询对象
     * @param xts
     * @return
     */
    public Example createExample(Xts xts){
        Example example=new Example(Xts.class);
        Example.Criteria criteria = example.createCriteria();
        if(xts!=null){
            // 
            if(!StringUtils.isEmpty(xts.getId())){
                    criteria.andEqualTo("id",xts.getId());
            }
            // 
            if(!StringUtils.isEmpty(xts.getShopId())){
                    criteria.andEqualTo("shopId",xts.getShopId());
            }
            // 
            if(!StringUtils.isEmpty(xts.getOpenid())){
                    criteria.andEqualTo("openid",xts.getOpenid());
            }
            // 
            if(!StringUtils.isEmpty(xts.getXtsStatus())){
                    criteria.andEqualTo("xtsStatus",xts.getXtsStatus());
            }
            // 
            if(!StringUtils.isEmpty(xts.getUsername())){
                    criteria.andLike("username","%"+xts.getUsername()+"%");
            }
            // 
            if(!StringUtils.isEmpty(xts.getPassword())){
                    criteria.andEqualTo("password",xts.getPassword());
            }
            // 
            if(!StringUtils.isEmpty(xts.getMobile())){
                    criteria.andEqualTo("mobile",xts.getMobile());
            }
            // 
            if(!StringUtils.isEmpty(xts.getIdcard())){
                    criteria.andEqualTo("idcard",xts.getIdcard());
            }
            // 
            if(!StringUtils.isEmpty(xts.getIdcardImage())){
                    criteria.andEqualTo("idcardImage",xts.getIdcardImage());
            }
            //
            if(!StringUtils.isEmpty(xts.getAuthImage())){
                criteria.andEqualTo("authImage",xts.getAuthImage());
            }
            // 
            if(!StringUtils.isEmpty(xts.getXtsLevel())){
                    criteria.andEqualTo("xtsLevel",xts.getXtsLevel());
            }
            // 
            if(!StringUtils.isEmpty(xts.getXtsValue())){
                    criteria.andEqualTo("xtsValue",xts.getXtsValue());
            }
            // 
            if(!StringUtils.isEmpty(xts.getXtsScale())){
                    criteria.andEqualTo("xtsScale",xts.getXtsScale());
            }
            // 
            if(!StringUtils.isEmpty(xts.getXtsIncome())){
                    criteria.andEqualTo("xtsIncome",xts.getXtsIncome());
            }
            // 
            if(!StringUtils.isEmpty(xts.getJtsStatus())){
                    criteria.andEqualTo("jtsStatus",xts.getJtsStatus());
            }
            //
            if(!StringUtils.isEmpty(xts.getJtsLevel())){
                criteria.andEqualTo("jtsLevel",xts.getJtsLevel());
            }
            // 
            if(!StringUtils.isEmpty(xts.getJtsValue())){
                    criteria.andEqualTo("jtsValue",xts.getJtsValue());
            }
            // 
            if(!StringUtils.isEmpty(xts.getJtsScale())){
                    criteria.andEqualTo("jtsScale",xts.getJtsScale());
            }
            // 
            if(!StringUtils.isEmpty(xts.getJtsIncome())){
                    criteria.andEqualTo("jtsIncome",xts.getJtsIncome());
            }
            // 
            if(!StringUtils.isEmpty(xts.getCreateTime())){
                    criteria.andEqualTo("createTime",xts.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(xts.getUpdateTime())){
                    criteria.andEqualTo("updateTime",xts.getUpdateTime());
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
        xtsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Xts
     * @param xts
     */
    @Override
    public void update(Xts xts){
        xts.setUpdateTime(new Date());
        xtsMapper.updateByPrimaryKeySelective(xts);
        Xts newXts = findById(xts.getId());
        //修图师认证 如果有身份证正反面照片和摄影资格照片，则认证通过
        if(!StringUtils.isEmpty(newXts.getIdcardImage()) && !StringUtils.isEmpty(newXts.getAuthImage())){
            newXts.setXtsStatus("1");
        }
        //修图师成长值
        if(!StringUtils.isEmpty(newXts.getXtsValue())){
            Integer xtsValue = newXts.getXtsValue();
            if(xtsValue < 100){
                newXts.setXtsLevel("1");
                newXts.setJtsStatus("0");
            }
            if(xtsValue >= 100 && xtsValue <600){
                newXts.setXtsLevel("2");
                newXts.setJtsStatus("1");
            }
            if(xtsValue >= 600 && xtsValue <=1000){
                newXts.setXtsLevel("3");
                newXts.setJtsStatus("1");
            }
            if(xtsValue > 1000){
                newXts.setXtsValue(1000);
            }
            xts.setUpdateTime(new Date());
            xtsMapper.updateByPrimaryKeySelective(xts);
        }
        //鉴图师成长值
        if(!StringUtils.isEmpty(newXts.getJtsValue())){
            Integer jtsValue = newXts.getJtsValue();
            if(jtsValue < 0){
                newXts.setJtsStatus("0");
                newXts.setXtsLevel("1");
            }
            if(jtsValue > 0 && jtsValue < 50){
                newXts.setXtsLevel("2");
            }
            if(jtsValue >= 50 && jtsValue < 200){
                newXts.setXtsLevel("3");
            }
            if(jtsValue > 200 && jtsValue <=500){
                newXts.setXtsLevel("4");
            }
            if(jtsValue > 500){
                newXts.setJtsValue(500);
            }
            xts.setUpdateTime(new Date());
            xtsMapper.updateByPrimaryKeySelective(xts);
        }
    }

    /**
     * 增加Xts
     * @param xts
     */
    @Override
    public void add(Xts xts){
        if(StringUtils.isEmpty(xts.getXtsStatus())){
            xts.setXtsStatus("0");
        }
        if(StringUtils.isEmpty(xts.getXtsLevel())){
            xts.setXtsLevel("0");
        }
        if(StringUtils.isEmpty(xts.getXtsValue())){
            xts.setXtsValue(20);
        }
        if(StringUtils.isEmpty(xts.getXtsScale())){
            xts.setXtsScale("0.50");
        }
        if(StringUtils.isEmpty(xts.getXtsIncome())){
            xts.setXtsIncome("0");
        }
        if(StringUtils.isEmpty(xts.getJtsStatus())){
            xts.setJtsStatus("0");
        }
        if(StringUtils.isEmpty(xts.getJtsLevel())){
            xts.setJtsLevel("0");
        }
        if(StringUtils.isEmpty(xts.getJtsValue())){
            xts.setJtsValue(20);
        }
        if(StringUtils.isEmpty(xts.getJtsScale())){
            xts.setJtsScale("0.10");
        }
        if(StringUtils.isEmpty(xts.getJtsIncome())){
            xts.setJtsIncome("0");
        }
        xts.setCreateTime(new Date());
        xts.setUpdateTime(new Date());
        xtsMapper.insert(xts);
    }

    /**
     * 根据ID查询Xts
     * @param id
     * @return
     */
    @Override
    public Xts findById(Integer id){
        return  xtsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Xts全部数据
     * @return
     */
    @Override
    public List<Xts> findAll() {
        return xtsMapper.selectAll();
    }
}
