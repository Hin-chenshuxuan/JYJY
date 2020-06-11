package com.jyjy.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.user.dao.PlatformMapper;
import com.jyjy.user.pojo.Platform;
import com.jyjy.user.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Platform业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformMapper platformMapper;


    /**
     * Platform条件+分页查询
     * @param platform 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Platform> findPage(Platform platform, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(platform);
        //执行搜索
        return new PageInfo<Platform>(platformMapper.selectByExample(example));
    }

    /**
     * Platform分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Platform> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Platform>(platformMapper.selectAll());
    }

    /**
     * Platform条件查询
     * @param platform
     * @return
     */
    @Override
    public List<Platform> findList(Platform platform){
        //构建查询条件
        Example example = createExample(platform);
        //根据构建的条件查询数据
        return platformMapper.selectByExample(example);
    }


    /**
     * Platform构建查询对象
     * @param platform
     * @return
     */
    public Example createExample(Platform platform){
        Example example=new Example(Platform.class);
        Example.Criteria criteria = example.createCriteria();
        if(platform!=null){
            // 
            if(!StringUtils.isEmpty(platform.getId())){
                    criteria.andEqualTo("id",platform.getId());
            }
            // 
            if(!StringUtils.isEmpty(platform.getPlatformScale())){
                    criteria.andEqualTo("platformScale",platform.getPlatformScale());
            }
            // 
            if(!StringUtils.isEmpty(platform.getPlatformIncome())){
                    criteria.andEqualTo("platformIncome",platform.getPlatformIncome());
            }
            // 
            if(!StringUtils.isEmpty(platform.getCreateTime())){
                    criteria.andEqualTo("createTime",platform.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(platform.getUpdateTime())){
                    criteria.andEqualTo("updateTime",platform.getUpdateTime());
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
        platformMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Platform
     * @param platform
     */
    @Override
    public void update(Platform platform){
        platform.setUpdateTime(new Date());
        platformMapper.updateByPrimaryKeySelective(platform);
    }

    /**
     * 增加Platform
     * @param platform
     */
    @Override
    public void add(Platform platform){
        if(StringUtils.isEmpty(platform.getPlatformScale())){
            platform.setPlatformScale("0.20");
        }
        if(StringUtils.isEmpty(platform.getPlatformIncome())){
            platform.setPlatformIncome("0");
        }
        platform.setCreateTime(new Date());
        platform.setUpdateTime(new Date());
        platformMapper.insert(platform);
    }

    /**
     * 根据ID查询Platform
     * @param id
     * @return
     */
    @Override
    public Platform findById(Integer id){
        return  platformMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Platform全部数据
     * @return
     */
    @Override
    public List<Platform> findAll() {
        return platformMapper.selectAll();
    }
}
