package com.marks.module.note.diary.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.note.diary.dao.DiaryDao;
import com.marks.module.note.diary.pojo.Diary;
import com.marks.module.note.diary.service.DiaryService;
import com.marks.module.wx.modulemsg.pojo.ModuleMsg;
import com.marks.module.wx.modulemsg.pojo.WxMsg;
import com.marks.module.wx.modulemsg.service.ModuleMsgService;
import com.marks.module.wx.wxtemplate.dao.WxTemplateDao;
import com.marks.module.wx.wxtemplate.pojo.WxTemplate;
import com.marks.module.wx.wxuser.pojo.WxUser;

public class DiaryServiceImpl implements DiaryService{
	private static Logger logger = Logger.getLogger(DiaryServiceImpl.class);
	private WxTemplateDao wxTemplateDao;
    private DiaryDao diaryDao;
    private ModuleMsgService moduleMsgService;
    public DiaryDao getDiaryDao(){
        return diaryDao;
    }
    public void setDiaryDao(DiaryDao diaryDao){
        this.diaryDao =diaryDao;
    }
    public void setWxTemplateDao(WxTemplateDao wxTemplateDao) {
		this.wxTemplateDao = wxTemplateDao;
	}

    @Override
	public void pushDairyWxMsg(WxUser wxUser) {

		List<String> openidList = new ArrayList<String>();
		openidList.add(wxUser.getOpenid());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String note = sdf.format(new Date());
		List<String> keywordList = new ArrayList<String>();
		keywordList.add(wxUser.getNickname());
		keywordList.add(sdf.format(new Date()));

		pushModuleMsgByParams(wxUser.getAccountid(), "wxtemplate_dairy", openidList, keywordList, note);

	}
    public Result pushModuleMsgByParams(String accountid, String tempType, List<String> openidList,
			List<String> keywordList, String note) {

		Result result = new Result();
		if (null != openidList && openidList.size() > 0) {

			WxTemplate temp = wxTemplateDao.findById(tempType, accountid);
			if (null != temp) {
				for (String openid : openidList) {

					String firstMsg = temp.getFirst_content();
					String remarkMsg = temp.getRemark_content();
					String detailUrl=temp.getDetailUrl();
					WxMsg wxMsg = new WxMsg();
					wxMsg.setFirst(firstMsg);
					wxMsg.setRemark(remarkMsg);
					wxMsg.setKeywordList(keywordList);

					ModuleMsg mmsg = new ModuleMsg();
					mmsg.setAccountid(accountid);
					mmsg.setCreatetime(new Date());
					mmsg.setData(wxMsg.toJsonString());	
					mmsg.setNote(note+" "+ temp.getTemplate_name());
					mmsg.setTemplate_id(temp.getTemplate_id());
					mmsg.setTouser(openid);
					mmsg.setUrl(detailUrl);
					moduleMsgService.pustModuleMsg(mmsg, false);
				}
			} else {
				result.setCode("4002");
				result.setMessage("模板不存在");
				logger.info("模板不存在");
			}
		} else {
			logger.info("openid 为空");
		}

		return result;
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
	
}