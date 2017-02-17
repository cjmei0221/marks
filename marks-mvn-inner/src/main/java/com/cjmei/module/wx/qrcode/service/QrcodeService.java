package com.cjmei.module.wx.qrcode.service;


import com.cjmei.module.wx.qrcode.pojo.Qrcode;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface QrcodeService{

	public Qrcode findById(String qrNo);
	public void save(Qrcode qrcode);
	public void update(Qrcode qrcode);
	public void delete(String qrNo);
	public List<Qrcode> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Qrcode> list(int page_number, int page_size,Map<String,Object> param);
	public Qrcode findByQrNo(String qrNo,String accountid);
}