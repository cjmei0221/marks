package com.marks.module.autocode.core.util;

import java.util.ArrayList;
import java.util.List;

import com.marks.module.autocode.core.produced.config.AutoConfig;
import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.produced.webpage.html.htmlpage.HtmlPageProduced;
import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.system.sys.pojo.SysMenu;
import com.marks.module.system.sys.pojo.SysOperate;
import com.marks.module.system.sys.service.SysMenuService;
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
		String parentId = "parent_" + autoBean.getParentPackage();
		String menuId = autoBean.getParentPackage() + "_" + autoBeanName;
		SysMenu smP = sysMenuService.getSysMenuByMenuid(parentId);

		if (smP == null) {
			smP = new SysMenu();
			smP.setMenuid(parentId);
			smP.setMenuitem(autoBean.getModuleDesc());
			smP.setParentid("0");
			smP.setSort(1);
			smP.setUrl("#");
			sysMenuService.save(smP);
		}
		SysMenu sm = sysMenuService.getSysMenuByMenuid(menuId);
		if (sm == null) {
			sm = new SysMenu();
			sm.setMenuid(menuId);
			sm.setMenuitem(autoBean.getModuleDesc());
			sm.setParentid(parentId);
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
