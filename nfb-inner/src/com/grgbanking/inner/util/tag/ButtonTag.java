package com.grgbanking.inner.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.grgbanking.inner.helper.SysUserHelper;
import com.grgbanking.inner.listener.DatabaseHelper;
import com.grgbanking.inner.po.sys.SysOperate;
import com.grgbanking.inner.po.sys.SysUser;
import com.grgbanking.inner.service.LoginService;

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
						if("query".equals(so.getOperkey())){
							continue;
						}
						if(null !=so.getPicicon()){
							icon=so.getPicicon();	
						}
						html.append("<a id=\""+so.getOperkey()+"\" href=\"javascript:void(0)\" class=\"easyui-linkbutton menuBtnCls\" data-options=\"iconCls:'"+icon+"'\">"+so.getOpername()+"</a>");
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
