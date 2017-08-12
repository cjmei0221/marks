package com.marks.module.center.wxfwhao.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.module.center.wxfwhao.common.dao.AccessTokenDao;
import com.marks.module.center.wxfwhao.common.entity.AccessTokenVo;
import com.marks.module.center.wxfwhao.common.service.AccessTokenService;

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
