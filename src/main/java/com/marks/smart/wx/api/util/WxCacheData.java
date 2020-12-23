package com.marks.smart.wx.api.util;

import java.util.HashMap;
import java.util.Map;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.wx.api.mp.service.AccessTokenService;
import com.marks.smart.wx.api.mp.wxInteface.base.entity.AccessTokenVo;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.WxfwConfig;

public class WxCacheData {
	private static final long expires_in = 6900 * 1000;
	private static Map<String, AccessTokenVo> accesstoken_map = new HashMap<String, AccessTokenVo>();
	private AccessTokenService accessTokenService = (AccessTokenService) SpringContextHolder
			.getBean(AccessTokenService.class);
	private long updateflag = 0;
	private static WxCacheData util = null;

	private WxCacheData() {
	};

	public static WxCacheData getInstance() {
		if (util == null) {
			util = new WxCacheData();
		}
		return util;
	}

	public AccessTokenVo getAccessToken(String accountid) {
		AccessTokenVo vo = null;
		if ("Y".equals(WxfwConfig.access_token_share_flag)
				&& System.currentTimeMillis() - updateflag > 3000) {
			if ("Y".equals(WxfwConfig.access_token_db_flag)) {
				try {
					if (null == accessTokenService) {
						accessTokenService = (AccessTokenService) SpringContextHolder.getBean(AccessTokenService.class);
					}
					vo = accessTokenService.getAccessTokenVoByAccountid(accountid);

				} catch (Exception e) {
					vo = accesstoken_map.get(accountid);
				}
			} else {
				// 使用redis或者memcache缓存
				// vo=MemcachedUtil.getInstance().getACCESS_TOKEN(accountid);
				vo = accesstoken_map.get(accountid);
			}
		} else {
			vo = accesstoken_map.get(accountid);
		}
		if (null != vo) {
			long nowtime = System.currentTimeMillis();
			long time = Long.parseLong(vo.getPuttime());
			if ((nowtime - time) > expires_in) {
				return null;
			}
		}
		return vo;
	}

	public void putAccessToken(AccessTokenVo vo) {
		updateflag = System.currentTimeMillis();
		vo.setPuttime(updateflag+"");
		accesstoken_map.put(vo.getAccountid(), vo);
		try {
			if (null == accessTokenService) {
				accessTokenService = (AccessTokenService) SpringContextHolder.getBean(AccessTokenService.class);
			}
			accessTokenService.saveOrUpdateAccessTokenVo(vo);
			// MemcachedUtil.getInstance().putACCESS_TOKEN(vo.getAccesstoken(),
			// vo,Long.parseLong(vo.getExpires_in()));
		} catch (Exception e) {

		}
	}
}
