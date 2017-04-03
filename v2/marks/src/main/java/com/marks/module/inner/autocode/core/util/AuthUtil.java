package com.marks.module.inner.autocode.core.util;

import java.util.ArrayList;
import java.util.List;

import com.marks.module.inner.autocode.core.produced.config.AutoConfig;
import com.marks.module.inner.autocode.core.produced.pojo.AutoBean;
import com.marks.module.inner.autocode.core.produced.webpage.html.htmlpage.HtmlPageProduced;
import com.marks.module.inner.system.sys.pojo.SysMenu;
import com.marks.module.inner.system.sys.pojo.SysOperate;
import com.marks.module.inner.system.sys.service.SysMenuService;
import com.marks.module.inner.system.sysrole.service.SysRoleService;
import com.marks.module.sys.system.core.listener.DatabaseHelper;

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
			String menuUrl = AutoConfig.config_menu_src+autoBean.getParentPackage()+"/"+ autoBeanName.toLowerCase() + "/" + autoBeanName + "." + html.DEFAULT_FILE_HTML;
			String listurl = "/" + autoBeanName + "/list";
			String saveurl = "/" + autoBeanName + "/save";
			String updateurl = "/" + autoBeanName + "/update";
			String deleteurl = "/" + autoBeanName + "/delete";
			SysMenu smP = sysMenuService.getSysMenuByMenuid(autoBean.getParentPackage());
			if (smP == null) {
				smP = new SysMenu();
				smP.setMenuid(autoBean.getParentPackage());
				smP.setMenuitem(autoBean.getModuleDesc());
				smP.setParentid("0");
				smP.setSort(1);
				smP.setUrl("#");
				sysMenuService.save(smP);
			}
			SysMenu sm = sysMenuService.getSysMenuByMenuid(autoBeanName);
			if(sm==null){
				sm = new SysMenu();
				sm.setMenuid(autoBeanName);
				sm.setMenuitem(autoBean.getModuleDesc());
				sm.setParentid(autoBean.getParentPackage());
				sm.setSort(100);
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
