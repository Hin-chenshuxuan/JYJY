package com.jyjy.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Shop构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "小店",value = "Shop")
@Table(name="shop")
public class Shop implements Serializable{

	@ApiModelProperty(value = "小店ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "小店名称",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "联系方式",required = false)
    @Column(name = "mobile")
	private String mobile;//

	@ApiModelProperty(value = "小店等级",required = false)
    @Column(name = "shop_level")
	private String shopLevel;//

	@ApiModelProperty(value = "小店成长值",required = false)
    @Column(name = "shop_value")
	private Integer shopValue;//

	@ApiModelProperty(value = "小店佣金比例",required = false)
    @Column(name = "shop_scale")
	private String shopScale;//

	@ApiModelProperty(value = "小店总收益",required = false)
    @Column(name = "shop_income")
	private String shopIncome;//

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
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	public String getShopLevel() {
		return shopLevel;
	}

	//set方法
	public void setShopLevel(String shopLevel) {
		this.shopLevel = shopLevel;
	}
	//get方法
	public Integer getShopValue() {
		return shopValue;
	}

	//set方法
	public void setShopValue(Integer shopValue) {
		this.shopValue = shopValue;
	}
	//get方法
	public String getShopScale() {
		return shopScale;
	}

	//set方法
	public void setShopScale(String shopScale) {
		this.shopScale = shopScale;
	}
	//get方法
	public String getShopIncome() {
		return shopIncome;
	}

	//set方法
	public void setShopIncome(String shopIncome) {
		this.shopIncome = shopIncome;
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
