package com.jyjy.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Xts构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "修图师",value = "Xts")
@Table(name="xts")
public class Xts implements Serializable{

	@ApiModelProperty(value = "修图师ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "对应小店ID",required = false)
    @Column(name = "shop_id")
	private Integer shopId;//

	@ApiModelProperty(value = "微信唯一标识openid(应该用不到)",required = false)
    @Column(name = "openid")
	private String openid;//

	@ApiModelProperty(value = "修图师认证 0-未通过 1-通过",required = false)
    @Column(name = "xts_status")
	private String xtsStatus;//

	@ApiModelProperty(value = "修图师昵称",required = false)
    @Column(name = "username")
	private String username;//

	@ApiModelProperty(value = "修图师密码",required = false)
    @Column(name = "password")
	private String password;//

	@ApiModelProperty(value = "联系方式",required = false)
    @Column(name = "mobile")
	private String mobile;//

	@ApiModelProperty(value = "身份证号码",required = false)
    @Column(name = "idcard")
	private String idcard;//

	@ApiModelProperty(value = "身份证正反面图片",required = false)
    @Column(name = "idcard_image")
	private String idcardImage;//

	@ApiModelProperty(value = "摄影资格证书图片",required = false)
	@Column(name = "auth_image")
	private String authImage;//

	@ApiModelProperty(value = "修图师等级 0-初级 1-专业级 2-大师级",required = false)
    @Column(name = "xts_level")
	private String xtsLevel;//

	@ApiModelProperty(value = "修图师成长值",required = false)
    @Column(name = "xts_value")
	private Integer xtsValue;//

	@ApiModelProperty(value = "修图师佣金比例",required = false)
    @Column(name = "xts_scale")
	private String xtsScale;//

	@ApiModelProperty(value = "修图师总收益",required = false)
    @Column(name = "xts_income")
	private String xtsIncome;//

	@ApiModelProperty(value = "鉴图师认证 0-未通过 1-通过",required = false)
    @Column(name = "jts_status")
	private String jtsStatus;//

	@ApiModelProperty(value = "鉴图师等级 0-初级 1-专业级 2-大师级",required = false)
	@Column(name = "jts_level")
	private String jtsLevel;//

	@ApiModelProperty(value = "鉴图师成长值",required = false)
    @Column(name = "jts_value")
	private Integer jtsValue;//

	@ApiModelProperty(value = "鉴图师佣金比例",required = false)
    @Column(name = "jts_scale")
	private String jtsScale;//

	@ApiModelProperty(value = "鉴图师总收益",required = false)
    @Column(name = "jts_income")
	private String jtsIncome;//

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
	public Integer getShopId() {
		return shopId;
	}

	//set方法
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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
	public String getXtsStatus() {
		return xtsStatus;
	}

	//set方法
	public void setXtsStatus(String xtsStatus) {
		this.xtsStatus = xtsStatus;
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
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
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
	public String getIdcard() {
		return idcard;
	}

	//set方法
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	//get方法
	public String getIdcardImage() {
		return idcardImage;
	}

	//set方法
	public void setIdcardImage(String idcardImage) {
		this.idcardImage = idcardImage;
	}

	public String getAuthImage() {
		return authImage;
	}

	public void setAuthImage(String authImage) {
		this.authImage = authImage;
	}

	//get方法
	public String getXtsLevel() {
		return xtsLevel;
	}

	//set方法
	public void setXtsLevel(String xtsLevel) {
		this.xtsLevel = xtsLevel;
	}
	//get方法
	public Integer getXtsValue() {
		return xtsValue;
	}

	//set方法
	public void setXtsValue(Integer xtsValue) {
		this.xtsValue = xtsValue;
	}
	//get方法
	public String getXtsScale() {
		return xtsScale;
	}

	//set方法
	public void setXtsScale(String xtsScale) {
		this.xtsScale = xtsScale;
	}
	//get方法
	public String getXtsIncome() {
		return xtsIncome;
	}

	//set方法
	public void setXtsIncome(String xtsIncome) {
		this.xtsIncome = xtsIncome;
	}
	//get方法
	public String getJtsStatus() {
		return jtsStatus;
	}

	//set方法
	public void setJtsStatus(String jtsStatus) {
		this.jtsStatus = jtsStatus;
	}

	public String getJtsLevel() {
		return jtsLevel;
	}

	public void setJtsLevel(String jtsLevel) {
		this.jtsLevel = jtsLevel;
	}

	//get方法
	public Integer getJtsValue() {
		return jtsValue;
	}

	//set方法
	public void setJtsValue(Integer jtsValue) {
		this.jtsValue = jtsValue;
	}
	//get方法
	public String getJtsScale() {
		return jtsScale;
	}

	//set方法
	public void setJtsScale(String jtsScale) {
		this.jtsScale = jtsScale;
	}
	//get方法
	public String getJtsIncome() {
		return jtsIncome;
	}

	//set方法
	public void setJtsIncome(String jtsIncome) {
		this.jtsIncome = jtsIncome;
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
