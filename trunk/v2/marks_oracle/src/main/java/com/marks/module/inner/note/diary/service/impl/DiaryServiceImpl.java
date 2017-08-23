package com.marks.module.inner.note.diary.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.module.center.wxfwhao.common.entity.WxUser;
import com.marks.module.inner.note.diary.dao.DiaryDao;
import com.marks.module.inner.note.diary.pojo.Diary;
import com.marks.module.inner.note.diary.service.DiaryService;
import com.marks.module.inner.system.upload.util.FTPUtil;
import com.marks.module.inner.wx.modulemsg.util.WxMsgUtil;
@Service
public class DiaryServiceImpl implements DiaryService{
	private static Logger logger = Logger.getLogger(DiaryServiceImpl.class);
	@Autowired
    private DiaryDao diaryDao;
   
    @Override
	public void pushDairyWxMsg(WxUser wxUser) {

		List<String> openidList = new ArrayList<String>();
		openidList.add(wxUser.getOpenid());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String note = sdf.format(new Date());
		List<String> keywordList = new ArrayList<String>();
		keywordList.add(wxUser.getNickname());
		keywordList.add(sdf.format(new Date()));
		WxMsgUtil.getInstance().pushModuleMsgByKeywordList(false,wxUser.getAccountid(), "wxtemplate_dairy", openidList, keywordList, note,null);

	}
    /**
    *根据ID查找我的日记
    */
    @Override
    public Diary findById(String ID){
        return diaryDao.findById(ID);
    }
    
    /**
    *保存我的日记
    */
    @Override
    public void save(Diary diary){
        diaryDao.save(diary);
    }
    
    /**
    *更新我的日记
    */
    @Override
    public void update(Diary diary){
        diaryDao.update(diary);
    }
    
    /**
    *删除我的日记
    */
    @Override
    public void delete(String ID){
        diaryDao.delete(ID);       
    }
    
    /**
    *查找所有我的日记
    */
    @Override
    public List<Diary> findAll(){
        return diaryDao.findAll();   
    }
    
    /**
    *删除多个我的日记
    */
    @Override
   public void deleteBatch(List<String> ids) {
		diaryDao.deleteBatch(ids);
	}
	
	public PojoDomain<Diary> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Diary> pojoDomain = new PojoDomain<Diary>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Diary> list = diaryDao.list(pageBounds,param);
		PageList<Diary> pageList = (PageList<Diary>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public String exportTxt(Map<String, Object> param, String basePath) {
		PageBounds pageBounds = new PageBounds(1, 100000);
		List<Diary> list = diaryDao.list(pageBounds, param);
		String fileName="diary_"+IDUtil.getTimeID()+".txt";
		FileOutputStream fos=null;
		PrintWriter pw=null;
		String filePath=null;
		try {
			File file = new File(basePath+fileName);
			if (!file.exists()) {
				file.createNewFile();
				fos = new FileOutputStream(file);
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos,"gbk")));
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {	
					Diary info=list.get(i);
//					sb.append(System.getProperty("line.separator"));
					//写入文件
					sb.append("===========================================");
					sb.append(System.getProperty("line.separator"));
					sb.append(DateUtil.formatDate(info.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
					sb.append(System.getProperty("line.separator"));
					sb.append(System.getProperty("line.separator"));
					sb.append(info.getTitle());
					sb.append(System.getProperty("line.separator"));
					sb.append("---------------------");
					sb.append(System.getProperty("line.separator"));
					sb.append(info.getContent());
					sb.append(System.getProperty("line.separator"));
					sb.append(System.getProperty("line.separator"));
				}
				pw.write(sb.toString());
				pw.flush();
				filePath= FTPUtil.ftp_url+fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pw !=null){
				pw.close();
			}
		}
		return filePath;
	}
	
}