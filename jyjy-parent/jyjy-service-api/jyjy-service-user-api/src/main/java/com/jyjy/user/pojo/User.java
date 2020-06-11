package com.jyjy.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:User构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "用户",value = "User")
@Table(name="user")
public class User implements Serializable{

	@ApiModelProperty(value = "用户ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//用户ID

	@ApiModelProperty(value = "微信唯一标识openid",required = false)
    @Column(name = "openid")
	private String openid;//微信唯一标识openid

	@ApiModelProperty(value = "用户昵称",required = false)
    @Column(name = "username")
	private String username;//用户昵称

	@ApiModelProperty(value = "用户头像图片地址",required = false)
    @Column(name = "avatarurl")
	private String avatarurl;//用户头像图片地址

	@ApiModelProperty(value = "用户性别 0-男性 1-女性",required = false)
    @Column(name = "gender")
	private String gender;//用户性别

	@ApiModelProperty(value = "用户地区",required = false)
    @Column(name = "location")
	private String location;//

	@ApiModelProperty(value = "用户手机号码",required = false)
    @Column(name = "mobile")
	private String mobile;//用户手机号码

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getOpenid() {
		return openid;
	}

	//set方法
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getAvatarurl() {
		return avatarurl;
	}

	//set方法
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	//get方法
	public String getGender() {
		return gender;
	}

	//set方法
	public void setGender(String gender) {
		this.gender = gender;
	}
	//get方法
	public String getLocation() {
		return location;
	}

	//set方法
	public void setLocation(String location) {
		this.location = location;
	}
	//get方法
	public String getMobile() {
		return mobile;
	}

	//set方法
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}
