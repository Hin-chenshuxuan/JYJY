package com.jyjy.order.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Complaint构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "投诉",value = "Complaint")
@Table(name="complaint")
public class Complaint implements Serializable{

	@ApiModelProperty(value = "投诉ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "订单ID",required = false)
    @Column(name = "order_id")
	private Integer orderId;//

	@ApiModelProperty(value = "用户ID",required = false)
    @Column(name = "user_id")
	private Integer userId;//

	@ApiModelProperty(value = "修图师ID",required = false)
    @Column(name = "xts_id")
	private Integer xtsId;//

	@ApiModelProperty(value = "投诉类型",required = false)
    @Column(name = "type")
	private String type;//

	@ApiModelProperty(value = "投诉标题",required = false)
    @Column(name = "title")
	private String title;//

	@ApiModelProperty(value = "投诉详情",required = false)
    @Column(name = "detail")
	private String detail;//

	@ApiModelProperty(value = "投诉图片",required = false)
    @Column(name = "image")
	private String image;//

	@ApiModelProperty(value = "投诉状态",required = false)
    @Column(name = "status")
	private String status;//

	@ApiModelProperty(value = "投诉回复内容",required = false)
    @Column(name = "reply")
	private String reply;//

	@ApiModelProperty(value = "是否已删除 0-未删除 1-已删除",required = false)
    @Column(name = "is_delete")
	private String isDelete;//

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
	public Integer getOrderId() {
		return orderId;
	}

	//set方法
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	//get方法
	public Integer getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	//get方法
	public Integer getXtsId() {
		return xtsId;
	}

	//set方法
	public void setXtsId(Integer xtsId) {
		this.xtsId = xtsId;
	}
	//get方法
	public String getType() {
		return type;
	}

	//set方法
	public void setType(String type) {
		this.type = type;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public String getDetail() {
		return detail;
	}

	//set方法
	public void setDetail(String detail) {
		this.detail = detail;
	}
	//get方法
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public String getReply() {
		return reply;
	}

	//set方法
	public void setReply(String reply) {
		this.reply = reply;
	}
	//get方法
	public String getIsDelete() {
		return isDelete;
	}

	//set方法
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
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
