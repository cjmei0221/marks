package com.marks.module.autocode.web.util;

import java.util.ArrayList;
import java.util.List;

import com.marks.module.autocode.core.produced.config.AutoConfig;
import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.produced.webpage.html.htmlpage.HtmlPageProduced;
import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.system.sysmenu.pojo.SysMenu;
import com.marks.module.system.sysmenu.pojo.SysOperate;
import com.marks.module.system.sysmenu.service.SysMenuService;
import com.marks.module.user.sysrole.service.SysRoleService;

public class AuthUtil {
	private SysMenuService sysMenuService = (SysMenuService) SpringContextHolder.getBean(SysMenuService.class);
	private SysRoleService sysRoleService = (SysRoleService) SpringContextHolder.getBean(SysRoleService.class);
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
		String menuUrl = AutoConfig.config_menu_src + autoBean.getParentPackage().replace(".", "/") + "/" + autoBeanName
				+ "." + html.DEFAULT_FILE_HTML;
		String listurl = "/inner/" + autoBeanName + "/list";
		String saveurl = "/inner/" + autoBeanName + "/save";
		String updateurl = "/inner/" + autoBeanName + "/update";
		String deleteurl = "/inner/" + autoBeanName + "/delete";
		String[] arr = autoBean.getParentPackage().split("\\.");
		String lvl1Menuid = "M_" + arr[0];
		String lvl2Menuid = "M_" + arr[0] + arr[1];
		String menuId = lvl2Menuid + "_" + autoBeanName;
		SysMenu smP = sysMenuService.getSysMenuByMenuid(lvl1Menuid);

		if (smP == null) {
			smP = new SysMenu();
			smP.setMenuid(lvl1Menuid);
			smP.setMenuitem(autoBean.getModuleDesc());
			smP.setParentid("0");
			smP.setSort(12);
			smP.setUrl("#");
			sysMenuService.save(smP);
		}
		SysMenu smP2 = sysMenuService.getSysMenuByMenuid(lvl2Menuid);
		if (smP2 == null) {
			smP = new SysMenu();
			smP.setMenuid(lvl2Menuid);
			smP.setMenuitem(autoBean.getModuleDesc());
			smP.setParentid(lvl1Menuid);
			smP.setLvl1Menuid(lvl1Menuid);
			smP.setSort(12);
			smP.setUrl("#");
			sysMenuService.save(smP);
		}
		SysMenu sm = sysMenuService.getSysMenuByMenuid(menuId);
		if (sm == null) {
			sm = new SysMenu();
			sm.setMenuid(menuId);
			sm.setMenuitem(autoBean.getModuleDesc());
			sm.setParentid(lvl2Menuid);
			sm.setLvl1Menuid(lvl1Menuid);
			sm.setLvl2Menuid(lvl2Menuid);
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
