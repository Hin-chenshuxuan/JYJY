package com.jyjy.order.pojo;

import com.jyjy.user.pojo.User;
import com.jyjy.user.pojo.Xts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:chenshuxuan
 * @Description:Order构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "订单",value = "Order")
@Table(name="orders")
public class Order implements Serializable{

	@ApiModelProperty(value = "订单ID",required = false)
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

	@ApiModelProperty(value = "鉴定该订单的鉴图师ID",required = false)
	@Column(name = "jts_id")
	private Integer jtsId;//

	@ApiModelProperty(value = "收货人信息ID",required = false)
	@Column(name = "consignee_id")
	private Integer consigneeId;//

	@ApiModelProperty(value = "滤镜/修图服务商品ID",required = false)
    @Column(name = "connect_id")
	private Integer connectId;//

	@ApiModelProperty(value = "订单类型 0-滤镜商品订单 1-修图服务商品订单",required = false)
    @Column(name = "order_type")
	private String orderType;//

	@ApiModelProperty(value = "小计金额",required = false)
    @Column(name = "sub_price")
	private String subPrice;//

	@ApiModelProperty(value = "增值服务金额",required = false)
    @Column(name = "add_price")
	private String addPrice;//

	@ApiModelProperty(value = "优惠金额",required = false)
    @Column(name = "dis_price")
	private String disPrice;//

	@ApiModelProperty(value = "总计金额",required = false)
    @Column(name = "total_price")
	private String totalPrice;//

	@ApiModelProperty(value = "滤镜商品评分(滤镜商品) -2分/3分/5分",required = false)
    @Column(name = "filter_comment_value")
	private Integer filterCommentValue;//

	@ApiModelProperty(value = "滤镜商品评分内容(滤镜商品)",required = false)
    @Column(name = "filter_comment_detail")
	private String filterCommentDetail;//

	@ApiModelProperty(value = "修图师评分(修图服务商品) -5分/5分/10分",required = false)
    @Column(name = "xts_comment_value")
	private Integer xtsCommentValue;//

	@ApiModelProperty(value = "修图师评分内容(修图服务商品)",required = false)
    @Column(name = "xts_comment_detail")
	private String xtsCommentDetail;//

	@ApiModelProperty(value = "鉴图师评分(修图服务商品) -2分/3分/5分",required = false)
    @Column(name = "jts_comment_value")
	private Integer jtsCommentValue;//

	@ApiModelProperty(value = "鉴图师评分内容(修图服务商品)",required = false)
    @Column(name = "jts_comment_detail")
	private String jtsCommentDetail;//

	@ApiModelProperty(value = "支付状态 0-待支付 1-支付成功 2-支付失败",required = false)
	@Column(name = "pay_status")
	private String payStatus;//

	@ApiModelProperty(value = "订单状态 0-未付款 1-制作中 2-已完成 3-已评分 4-已取消",required = false)
    @Column(name = "status")
	private String status;//

	@ApiModelProperty(value = "是否已结算(用于后台计算收益) 0-未结算 1-收益已结算 2-成长值已结算，",required = false)
	@Column(name = "is_settle")
	private String isSettle;//

	@ApiModelProperty(value = "是否被投诉 0-未被投诉 1-被投诉(滤镜-5/修图师-10，鉴图师-2)，",required = false)
	@Column(name = "is_complaint")
	private String isComplaint;//

	@ApiModelProperty(value = "是否已删除 0-未删除 1-已删除",required = false)
    @Column(name = "is_delete")
	private String isDelete;//

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//

	//用户信息
	@ApiModelProperty(value = "用户信息",required = false)
	private User userInfo;
	//修图师信息
	@ApiModelProperty(value = "修图师信息",required = false)
	private Xts xtsInfo;
	//鉴图师信息
	@ApiModelProperty(value = "鉴图师信息",required = false)
	private Xts jtsInfo;

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

	public Integer getJtsId() {
		return jtsId;
	}

	public void setJtsId(Integer jtsId) {
		this.jtsId = jtsId;
	}

	public Integer getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(Integer consigneeId) {
		this.consigneeId = consigneeId;
	}

	//get方法
	public Integer getConnectId() {
		return connectId;
	}

	//set方法
	public void setConnectId(Integer connectId) {
		this.connectId = connectId;
	}
	//get方法
	public String getOrderType() {
		return orderType;
	}

	//set方法
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	//get方法
	public String getSubPrice() {
		return subPrice;
	}

	//set方法
	public void setSubPrice(String subPrice) {
		this.subPrice = subPrice;
	}
	//get方法
	public String getAddPrice() {
		return addPrice;
	}

	//set方法
	public void setAddPrice(String addPrice) {
		this.addPrice = addPrice;
	}
	//get方法
	public String getDisPrice() {
		return disPrice;
	}

	//set方法
	public void setDisPrice(String disPrice) {
		this.disPrice = disPrice;
	}
	//get方法
	public String getTotalPrice() {
		return totalPrice;
	}

	//set方法
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	//get方法
	public Integer getFilterCommentValue() {
		return filterCommentValue;
	}

	//set方法
	public void setFilterCommentValue(Integer filterCommentValue) {
		this.filterCommentValue = filterCommentValue;
	}
	//get方法
	public String getFilterCommentDetail() {
		return filterCommentDetail;
	}

	//set方法
	public void setFilterCommentDetail(String filterCommentDetail) {
		this.filterCommentDetail = filterCommentDetail;
	}
	//get方法
	public Integer getXtsCommentValue() {
		return xtsCommentValue;
	}

	//set方法
	public void setXtsCommentValue(Integer xtsCommentValue) {
		this.xtsCommentValue = xtsCommentValue;
	}
	//get方法
	public String getXtsCommentDetail() {
		return xtsCommentDetail;
	}

	//set方法
	public void setXtsCommentDetail(String xtsCommentDetail) {
		this.xtsCommentDetail = xtsCommentDetail;
	}
	//get方法
	public Integer getJtsCommentValue() {
		return jtsCommentValue;
	}

	//set方法
	public void setJtsCommentValue(Integer jtsCommentValue) {
		this.jtsCommentValue = jtsCommentValue;
	}
	//get方法
	public String getJtsCommentDetail() {
		return jtsCommentDetail;
	}

	//set方法
	public void setJtsCommentDetail(String jtsCommentDetail) {
		this.jtsCommentDetail = jtsCommentDetail;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsSettle() {
		return isSettle;
	}

	public void setIsSettle(String isSettle) {
		this.isSettle = isSettle;
	}

	public String getIsComplaint() {
		return isComplaint;
	}

	public void setIsComplaint(String isComplaint) {
		this.isComplaint = isComplaint;
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

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public Xts getXtsInfo() {
		return xtsInfo;
	}

	public void setXtsInfo(Xts xtsInfo) {
		this.xtsInfo = xtsInfo;
	}

	public Xts getJtsInfo() {
		return jtsInfo;
	}

	public void setJtsInfo(Xts jtsInfo) {
		this.jtsInfo = jtsInfo;
	}
}
