package com.cjmei.module.autocode.core.util;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.autocode.core.produced.config.AutoConfig;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.webpage.html.htmlpage.HtmlPageProduced;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.service.SysMenuService;
import com.cjmei.module.system.sysrole.service.SysRoleService;

public class AuthUtil {
	private SysMenuService sysMenuService = (SysMenuService) DatabaseHelper.getBean(SysMenuService.class);
	private SysRoleService sysRoleService = (SysRoleService) DatabaseHelper.getBean(SysRoleService.class);
	private static AuthUtil util = null;

	private AuthUtil() {
	}

	public static AuthUtil getInstance() {
		if (util == null) {
			util = new AuthUtil();
		}
		return util;
	}
	
	// 授权
		public void addFuncForRole(AutoBean autoBean) {
			HtmlPageProduced html = new HtmlPageProduced();
			String autoBeanName = autoBean.getFactBeanName();
			String menuUrl = AutoConfig.FILE_Menu_SRC + autoBeanName.toLowerCase() + "/" + autoBeanName + "." + html.DEFAULT_FILE_HTML;
			String listurl = "/" + autoBeanName + "/list";
			String saveurl = "/" + autoBeanName + "/save";
			String updateurl = "/" + autoBeanName + "/update";
			String deleteurl = "/" + autoBeanName + "/delete";
			SysMenu smP = sysMenuService.getSysMenuByMenuid(autoBeanName+"_parentid");
			if (smP == null) {
				smP = new SysMenu();
				smP.setMenuid(autoBeanName+"_parentid");
				smP.setMenuitem(autoBean.getModuleDesc());
				smP.setParentid("0");
				smP.setSort(1);
				smP.setUrl("#");
				sysMenuService.save(smP);
				
				SysMenu sm = sysMenuService.getSysMenuByMenuid(autoBeanName);
				sm = new SysMenu();
				sm.setMenuid(autoBeanName);
				sm.setMenuitem(autoBean.getModuleDesc());
				sm.setParentid(autoBeanName+"_parentid");
				sm.setSort(1);
				sm.setUrl(menuUrl);

				sysMenuService.save(sm);
				SysOperate query = sysMenuService.saveFunc("query", sm.getMenuid(), listurl);
				SysOperate add = sysMenuService.saveFunc("add", sm.getMenuid(), saveurl);
				SysOperate update = sysMenuService.saveFunc("edit", sm.getMenuid(), updateurl);
				SysOperate delete = sysMenuService.saveFunc("delete", sm.getMenuid(), deleteurl);
				List<String> funcIds = new ArrayList<String>();
				funcIds.add(query.getFuncid());
				funcIds.add(add.getFuncid());
				funcIds.add(update.getFuncid());
				funcIds.add(delete.getFuncid());
				sysRoleService.addSysFuncByRoleId(AutoConfig.role_id, funcIds);
			}
		}
}
