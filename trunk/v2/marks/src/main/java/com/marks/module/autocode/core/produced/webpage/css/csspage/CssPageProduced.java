
package com.marks.module.autocode.core.produced.webpage.css.csspage;

import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.produced.util.StringUtil;
import com.marks.module.autocode.core.produced.webpage.css.AbstractCssProduced;

/**
 * File Name: cluster.scheme.autocode.webpage.css.CssPageProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年6月7日上午10:33:17
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public class CssPageProduced extends AbstractCssProduced {

    /**
     * 
     * @see cluster.scheme.autocode.webpage.css.AbstractCssProduced#getFileSrc(cluster.scheme.autocode.pojo.AutoBean)
     */
    @Override
    public String getFileSrc(AutoBean autoBean) {
        String cssRoot = StringUtil.StringJoin(autoBean.getFactBeanName().toLowerCase(),
                DOT_VALUE,DEFAULT_FILE_CSS);
        return cssRoot;
    }

    /**
     * 
     * @see cluster.scheme.autocode.AbstractProduced#getFileNameAfter()
     */
    @Override
    public String getFileNameAfter() {
        // TODO Auto-generated method stub
        return "";
    }

}
