package com.jyjy.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Filter构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "滤镜商品",value = "Filter")
@Table(name="filter")
public class Filter implements Serializable{

	@ApiModelProperty(value = "滤镜商品ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "修图师ID",required = false)
    @Column(name = "xts_id")
	private Integer xtsId;//

	@ApiModelProperty(value = "滤镜商品状态 1-pending 2-active",required = false)
    @Column(name = "status")
	private String status;//

	@ApiModelProperty(value = "滤镜商品名称",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "滤镜商品图片",required = false)
    @Column(name = "image")
	private String image;//

	@ApiModelProperty(value = "滤镜商品标签",required = false)
    @Column(name = "tag")
	private String tag;//

	@ApiModelProperty(value = "滤镜商品价格",required = false)
    @Column(name = "price")
	private String price;//

	@ApiModelProperty(value = "滤镜商品点赞数",required = false)
    @Column(name = "love")
	private Integer love;//

	@ApiModelProperty(value = "滤镜商品已售",required = false)
    @Column(name = "sold")
	private Integer sold;//

	@ApiModelProperty(value = "滤镜商品文件",required = false)
    @Column(name = "file")
	private String file;//

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
	public Integer getXtsId() {
		return xtsId;
	}

	//set方法
	public void setXtsId(Integer xtsId) {
		this.xtsId = xtsId;
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
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	public String getTag() {
		return tag;
	}

	//set方法
	public void setTag(String tag) {
		this.tag = tag;
	}
	//get方法
	public String getPrice() {
		return price;
	}

	//set方法
	public void setPrice(String price) {
		this.price = price;
	}
	//get方法
	public Integer getLove() {
		return love;
	}

	//set方法
	public void setLove(Integer love) {
		this.love = love;
	}
	//get方法
	public Integer getSold() {
		return sold;
	}

	//set方法
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	//get方法
	public String getFile() {
		return file;
	}

	//set方法
	public void setFile(String file) {
		this.file = file;
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
