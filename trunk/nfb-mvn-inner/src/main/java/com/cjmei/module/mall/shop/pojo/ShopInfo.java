package com.cjmei.module.mall.shop.pojo;

import java.util.Date;

public class ShopInfo {
	
	private String shopid;//商铺ID或公司ID
	private String shopname;//商铺名称或公司名称
	
	private Date createtime;//创建时间
	private Date updatetime;//更新时间
	private String creator;//创建者
	private int delflag;//删除  0：不删除1：删除
	private int is_company;//是否为公司 0：店铺 1：公司
	
	private String companyid;//公司ID,若为店铺时，则选择所属公司ID
	private String companyname;//公司名称
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public int getIs_company() {
		return is_company;
	}
	public void setIs_company(int is_company) {
		this.is_company = is_company;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
}
