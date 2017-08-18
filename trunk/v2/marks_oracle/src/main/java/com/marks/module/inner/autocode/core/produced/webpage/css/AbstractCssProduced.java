/**
 * File Name: cluster.scheme.autocode.webpage.css.AbstractCssProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年6月7日上午10:29:25
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.marks.module.inner.autocode.core.produced.webpage.css;

import com.marks.module.inner.autocode.core.produced.AbstractProduced;
import com.marks.module.inner.autocode.core.produced.pojo.AutoBean;
import com.marks.module.inner.autocode.core.produced.util.FileUtil;
import com.marks.module.inner.autocode.core.produced.util.StringUtil;

/**
 * File Name: cluster.scheme.autocode.webpage.css.AbstractCssProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年6月7日上午10:29:25
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public abstract class AbstractCssProduced extends AbstractProduced implements CssProduced {
    /**
     * 获取beanName名字
     */
    public String producedBeanName(AutoBean autoBean) {
        setFileSrc(autoBean);
        String beanName = StringUtil.getUpperCaseChar(autoBean.getFactBeanName());
        outFileContent.setFileName(StringUtil.StringJoin(StringUtil.getLowerCaseChar(beanName),getFileNameAfter(),DOT_VALUE,DEFAULT_FILE_CSS) );
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
        setFileSrc( FileUtil.getWebAppSrc() +autoBean.getParentPackage()+"/"+ getFileSrc(autoBean));
    }
    
    public abstract String getFileSrc(AutoBean autoBean);
}
