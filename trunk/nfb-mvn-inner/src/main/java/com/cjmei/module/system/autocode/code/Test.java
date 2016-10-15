package com.cjmei.module.system.autocode.code;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.system.autocode.DBProduced;
import com.cjmei.module.system.autocode.extern.ExternAutoCode;
import com.cjmei.module.system.autocode.factory.DefaultExternAutoBeanFactory;
import com.cjmei.module.system.autocode.pojo.AttrType;
import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.pojo.OutPutFileResult;
import com.cjmei.module.system.autocode.table.MySqlTableProduced;

public class Test {

	public static AutoBean getAutoBean() {
		AutoBean autoBean = new AutoBean();
		autoBean.setBeanName("AutoCode");
		autoBean.setModuleDesc("自动生成代码记录");
		autoBean.setTableName("tb_autocode_bean");
		// 包路径
		// autoBean.setDefaultPackageUrl("cluster.scheme.module.rbac.");
		List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
		AutoAttr autoAttr = new AutoAttr();
		AutoAttr autoAttr1 = new AutoAttr();
		AutoAttr autoAttr2 = new AutoAttr();
		// 属性设置
		autoAttr.setAttrName("tableName");
		autoAttr.setAttrDesc("表名称");
		autoAttr.setAttrType(AttrType.String);
		autoAttr.setAttrSize(50);
		// //表主键
		autoAttr.setPK(true);
		// autoAttr.setSeq("SYS_USERS_SEQ");//不设置则默认为uuid策略

		autoAttr1.setAttrName("beanName");
		autoAttr1.setAttrType(AttrType.String);
		autoAttr1.setAttrDesc("实体类名称");
		autoAttr1.setAttrSize(50);
		
		autoAttr2.setAttrName("moduleDesc");
		autoAttr2.setAttrType(AttrType.String);
		autoAttr2.setAttrDesc("实体类名称");
		autoAttr2.setAttrSize(1024);
		
		autoAttrs.add(autoAttr);
		autoAttrs.add(autoAttr1);
		autoAttrs.add(autoAttr2);
		autoBean.setAutoAttrs(autoAttrs);
		return autoBean;
	}

	public static void main(String[] args) {

		ExternAutoCode autoCode = new DefaultExternAutoBeanFactory().externAutoCodeBean();
		OutPutFileResult outFileResult = autoCode.autoProducedCode(getAutoBean(), true);

		System.out.println(outFileResult.getResultInfo());
		/*DBProduced dbutil = new MySqlTableProduced();
		dbutil.createTable(getAutoBean());*/
	}

}
