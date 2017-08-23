package com.marks.module.inner.note.gains.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.module.inner.note.diary.pojo.Diary;
import com.marks.module.inner.note.gains.dao.GainsDao;
import com.marks.module.inner.note.gains.pojo.Gains;
import com.marks.module.inner.note.gains.service.GainsService;
import com.marks.module.inner.note.util.NoteConstants;
import com.marks.module.inner.system.upload.util.FTPUtil;

@Service
public class GainsServiceImpl implements GainsService{
   
	@Autowired
    private GainsDao gainsDao;

    public GainsDao getGainsDao(){
        return gainsDao;
    }
    public void setGainsDao(GainsDao gainsDao){
        this.gainsDao =gainsDao;
    }

    
    /**
    *根据ID查找心得记录
    */
    @Override
    public Gains findById(String id){
        return gainsDao.findById(id);
    }
    
    /**
    *保存心得记录
    */
    @Override
    public void save(Gains gains){
        gainsDao.save(gains);
    }
    
    /**
    *更新心得记录
    */
    @Override
    public void update(Gains gains){
        gainsDao.update(gains);
    }
    
    /**
    *删除心得记录
    */
    @Override
    public void delete(String id){
        gainsDao.delete(id);       
    }
    
    /**
    *查找所有心得记录
    */
    @Override
    public List<Gains> findAll(){
        return gainsDao.findAll();   
    }
    
    /**
    *删除多个心得记录
    */
    @Override
   public void deleteBatch(List<String> ids) {
		gainsDao.deleteBatch(ids);
	}
	
	public PojoDomain<Gains> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Gains> pojoDomain = new PojoDomain<Gains>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Gains> list = gainsDao.list(pageBounds,param);
		PageList<Gains> pageList = (PageList<Gains>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public Gains findByTitle(String title) {
		return gainsDao.findByTitle(title);
	}
	@Override
	public String exportTxt(Map<String, Object> param, String basePath) {
		PageBounds pageBounds = new PageBounds(1, 100000);
		List<Gains> list = gainsDao.list(pageBounds, param);
		String fileName="gains_"+IDUtil.getTimeID()+".txt";
		FileOutputStream fos=null;
		PrintWriter pw=null;
		String filePath=null;
		try {
			File file = new File(basePath+fileName);
			if (!file.exists()) {
				file.createNewFile();
				fos = new FileOutputStream(file);
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos,NoteConstants.charaterSet)));
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {	
					Gains info=list.get(i);
//					sb.append(System.getProperty("line.separator"));
					//写入文件
					sb.append("===========================================");
					sb.append(System.getProperty("line.separator"));
					sb.append(info.getTitle());
					sb.append(System.getProperty("line.separator"));
					sb.append(System.getProperty("line.separator"));
					sb.append(DateUtil.formatDate(info.getCreatetime(), "yyyy-MM-dd HH:mm:ss")+" - "+info.getLvlName()+" - "+info.getLabels());
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