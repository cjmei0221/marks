package com.marks.module.wx.manage.base.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.manage.base.pojo.Qrcode;

@MapperScan
public interface QrcodeDao {

	Qrcode findById(@Param("id") String id);

	void save(Qrcode qrcode);

	void update(Qrcode qrcode);

	void delete(@Param("id") String id);

	List<Qrcode> findAll();

	void deleteBatch(List<String> list);

	List<Qrcode> list(PageBounds pageBounds, Map<String,Object> param);

	Qrcode findByQrNo(@Param("qrNo")String qrNo,@Param("accountid")String accountid);
}