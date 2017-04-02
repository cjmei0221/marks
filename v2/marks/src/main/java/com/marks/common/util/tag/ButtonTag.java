package com.marks.common.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.marks.module.system.core.helper.SysUserHelper;
import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.system.sys.pojo.SysOperate;
import com.marks.module.system.sys.service.LoginService;
import com.marks.module.system.sysuser.pojo.SysUser;

public class ButtonTag extends TagSupport{
	private static Logger logger = Logger.getLogger(ButtonTag.class);
	LoginService loginService=(LoginService) DatabaseHelper.getBean(LoginService.class);
	/**
	 * serialVersionUID:描述
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			SysUser user=SysUserHelper.getCurrentUserInfo(request);
			String menuid=request.getParameter("menuid");
			if(user!=null){
				List<SysOperate> list=loginService.getSysOperate(menuid,user);
				if(null !=list && list.size()>0){
					StringBuffer html=new StringBuffer();
					String icon="icon-edit";
					for(SysOperate so:list){
						if("query".equals(so.getOperid())){
							continue;
						}
						if(null !=so.getPicicon()){
							icon=so.getPicicon();	
						}
						html.append("<a id=\""+so.getOperid()+"\" href=\"javascript:void(0)\" class=\"easyui-linkbutton menuBtnCls\" data-options=\"iconCls:'"+icon+"'\">"+so.getOpername()+"</a>");
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
