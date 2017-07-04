package com.marks.module.inner.supermarket.smgoodinfo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.module.inner.supermarket.smgoodinfo.dao.SmGoodInfoDao;
import com.marks.module.inner.supermarket.smgoodinfo.pojo.SmGoodInfo;
import com.marks.module.inner.supermarket.smgoodinfo.service.SmGoodInfoService;
import com.marks.module.inner.system.sysuser.pojo.SysUser;

public class SmGoodInfoServiceImpl implements SmGoodInfoService {
	private static final Logger logger = Logger.getLogger(SmGoodInfoServiceImpl.class);
	private SmGoodInfoDao smGoodInfoDao;

	public SmGoodInfoDao getSmGoodInfoDao() {
		return smGoodInfoDao;
	}

	public void setSmGoodInfoDao(SmGoodInfoDao smGoodInfoDao) {
		this.smGoodInfoDao = smGoodInfoDao;
	}

	/**
	 * 根据ID查找超市商品
	 */
	@Override
	public SmGoodInfo findById(String goodId) {
		return smGoodInfoDao.findById(goodId);
	}

	/**
	 * 保存超市商品
	 */
	@Override
	public void save(SmGoodInfo smGoodInfo) {
		smGoodInfoDao.save(smGoodInfo);
	}

	/**
	 * 更新超市商品
	 */
	@Override
	public void update(SmGoodInfo smGoodInfo) {
		smGoodInfoDao.update(smGoodInfo);
	}

	/**
	 * 删除超市商品
	 */
	@Override
	public void delete(String goodId) {
		smGoodInfoDao.delete(goodId);
	}

	/**
	 * 查找所有超市商品
	 */
	@Override
	public List<SmGoodInfo> findAll() {
		return smGoodInfoDao.findAll();
	}

	/**
	 * 删除多个超市商品
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		smGoodInfoDao.deleteBatch(ids);
	}

	public PojoDomain<SmGoodInfo> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<SmGoodInfo> pojoDomain = new PojoDomain<SmGoodInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SmGoodInfo> list = smGoodInfoDao.list(pageBounds, param);
		PageList<SmGoodInfo> pageList = (PageList<SmGoodInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public SmGoodInfo findByskuAndOrgId(String companyId, String barCode) {
		return smGoodInfoDao.findByskuAndOrgId(companyId, barCode);
	}

	@Override
	public Result uploadExcel(String path, SysUser admin) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		try {
			StringBuffer sb=new StringBuffer();
			// 声明一个工作薄
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File(path)));
			// 读取第一页,一般一个excel文件会有三个工作表，这里获取第一个工作表来进行操作
			HSSFSheet sheet = wb.getSheetAt(0);
			// 循环遍历表sheet.getLastRowNum()是获取一个表最后一条记录的记录号，
			// 如果总共有3条记录，那获取到的最后记录号就为2，因为是从0开始的
			SmGoodInfo info=null;
			for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
				info=new SmGoodInfo();
				// 创建一个行对象
				HSSFRow row = sheet.getRow(j);
				info.setGoodId("S"+IDUtil.getUUID());
				String sku=row.getCell(0)==null?null:row.getCell(0).getRichStringCellValue().getString();
				if(sku !=null &&sku.length()>4){
					info.setSku_num(sku);
					info.setGoodName(row.getCell(1)==null?"":row.getCell(1).getRichStringCellValue().getString());
					double price=row.getCell(2)==null?0:row.getCell(2).getNumericCellValue();
					info.setGoodPrice((int)price*100);
					info.setUnit(row.getCell(3)==null?"":row.getCell(3).getRichStringCellValue().getString());
					info.setRemark(row.getCell(4)==null?"":row.getCell(4).getRichStringCellValue().getString());
					info.setCreator(admin.getUsername());
					info.setOrgid(admin.getCompanyNo());
					info.setUpdator(admin.getUsername());
					int count=smGoodInfoDao.updateByExcel(info);
					if(count<1){
						smGoodInfoDao.save(info);
					}
				}else{
					logger.info("第"+(j+1)+"行条形码长度小于6<br>");
					sb.append("第"+(j+1)+"行条形码长度小于6<br>");
					continue;
				}
			}
			if(sb.toString().length()>4){
				result.setCode("2001");
				result.setMessage(sb.toString());
			}
			
		} catch (Exception e) {
			logger.error("uploadExcel", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("解析异常");
		}
		return result;

	}

}