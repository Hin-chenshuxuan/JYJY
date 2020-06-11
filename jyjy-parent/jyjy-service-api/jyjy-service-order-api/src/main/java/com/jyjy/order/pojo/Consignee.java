package com.jyjy.order.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Consignee构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Consignee",value = "Consignee")
@Table(name="consignee")
public class Consignee implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "mobile")
	private String mobile;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "email")
	private String email;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "message")
	private String message;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "address")
	private String address;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "create_time")
	private Date createTime;//

	@ApiModelProperty(value = "",required = false)
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
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
	}
	//get方法
	public String getMessage() {
		return message;
	}

	//set方法
	public void setMessage(String message) {
		this.message = message;
	}
	//get方法
	public String getAddress() {
		return address;
	}

	//set方法
	public void setAddress(String address) {
		this.address = address;
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
