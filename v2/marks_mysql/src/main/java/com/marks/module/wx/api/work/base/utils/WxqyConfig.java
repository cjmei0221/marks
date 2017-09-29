package com.marks.module.wx.api.work.base.utils;

public class WxqyConfig {

	public static String weixin_qy_server_prefix = WxqyUtil.getProperty("weixin_qy_server_prefix");

	public static String WEIXIN_CONVERT_TO_OPENID = WxqyUtil.getProperty("weixin_convert_to_openid");

	// 创建部门
	public static String WEIXIN_CREATE_DEPARTMENT = WxqyUtil.getProperty("weixin_create_department");
	// 更新部门
	public static String WEIXIN_UPDATE_DEPARTMENT = WxqyUtil.getProperty("weixin_update_department");
	// 删除部门
	public static String WEIXIN_DELETE_DEPARTMENT = WxqyUtil.getProperty("weixin_delete_department");
	// 获取部门列表
	public static String WEIXIN_LIST_DEPARTMENT = WxqyUtil.getProperty("weixin_list_department");
	// 创建企业成员
	public static String WEIXIN_CREATE_ENTERPRISEUSER = WxqyUtil.getProperty("weixin_create_enterpriseuser");
	// 修改企业成员
	public static String WEIXIN_UPDATE_ENTERPRISEUSER = WxqyUtil.getProperty("weixin_update_enterpriseuser");
	// 删除企业成员
	public static String WEIXIN_DELETE_ENTERPRISEUSER = WxqyUtil.getProperty("weixin_delete_enterpriseuser");
	// 批量删除企业成员
	public static String WEIXIN_DELETE_ENTERPRISEUSER_LIST = WxqyUtil.getProperty("weixin_delete_enterpriseuser_list");
	// 获取成员
	public static String WEIXIN_GET_ENTERPRISEUSER = WxqyUtil.getProperty("weixin_get_enterpriseuser");
	// 获取部门成员
	public static String WEIXIN_GETDEPARTMENT_ENTERPRISEUSER = WxqyUtil
			.getProperty("weixin_getdepartment_enterpriseuser");
	// 获取部门成员（详情）
	public static String WEIXIN_GETDEPARTMENT_ENTERPRISEUSER_DETAIL = WxqyUtil
			.getProperty("weixin_getdepartment_enterpriseuser_detail");
	// 邀请成员关注
	public static String WEIXIN_SEND_INVITE = WxqyUtil.getProperty("weixin_send_invite");
	// 推送消息
	public static String qyhao_sendmsg = WxqyUtil.getProperty("qyhao_sendmsg");

}
