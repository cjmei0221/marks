package com.marks.module.weixin.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.marks.common.domain.Result;
import com.marks.module.system.core.data.StaticData;
import com.marks.module.weixin.qyhao.pojo.Department;
import com.marks.module.weixin.qyhao.pojo.EnterpriseUser;
import com.marks.module.weixin.qyhao.pojo.QyHaoMsg;
import com.marks.module.weixin.qyhao.pojo.UidToOpenid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WxQyUtil {
	private static String CHARSET = "UTF-8";
	private static String wx_host_url = StaticData.getSysConf("wx_host_url");
	private static Logger logger = Logger.getLogger(WxQyUtil.class);
	private static WxQyUtil util = null;

	private WxQyUtil() {
	}

	public static WxQyUtil getInstance() {
		if (util == null) {
			util = new WxQyUtil();
		}
		return util;
	}
	/**
	 * 获取企业号用户Userid
	 * @param args
	 * @throws IOException
	 */
	public String getQyUserid(String accountid,String code) throws IOException{
		String userid = null;
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("accountid", accountid);
			params.put("code", code);
			JsonResult rs =  HttpUtils.getInstance().doPost(wx_host_url + "/qyAuth/getUserid.do", params, null, CHARSET);
			if(rs.getSuccess()){
				userid=rs.getResult().toString();
			}
		} catch (Exception e) {
			logger.info("获取QyUserid失败",e);
		}
		return userid;
	}

	/**
	 * 推送企业号消息
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result sendQyMsg(String accountid, QyHaoMsg msg) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != msg) {
			params.put("accountid", msg.getAccountid());
			params.put("userid", msg.getTouser());
			params.put("content", URLEncoder.encode(msg.getContent(), CHARSET));
			params.put("agentid", msg.getAgentid());
			params.put("safe", msg.getSafe());
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/qyhao/sendTextMsg.do", params, null,
					CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * userid转换成openid接口
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public UidToOpenid changeUidToOpid(String accountid, String userId, String agentid) throws IOException {
		UidToOpenid op = null;
		Map<String, String> params = new HashMap<String, String>();
		if (null != userId) {
			params.put("accountid", accountid);
			params.put("userId", userId);
			if (null != agentid && !"".equals(agentid)) {
				params.put("agentid", agentid);
			}
			JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/changeUidToOpid.do", params, null,
					CHARSET);
			if (result.getSuccess()) {
				JSONObject obj2 = JSONObject.fromObject(result.getResult());
				op = new UidToOpenid();
				if (null != obj2.get("appid")) {
					op.setAppid(obj2.getString("appid"));
				}
				op.setOpenid(obj2.getString("openid"));
			}
		}
		return op;
	}

	/**
	 * 创建部门
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result createDepartment(String accountid, Department po) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != po) {
			params.put("accountid", accountid);
			params.put("parentid", (Integer.parseInt(po.getParentid()) + ""));
			params.put("name", URLEncoder.encode(po.getName(), CHARSET));
			params.put("order", po.getOrder());
			params.put("id", (Integer.parseInt(po.getId()) + ""));
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/createDepartment.do", params, null,
					CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 修改部门
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result updateDepartment(String accountid, Department po) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != po) {
			params.put("accountid", accountid);
			params.put("parentid", Integer.parseInt(po.getParentid()) + "");
			params.put("name", URLEncoder.encode(po.getName(), CHARSET));
			params.put("order", po.getOrder());
			params.put("id", Integer.parseInt(po.getId()) + "");
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/updateDepartment.do", params, null,
					CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 删除部门
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result deleteDepartment(String accountid, String id) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != id) {
			params.put("accountid", accountid);
			params.put("id", Integer.parseInt(id) + "");
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/deleteDepartment.do", params, null,
					CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 获取部门
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public List<Department> listDepartment(String accountid, String id) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		List<Department> list = null;
		if (null != id) {
			params.put("accountid", accountid);
			params.put("id", Integer.parseInt(id) + "");
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/listDepartment.do", params, null,
					CHARSET);
			if (res.getSuccess()) {
				list = new ArrayList<Department>();
				JSONArray array = JSONArray.fromObject(res.getResult());
				if (null != array && array.size() > 0) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject object = array.getJSONObject(i);
						Department group = new Department(object.optString("name"), object.optString("parentid"),
								object.optString("order"), object.optString("id"));
						logger.info("listDepartment>" + group.getId() + "-" + group.getName());
						list.add(group);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 创建企业成员
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result createEnterpriseUser(String accountid, EnterpriseUser po) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != po) {
			int d = Integer.parseInt(po.getDepartment());
			// URLEncoder.encode(content, WXConstants.CHARSET)
			params.put("accountid", accountid);
			params.put("userid", po.getUserid());
			params.put("name", URLEncoder.encode(po.getName() == null ? "" : po.getName(), CHARSET));
			params.put("department", d + "");
			// params.put("position",
			// URLEncoder.encode(po.getPosition()==null?"":po.getPosition(),
			// WXConstants.CHARSET));
			params.put("position", "");
			params.put("mobile", po.getMobile());
			params.put("gender", po.getGender());
			params.put("email", po.getEmail());
			params.put("weixinid", po.getWeixinid());
			// params.put("avatar_mediaid",
			// URLEncoder.encode(po.getAvatar_mediaid(), WXConstants.CHARSET));
			params.put("extattr", URLEncoder.encode(po.getExtattr() == null ? "" : po.getExtattr(), CHARSET));
			logger.info("-accountid==" + accountid + "-userid==" + po.getUserid() + "-name==" + po.getName()
					+ "-department==" + po.getDepartment() + "-position==" + po.getPosition() + "-mobile"
					+ po.getMobile() + "-gender==" + po.getGender() + "-email==" + po.getEmail() + "-weixinid=="
					+ po.getWeixinid() + "-avatar_mediaid==" + po.getAvatar_mediaid() + "-extattr==" + po.getExtattr());
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/createEnterpriseUser.do", params,
					null, CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 修改企业成员
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result updateEnterpriseUser(String accountid, EnterpriseUser po) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != po) {
			if (null != accountid) {
				params.put("accountid", accountid);
			}
			if (null != po.getUserid()) {
				params.put("userid", po.getUserid());
			}
			if (null != po.getName()) {
				params.put("name", URLEncoder.encode(po.getName(), CHARSET));
			}
			if (null != po.getDepartment()) {
				int d = Integer.parseInt(po.getDepartment());
				params.put("department", d + "");
			}
			if (null != po.getPosition()) {
				// params.put("position", URLEncoder.encode(po.getPosition(),
				// WXConstants.CHARSET));
				params.put("position", "");
			}
			if (null != po.getMobile()) {
				params.put("mobile", po.getMobile());
			}
			if (null != po.getGender()) {
				params.put("gender", po.getGender());
			}
			if (null != po.getEmail()) {
				params.put("email", po.getEmail());
			}
			if (null != po.getWeixinid()) {
				params.put("weixinid", po.getWeixinid());
			}
			if (null != po.getEnable()) {
				params.put("enable", po.getEnable());
			}
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/updateEnterpriseUser.do", params,
					null, CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 删除企业成员
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result deleteEnterpriseUser(String accountid, String userid) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != userid) {
			params.put("accountid", accountid);
			params.put("userid", userid);
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/deleteEnterpriseUser.do", params,
					null, CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 批量删除企业成员
	 * 
	 * @author appl
	 * @throws IOException
	 */
	public Result deleteEnterpriseUserList(String accountid, List<String> userid) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		if (null != userid) {
			params.put("accountid", accountid);
			params.put("userid", JSONArray.fromObject(userid).toString());
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/deleteEnterpriseUserList.do", params,
					null, CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 获取成员
	 * 
	 * @throws IOException
	 */
	public EnterpriseUser getEnterpriseUser(String accountid, String userid) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		EnterpriseUser po = null;
		if (null != userid) {
			params.put("userid", userid);
			params.put("accountid", accountid);
			JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/getEnterpriseUser.do", params,
					null, CHARSET);
			if (result.getSuccess()) {
				po = new EnterpriseUser();
				JSONObject object = JSONObject.fromObject(result.getResult());
				po.setUserid(object.optString("userid"));
				po.setName(object.optString("name"));
				po.setDepartment(object.optString("department"));
				po.setPosition(object.optString("position"));
				po.setMobile(object.optString("mobile"));
				po.setGender(object.optString("gender"));
				po.setEmail(object.optString("email"));
				po.setWeixinid(object.optString("weixinid"));
				po.setAvatar(object.optString("avatar"));
				po.setStatus(object.optString("status"));
				po.setExtattr(object.optString("extattr"));

			}
		}
		return po;
	}

	/**
	 * 获取部门成员
	 * 
	 * @throws IOException
	 */
	public List<EnterpriseUser> getDepartmentMember(String accountid, String department_id, String fetch_child,
			String status) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		List<EnterpriseUser> eulist = new ArrayList<EnterpriseUser>();
		if (null != department_id && null != fetch_child && null != status) {
			params.put("accountid", accountid);
			params.put("department_id", department_id);
			params.put("fetch_child", fetch_child);
			params.put("status", status);
			JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/getDepartmentMember.do", params,
					null, CHARSET);
			if (result.getSuccess()) {
				JSONArray array = JSONArray.fromObject(result.getResult());
				for (int i = 0; i < array.size(); i++) {
					EnterpriseUser po = new EnterpriseUser();
					JSONObject object = array.optJSONObject(i);
					po.setUserid(object.optString("userid"));
					po.setName(object.optString("name"));
					po.setDepartment(object.optString("department"));
					po.setPosition(object.optString("position"));
					po.setMobile(object.optString("mobile"));
					po.setGender(object.optString("gender"));
					po.setEmail(object.optString("email"));
					po.setWeixinid(object.optString("weixinid"));
					po.setAvatar(object.optString("avatar"));
					po.setStatus(object.optString("status"));
					po.setExtattr(object.optString("extattr"));
					eulist.add(po);
				}
			}
		}
		return eulist;
	}

	/**
	 * 获取部门成员详情
	 * 
	 * @throws IOException
	 */
	public List<EnterpriseUser> getDepartmentMemberDetail(String accountid, String department_id, String fetch_child,
			String status) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		List<EnterpriseUser> eulist = new ArrayList<EnterpriseUser>();
		if (null != department_id && null != fetch_child && null != status) {
			params.put("accountid", accountid);
			params.put("department_id", department_id);
			params.put("fetch_child", fetch_child);
			params.put("status", status);
			JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/getDepartmentMemberDetail.do",
					params, null, CHARSET);
			if (result.getSuccess()) {
				JSONArray array = JSONArray.fromObject(result.getResult());
				for (int i = 0; i < array.size(); i++) {
					EnterpriseUser po = new EnterpriseUser();
					JSONObject object = array.optJSONObject(i);
					po.setUserid(object.optString("userid"));
					po.setName(object.optString("name"));
					po.setDepartment(object.optString("department"));
					po.setPosition(object.optString("position"));
					po.setMobile(object.optString("mobile"));
					po.setGender(object.optString("gender"));
					po.setEmail(object.optString("email"));
					po.setWeixinid(object.optString("weixinid"));
					po.setAvatar(object.optString("avatar"));
					po.setStatus(object.optString("status"));
					po.setExtattr(object.optString("extattr"));
					eulist.add(po);
				}
			}
		}
		return eulist;
	}
}
