package com.cjmei.module.autocode.util;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.autocode.core.config.AutoConfig;
import com.cjmei.module.autocode.core.pojo.AutoBean;
import com.cjmei.module.autocode.core.webpage.html.htmlpage.HtmlPageProduced;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.service.SysMenuService;
import com.cjmei.module.system.sys.service.SysRoleService;

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
			SysMenu sm = sysMenuService.getSysMenuByMenuid(autoBeanName);
			if (sm == null) {
				sm = new SysMenu();
				sm.setMenuid(autoBeanName);
				sm.setMenuitem(autoBean.getModuleDesc());
				sm.setParentid("1");
				sm.setSort(20);
				sm.setUrl(menuUrl);

				sysMenuService.save(sm);;
				SysOperate query = sysMenuService.saveFunc("1", sm.getMenuid(), listurl);
				SysOperate add = sysMenuService.saveFunc("3", sm.getMenuid(), saveurl);
				SysOperate update = sysMenuService.saveFunc("2", sm.getMenuid(), updateurl);
				SysOperate delete = sysMenuService.saveFunc("EE0C0A4FCD224862BEA0F1A68BD20B5A", sm.getMenuid(), deleteurl);
				List<String> funcIds = new ArrayList<String>();
				funcIds.add(query.getFuncid());
				funcIds.add(add.getFuncid());
				funcIds.add(update.getFuncid());
				funcIds.add(delete.getFuncid());
				sysRoleService.addSysFuncByRoleId("20160801150615276", funcIds);
			}
		}
}
