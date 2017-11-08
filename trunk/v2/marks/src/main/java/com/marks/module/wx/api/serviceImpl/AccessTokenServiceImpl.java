package com.marks.module.wx.api.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.module.wx.api.dao.AccessTokenDao;
import com.marks.module.wx.api.service.AccessTokenService;
import com.marks.module.wx.api.wxInterface.mp.base.entity.AccessTokenVo;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
	
	@Autowired
	private AccessTokenDao accessTokenDao;
	
	public void saveOrUpdateAccessTokenVo(AccessTokenVo vo) {
		AccessTokenVo old=accessTokenDao.getAccessTokenVoByAccountid(vo.getAccountid());
		if(null !=old){
			accessTokenDao.updateAccessTokenVo(vo);
		}else{
			accessTokenDao.saveAccessTokenVo(vo);
		}
	}

	public AccessTokenVo getAccessTokenVoByAccountid(String accountid) {
		return accessTokenDao.getAccessTokenVoByAccountid(accountid);
	}
	
	

}
