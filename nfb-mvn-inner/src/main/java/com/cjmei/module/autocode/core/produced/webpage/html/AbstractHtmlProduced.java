/**
 * File Name: cluster.scheme.autocode.webpage.AbstractWebProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年6月6日下午4:21:34
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.cjmei.module.autocode.core.produced.webpage.html;

import com.cjmei.module.autocode.core.produced.AbstractProduced;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.util.FileUtil;
import com.cjmei.module.autocode.core.produced.util.StringUtil;

/**
 * File Name: cluster.scheme.autocode.webpage.AbstractWebProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年6月6日下午4:21:34
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public abstract class AbstractHtmlProduced extends AbstractProduced implements HtmlProduced{

    /**
     * 获取beanName名字
     */
    public String producedBeanName(AutoBean autoBean) {
        //TODO 注入方式
        setFileSrc(autoBean);
        String beanName = StringUtil.getUpperCaseChar(autoBean.getFactBeanName());
        outFileContent.setFileName(StringUtil.StringJoin(StringUtil.getLowerCaseChar(beanName),getFileNameAfter(),DOT_VALUE,DEFAULT_FILE_HTML) );
        return beanName;
    }
    
    /**
     * 把路径set到outFileContent
     * @param outFileContent
     * @param sBuffer：包名（需处理成路径方式）
     */
    public void setFileSrc(String fileSrc){
        outFileContent.setFileSrc(fileSrc.replace(DOT_VALUE, BACK_SLANT));
    }
    
    public void setFileSrc(AutoBean autoBean){
        setFileSrc(FileUtil.getWebAppSrc() +autoBean.getParentPackage()+"/"+ getFileSrc(autoBean));
    }
    
    public abstract String getFileSrc(AutoBean autoBean);
    
}
