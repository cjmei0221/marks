package com.marks.smart.count.acct.ext.service;

import com.marks.common.domain.Result;
import com.marks.smart.count.acct.ext.pojo.PointLog;
import com.marks.smart.count.acct.ext.pojo.TranLog;

public interface AcctService {

	public Result savePoint(PointLog log);

	public Result saveAmt(TranLog log);
}
