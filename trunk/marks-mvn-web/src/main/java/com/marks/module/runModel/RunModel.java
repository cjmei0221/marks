package com.marks.module.runModel;

import com.marks.common.util.properties.PropsUtil;

public class RunModel
{
  private String run_mode = PropsUtil.getProperty("runModul");//与行方对接 N：测试 Y:对接
  private String weixin_mode = PropsUtil.getProperty("weixinMode");//与微信对接 N：测试 Y:对接
  private String run_companyId = PropsUtil.getProperty("run_companyId");//与微信对接 N：测试 Y:对接
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
  
  public String getCompanyId() {
		return run_companyId;
	}
}