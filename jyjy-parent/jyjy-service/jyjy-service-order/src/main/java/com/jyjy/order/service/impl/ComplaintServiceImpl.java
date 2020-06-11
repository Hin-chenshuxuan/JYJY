package com.jyjy.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.order.dao.ComplaintMapper;
import com.jyjy.order.pojo.Complaint;
import com.jyjy.order.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:chenshuxuan
 * @Description:Complaint业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;


    /**
     * Complaint条件+分页查询
     * @param complaint 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Complaint> findPage(Complaint complaint, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(complaint);
        //执行搜索
        return new PageInfo<Complaint>(complaintMapper.selectByExample(example));
    }

    /**
     * Complaint分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Complaint> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Complaint>(complaintMapper.selectAll());
    }

    /**
     * Complaint条件查询
     * @param complaint
     * @return
     */
    @Override
    public List<Complaint> findList(Complaint complaint){
        //构建查询条件
        Example example = createExample(complaint);
        //根据构建的条件查询数据
        return complaintMapper.selectByExample(example);
    }


    /**
     * Complaint构建查询对象
     * @param complaint
     * @return
     */
    public Example createExample(Complaint complaint){
        Example example=new Example(Complaint.class);
        Example.Criteria criteria = example.createCriteria();
        if(complaint!=null){
            // 
            if(!StringUtils.isEmpty(complaint.getId())){
                    criteria.andEqualTo("id",complaint.getId());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getOrderId())){
                    criteria.andEqualTo("orderId",complaint.getOrderId());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getUserId())){
                    criteria.andEqualTo("userId",complaint.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getXtsId())){
                    criteria.andEqualTo("xtsId",complaint.getXtsId());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getType())){
                    criteria.andEqualTo("type",complaint.getType());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getTitle())){
                    criteria.andLike("title","%"+complaint.getTitle()+"%");
            }
            // 
            if(!StringUtils.isEmpty(complaint.getDetail())){
                    criteria.andEqualTo("detail",complaint.getDetail());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getImage())){
                    criteria.andEqualTo("image",complaint.getImage());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getStatus())){
                    criteria.andEqualTo("status",complaint.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getReply())){
                    criteria.andEqualTo("reply",complaint.getReply());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getIsDelete())){
                    criteria.andEqualTo("isDelete",complaint.getIsDelete());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getCreateTime())){
                    criteria.andEqualTo("createTime",complaint.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(complaint.getUpdateTime())){
                    criteria.andEqualTo("updateTime",complaint.getUpdateTime());
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
        complaintMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Complaint
     * @param complaint
     */
    @Override
    public void update(Complaint complaint){
        complaint.setUpdateTime(new Date());
        complaintMapper.updateByPrimaryKeySelective(complaint);
    }

    /**
     * 增加Complaint
     * @param complaint
     */
    @Override
    public void add(Complaint complaint){
        if(StringUtils.isEmpty(complaint.getStatus())){
            complaint.setStatus("0");
        }
        if(StringUtils.isEmpty(complaint.getIsDelete())){
            complaint.setIsDelete("0");
        }
        complaint.setCreateTime(new Date());
        complaint.setUpdateTime(new Date());
        complaintMapper.insert(complaint);
    }

    /**
     * 根据ID查询Complaint
     * @param id
     * @return
     */
    @Override
    public Complaint findById(Integer id){
        return  complaintMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Complaint全部数据
     * @return
     */
    @Override
    public List<Complaint> findAll() {
        return complaintMapper.selectAll();
    }
}
