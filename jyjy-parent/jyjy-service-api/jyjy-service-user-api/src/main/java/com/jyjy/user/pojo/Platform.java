package com.jyjy.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Platform构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "平台",value = "Platform")
@Table(name="platform")
public class Platform implements Serializable{

	@ApiModelProperty(value = "平台ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "平台佣金比例",required = false)
    @Column(name = "platform_scale")
	private String platformScale = "0.2";//

	@ApiModelProperty(value = "平台总收益",required = false)
    @Column(name = "platform_income")
	private String platformIncome = "0";//

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
	public String getPlatformScale() {
		return platformScale;
	}

	//set方法
	public void setPlatformScale(String platformScale) {
		this.platformScale = platformScale;
	}
	//get方法
	public String getPlatformIncome() {
		return platformIncome;
	}

	//set方法
	public void setPlatformIncome(String platformIncome) {
		this.platformIncome = platformIncome;
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
