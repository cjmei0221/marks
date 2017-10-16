package com.marks.common.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.system.sysmenu.pojo.SysOperate;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysuser.pojo.SysUser;

public class ButtonTag extends TagSupport{
	private static Logger logger = Logger.getLogger(ButtonTag.class);
	LoginService loginService=(LoginService) SpringContextHolder.getBean(LoginService.class);
	/**
	 * serialVersionUID:描述
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			SysUser user = ManageUtil.getCurrentUserInfo(request);
			String menuid=request.getParameter("menuid");
			if(user!=null){
				List<SysOperate> list=loginService.getSysOperate(menuid,user);
				if(null !=list && list.size()>0){
					StringBuffer html=new StringBuffer();
					String icon="icon-edit";
					String mod="";
					for(SysOperate so:list){
						if("query".equals(so.getOperid())){
							continue;
						}
						mod=so.getOperid();
						if("delete".equals(so.getOperid())){
							mod="del";
						}
						if(null !=so.getPicicon()){
							icon=so.getPicicon();	
						}
						html.append("<a id=\""+so.getOperid()+"\" href=\"javascript:void(0)\" onclick=\""+mod+"();\" class=\"easyui-linkbutton menuBtnCls\" data-options=\"iconCls:'"+icon+"'\">"+so.getOpername()+"</a>");
					}
					out.print(html.toString());
				}
			}
		} catch (IOException e) {
			logger.info("IOException",e);
		}
		return SKIP_BODY;
	}

	
}
