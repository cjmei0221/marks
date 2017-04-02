package com.marks.module.autocode.core.produced.pojo;

import java.io.Serializable;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.marks.module.autocode.core.produced.backstagecode.CodeProduced;
import com.marks.module.autocode.core.produced.util.StringUtil;
import com.marks.module.autocode.core.produced.xml.XmlProduced;




/**
 * 生成bean的参数集合
 * @author ykai5
 *
 */
public class AutoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2327100603388257691L;
	
	/**
	 * table名字
	 */
	private String tableName;
	
	/**
	 * 实体名字（默认对应表名）
	 */
	private String beanName;
	
	/**
	 * packageName默认对应beanName 
	 * 包名（用户未定义取module.packageName.service
	 * 根据不同的mvc层对应不同的值，如service对应module.packageName.service
	 * control对应module.packageName.control
	 */
	private String packageName;
	
	private String controlName;
	//上级包名
	private String parentPackage;
	
	private String defaultPackageUrl;
	
	private String defaultDao;
	
	private String defaultPojo;
	
	private String defaultService;
	
	private String defaultController;
	
	private String defaultMapperXml;
	/**
	 * 实现类dao，service的后缀 默认为：Impl
	 */
	private String defaulImpl;
	
	private String defaultTableOtherName;
	
	private String moduleDesc;//模块名称：比如：商品
	
	private String description;//描述
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getDefaultTableOtherName() {
	    if(StringUtil.isNull(defaultTableOtherName)){
	        return this.getFactBeanName().toLowerCase();
	    }
        return defaultTableOtherName;
    }

    public void setDefaultTableOtherName(String defaultTableOtherName) {
        this.defaultTableOtherName = defaultTableOtherName;
    }

    public String getDefaultMapperXml() {
	    if(StringUtil.isNull(defaultMapperXml)){
	        return XmlProduced.DEFAULT_MAPPERXML;
	    }
        return defaultMapperXml;
    }

    public void setDefaultMapperXml(String defaultMapperXml) {
        this.defaultMapperXml = defaultMapperXml;
    }

    public String getDefaultController() {
	    if(StringUtil.isNull(defaultController)){
	        return CodeProduced.DEFAULT_CONTROLLER;
	    }
        return defaultController;
    }

    public void setDefaultController(String defaultController) {
        this.defaultController = defaultController;
    }

    public String getDefaultService() {
       if(StringUtil.isNull(defaulImpl)){
            return CodeProduced.DEFAULT_SERVICE;
       }
       return defaultService;
    }

    public void setDefaultService(String defaultService) {
        this.defaultService = defaultService;
    }

    public String getDefaultImpl() {
		if(StringUtil.isNull(defaulImpl))
			return CodeProduced.DEFAULT_IMPL;
		return defaulImpl;
	}

	public void setDefaultImpl(String defaulImpl) {
		this.defaulImpl = defaulImpl;
	}

	public String getDefaultPojo() {
		if(StringUtil.isNull(defaultPojo))
			return CodeProduced.DEFAULT_POJO;
		return defaultPojo;
	}

	public void setDefaultPojo(String defaultPojo) {
		this.defaultPojo = defaultPojo;
	}

	public String getDefaultDao() {
		if(StringUtil.isNull(defaultDao))
			return CodeProduced.DEFAULT_DAO;
		return defaultDao;
	}

	public void setDefaultDao(String defaultDao) {
		this.defaultDao = defaultDao;
	}
	
	

	public String getDefaultPackageUrl() {
		if(StringUtil.isNull(defaultPackageUrl))
			return CodeProduced.DEFAULT_PACKAGE_URL+this.getParentPackage()+".";
		return defaultPackageUrl;
	}

	public void setDefaultPackageUrl(String defaultPackageUrl) {
		this.defaultPackageUrl = defaultPackageUrl;
	}

	private List<AutoAttr> autoAttrs;
	
	/**
	 * 获取实际的beanName
	 * @return
	 */
	public String getFactBeanName(){
		nullChomd(this);
		if(!StringUtil.isNull(this.getBeanName()))
			return StringUtil.getLowerCaseChar(this.getBeanName());
		return StringUtil.getLowerCaseChar(this.getTableName());
	}
	
	public String getFactTableName(){
		nullChomd(this);
		if(!StringUtil.isNull(this.getTableName()))
			return this.getTableName();
		return this.getBeanName();
	}
	
	/**
	 * 获取实际的packageName
	 */
	public String getFactPackageName(){
		nullChomd(this);
		if(!StringUtil.isNull(this.getPackageName()))
			return this.getPackageName().toLowerCase();
		return this.getFactBeanName().toLowerCase();
	}
	
	public String getFactControllerName(){
		nullChomd(this);
		if(!StringUtil.isNull(this.getControlName()))
			return this.getControlName();
		return CodeProduced.DEFAULT_CONTROLLER;
	}
	
	public void nullChomd(AutoBean autoBean){
		if(autoBean == null)
			throw new RuntimeErrorException(null, "autoBean 不能为空");
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<AutoAttr> getAutoAttrs() {
		return autoAttrs;
	}

	public void setAutoAttrs(List<AutoAttr> autoAttrs) {
		this.autoAttrs = autoAttrs;
	}

	public String getControlName() {
		return controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public String getParentPackage() {
		return parentPackage==null?"cell":parentPackage;
	}

	public void setParentPackage(String parentPackage) {
		this.parentPackage = parentPackage;
	}

	
}
