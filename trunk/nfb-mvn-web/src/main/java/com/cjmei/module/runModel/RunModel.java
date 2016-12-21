package com.cjmei.module.runModel;

import com.cjmei.common.util.properties.PropsUtil;

public class RunModel
{
  private String run_mode = PropsUtil.getProperty("runModul");//与行方对接 N：测试 Y:对接
  private String weixin_mode = PropsUtil.getProperty("weixinMode");//与微信对接 N：测试 Y:对接
  private static RunModel util = null;

  public static RunModel getInstance() {
    if (util == null) {
      util = new RunModel();
    }
    return util; }

  public String getMode() {
    return this.run_mode; }

  public String getWeixinMode() {
    return this.weixin_mode;
  }
}