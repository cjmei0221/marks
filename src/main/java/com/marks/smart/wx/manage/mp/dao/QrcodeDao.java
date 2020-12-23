package com.marks.smart.wx.manage.mp.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.wx.manage.mp.entity.Qrcode;

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