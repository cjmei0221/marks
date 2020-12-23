package com.marks.smart.system.core.config;

import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.smart.system.autocode.core.produced.util.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    String[] encryptArr = {"jdbc.user", "jdbc.password"};
    private String key = "qwerdftgkuyo";

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        try {
            if (encryptArr.length > 0) {
                for (String str : encryptArr) {
                    String val = props.getProperty(str);
                    if(StringUtils.isNotEmpty(val)){
                        props.setProperty(str, EncryptUtil.decryptByKey(val, key));
                    }
                }
            }
            super.processProperties(beanFactoryToProcess, props);
        } catch (Exception e) {

        }
    }
}
