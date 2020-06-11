package com.jyjy.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyjy.user.dao.UserMapper;
import com.jyjy.user.pojo.User;
import com.jyjy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****
 * @Author:chenshuxuan
 * @Description:User业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UserServiceImpl implements UserService {

    //小程序appid和秘钥
    private String appid = "wx2db9ff7b93ee1d63";
    private String secret = "bc0220ba8a677ffe030156fc1cdcb1ba";

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据前端传递的code查询openid
     */
    @Override
    public Map<String,String> getOpenid(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";System.out.println(url);
        Map<String,String> resultMap = sendReq(url);
        return resultMap;
    }

    /**
     * User条件+分页查询
     * @param user 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<User> findPage(User user, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(user);
        //执行搜索
        return new PageInfo<User>(userMapper.selectByExample(example));
    }

    /**
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<User> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<User>(userMapper.selectAll());
    }

    /**
     * User条件查询
     * @param user
     * @return
     */
    @Override
    public List<User> findList(User user){
        //构建查询条件
        Example example = createExample(user);
        //根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }


    /**
     * User构建查询对象
     * @param user
     * @return
     */
    public Example createExample(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 用户ID
            if(!StringUtils.isEmpty(user.getId())){
                    criteria.andEqualTo("id",user.getId());
            }
            // 微信唯一标识openid
            if(!StringUtils.isEmpty(user.getOpenid())){
                    criteria.andEqualTo("openid",user.getOpenid());
            }
            // 用户昵称
            if(!StringUtils.isEmpty(user.getUsername())){
                    criteria.andLike("username","%"+user.getUsername()+"%");
            }
            // 用户头像图片地址
            if(!StringUtils.isEmpty(user.getAvatarurl())){
                    criteria.andEqualTo("avatarurl",user.getAvatarurl());
            }
            // 用户性别
            if(!StringUtils.isEmpty(user.getGender())){
                    criteria.andEqualTo("gender",user.getGender());
            }
            // 
            if(!StringUtils.isEmpty(user.getLocation())){
                    criteria.andEqualTo("location",user.getLocation());
            }
            // 用户手机号码
            if(!StringUtils.isEmpty(user.getMobile())){
                    criteria.andEqualTo("mobile",user.getMobile());
            }
            // 
            if(!StringUtils.isEmpty(user.getCreateTime())){
                    criteria.andEqualTo("createTime",user.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(user.getUpdateTime())){
                    criteria.andEqualTo("updateTime",user.getUpdateTime());
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
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改User
     * @param user
     */
    @Override
    public void update(User user){
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 增加User
     * @param user
     */
    @Override
    public void add(User user){
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询User全部数据
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    private Map<String,String> sendReq(String url) {
        String result = "";
        Map<String,String> resultMap = new HashMap<String,String>();
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            java.util.Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            resultMap = JSON.parseObject(result,Map.class);
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}
