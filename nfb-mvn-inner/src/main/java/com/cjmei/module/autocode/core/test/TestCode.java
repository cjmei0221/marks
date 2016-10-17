package com.cjmei.module.autocode.core.test;

import com.cjmei.module.autocode.core.produced.annotation.TableField;
import com.cjmei.module.autocode.core.produced.annotation.TableName;
import com.cjmei.module.autocode.core.produced.pojo.AttrType;

@TableName(value = "tb_testcode", desc = "测试代码")
public class TestCode {
	@TableField(value = "code", desc = "编码Code", dataType = AttrType.String, size = 50, ispk = true)
	private int code;
	@TableField(value = "name", desc = "名称", dataType = AttrType.String, size = 250)
	private String name;

	@TableField(value = "createtime", desc = "创建时间", dataType = AttrType.Timestamp, size = 50)
	private String createtime;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
