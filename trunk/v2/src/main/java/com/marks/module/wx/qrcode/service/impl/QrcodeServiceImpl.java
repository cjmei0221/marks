package com.marks.module.wx.qrcode.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.marks.module.wx.qrcode.pojo.Qrcode;
import com.marks.module.wx.qrcode.dao.QrcodeDao;
import com.marks.module.wx.qrcode.service.QrcodeService;

public class QrcodeServiceImpl implements QrcodeService{
   

    private QrcodeDao qrcodeDao;

    public QrcodeDao getQrcodeDao(){
        return qrcodeDao;
    }
    public void setQrcodeDao(QrcodeDao qrcodeDao){
        this.qrcodeDao =qrcodeDao;
    }

    
    /**
    *根据ID查找二维码管理
    */
    @Override
    public Qrcode findById(String qrNo){
        return qrcodeDao.findById(qrNo);
    }
    
    /**
    *保存二维码管理
    */
    @Override
    public void save(Qrcode qrcode){
        qrcodeDao.save(qrcode);
    }
    
    /**
    *更新二维码管理
    */
    @Override
    public void update(Qrcode qrcode){
        qrcodeDao.update(qrcode);
    }
    
    /**
    *删除二维码管理
    */
    @Override
    public void delete(String qrNo){
        qrcodeDao.delete(qrNo);       
    }
    
    /**
    *查找所有二维码管理
    */
    @Override
    public List<Qrcode> findAll(){
        return qrcodeDao.findAll();   
    }
    
    /**
    *删除多个二维码管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		qrcodeDao.deleteBatch(ids);
	}
	
	public PojoDomain<Qrcode> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Qrcode> pojoDomain = new PojoDomain<Qrcode>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Qrcode> list = qrcodeDao.list(pageBounds,param);
		PageList<Qrcode> pageList = (PageList<Qrcode>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public Qrcode findByQrNo(String qrNo,String accountid) {
		 return qrcodeDao.findByQrNo(qrNo,accountid);
	}
	
}