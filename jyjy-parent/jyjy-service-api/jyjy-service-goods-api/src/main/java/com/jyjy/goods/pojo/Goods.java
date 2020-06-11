package com.jyjy.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Goods构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "修图服务商品",value = "Goods")
@Table(name="goods")
public class Goods implements Serializable{

	@ApiModelProperty(value = "修图服务商品ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "用户ID",required = false)
    @Column(name = "user_id")
	private Integer userId;//

	@ApiModelProperty(value = "修图师ID",required = false)
    @Column(name = "xts_id")
	private Integer xtsId;//

	@ApiModelProperty(value = "商品状态(未启用) 0-未付款 1-制作中 2-已完成 3-已评价 4-已取消",required = false)
    @Column(name = "status")
	private String status;//

	@ApiModelProperty(value = "商品类型 0-个人 1-企业",required = false)
    @Column(name = "goods_type")
	private String goodsType;//

	@ApiModelProperty(value = "商品名称",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "需求描述",required = false)
    @Column(name = "detail")
	private String detail;//

	@ApiModelProperty(value = "修图类型",required = false)
    @Column(name = "type")
	private String type;//

	@ApiModelProperty(value = "云盘链接(企业)",required = false)
    @Column(name = "link")
	private String link;//

	@ApiModelProperty(value = "待修图片(个人)",required = false)
    @Column(name = "image")
	private String image;//

	@ApiModelProperty(value = "修图师等级",required = false)
    @Column(name = "xts_level")
	private String xtsLevel;//

	@ApiModelProperty(value = "修图服务商品价格 0/3/5元",required = false)
    @Column(name = "price")
	private String price;//

	@ApiModelProperty(value = "加急等级 0-延时修(0元/张) 1-免费闪电修(0.5元/张) 2-普修闪电修(2.0元/张) 3-精修闪电修(5.0元/张)",required = false)
    @Column(name = "urgent_level")
	private String urgentLevel;//

	@ApiModelProperty(value = "图片数量",required = false)
    @Column(name = "amount")
	private Integer amount;//

	@ApiModelProperty(value = "联系方式",required = false)
    @Column(name = "mobile")
	private String mobile;//

	@ApiModelProperty(value = "修图完成文件",required = false)
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
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public String getGoodsType() {
		return goodsType;
	}

	//set方法
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
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
	public String getDetail() {
		return detail;
	}

	//set方法
	public void setDetail(String detail) {
		this.detail = detail;
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
	public String getLink() {
		return link;
	}

	//set方法
	public void setLink(String link) {
		this.link = link;
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
	public String getXtsLevel() {
		return xtsLevel;
	}

	//set方法
	public void setXtsLevel(String xtsLevel) {
		this.xtsLevel = xtsLevel;
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
	public String getUrgentLevel() {
		return urgentLevel;
	}

	//set方法
	public void setUrgentLevel(String urgentLevel) {
		this.urgentLevel = urgentLevel;
	}
	//get方法
	public Integer getAmount() {
		return amount;
	}

	//set方法
	public void setAmount(Integer amount) {
		this.amount = amount;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
