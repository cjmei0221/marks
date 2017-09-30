package com.marks.module.vip.coupon.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.vip.coupon.pojo.VipCoupon;
import com.marks.module.vip.coupon.dao.VipCouponDao;
import com.marks.module.vip.coupon.service.VipCouponService;

@Service
@Transactional
public class VipCouponServiceImpl implements VipCouponService{

	@Autowired
	private VipCouponDao vipCouponDao;
   
/**
    private VipCouponDao vipCouponDao;

    public VipCouponDao getVipCouponDao(){
        return vipCouponDao;
    }
    public void setVipCouponDao(VipCouponDao vipCouponDao){
        this.vipCouponDao =vipCouponDao;
    }

 */   
    /**
    *根据ID查找会员优惠券
    */
    @Override
    public VipCoupon findById(String idNo){
        return vipCouponDao.findById(idNo);
    }
    
    /**
    *保存会员优惠券
    */
    @Override
    public void save(VipCoupon vipCoupon){
        vipCouponDao.save(vipCoupon);
    }
    
    /**
    *更新会员优惠券
    */
    @Override
    public void update(VipCoupon vipCoupon){
        vipCouponDao.update(vipCoupon);
    }
    
    /**
    *删除会员优惠券
    */
    @Override
    public void delete(String idNo){
        vipCouponDao.delete(idNo);       
    }
    
    /**
    *查找所有会员优惠券
    */
    @Override
    public List<VipCoupon> findAll(){
        return vipCouponDao.findAll();   
    }
    
    /**
    *删除多个会员优惠券
    */
    @Override
   public void deleteBatch(List<String> ids) {
		vipCouponDao.deleteBatch(ids);
	}
	
	public PojoDomain<VipCoupon> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<VipCoupon> pojoDomain = new PojoDomain<VipCoupon>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<VipCoupon> list = vipCouponDao.list(pageBounds,param);
		PageList<VipCoupon> pageList = (PageList<VipCoupon>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}