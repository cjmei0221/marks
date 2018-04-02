package com.marks.module.user.sysuser.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marks.common.enums.ChannelEnums;

public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userid;

	private String userCode;
	/**
	 * 用户名称
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 绑定手机号码
	 */
	private String bind_mobile;
	/**
	 * 激活标识
	 */
	private int activeFlag;
	/**
	 * 激活标识
	 */
	private int bindFlag;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 口令
	 */
	private String token;

	private String openid;
	private String accountid;

	private int skin;

	private int hideFlag = 0;// 隐藏标识 1:隐藏

	private List<String> userUrlList = new ArrayList<String>();

	private String companyId;
	/**
	 * 用户ID
	 */
	private String userRoleOrgId;
	private String roleId;
	private String roleName;
	private String roleType;
	private int roleLvl;
	private int roleYwType;// 角色业务类型

	private String orgId;
	private String orgName;
	private int orgType;
	private int orgCategory;
	private String parentOrgId;
	private String parentOrgName;

	private int gender;// 性别
	private String birthday;// 生日
	private String signature;// 签名
	private String idNumber;// 身份证
	private String email;// Email
	private String entryDate;// 入职日期

	private String channelId;// 渠道

	private String channel;// 渠道

	private String lvlId;// 等级编号

	private String lvlName;// 等级名称

	private String roleId1;// 角色2

	private String roleId2;// 角色3

	public String getUserRoleOrgId() {
		return userRoleOrgId;
	}

	public void setUserRoleOrgId(String userRoleOrgId) {
		this.userRoleOrgId = userRoleOrgId;
	}

	public String getRoleId1() {
		return roleId1;
	}

	public void setRoleId1(String roleId1) {
		this.roleId1 = roleId1;
	}

	public String getRoleId2() {
		return roleId2;
	}

	public void setRoleId2(String roleId2) {
		this.roleId2 = roleId2;
	}

	public int getRoleYwType() {
		return roleYwType;
	}

	public void setRoleYwType(int roleYwType) {
		this.roleYwType = roleYwType;
	}

	public String getLvlId() {
		return lvlId;
	}

	public void setLvlId(String lvlId) {
		this.lvlId = lvlId;
	}

	public String getLvlName() {
		return lvlName;
	}

	public void setLvlName(String lvlName) {
		this.lvlName = lvlName;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannel() {
		return ChannelEnums.Channel.getByKey(channelId);
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public int getOrgCategory() {
		return orgCategory;
	}

	public void setOrgCategory(int orgCategory) {
		this.orgCategory = orgCategory;
	}

	public int getHideFlag() {
		return hideFlag;
	}

	public void setHideFlag(int hideFlag) {
		this.hideFlag = hideFlag;
	}

	public int getRoleLvl() {
		return roleLvl;
	}

	public void setRoleLvl(int roleLvl) {
		this.roleLvl = roleLvl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBind_mobile() {
		return bind_mobile;
	}

	public void setBind_mobile(String bind_mobile) {
		this.bind_mobile = bind_mobile;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getUserUrlList() {
		return userUrlList;
	}

	public void setUserUrlList(List<String> userUrlList) {
		this.userUrlList = userUrlList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getBindFlag() {
		return bindFlag;
	}

	public void setBindFlag(int bindFlag) {
		this.bindFlag = bindFlag;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}

}