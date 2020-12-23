package com.marks.smart.wx.api.mp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.smart.wx.api.mp.dao.AccessTokenDao;
import com.marks.smart.wx.api.mp.service.AccessTokenService;
import com.marks.smart.wx.api.mp.wxInteface.base.entity.AccessTokenVo;

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
