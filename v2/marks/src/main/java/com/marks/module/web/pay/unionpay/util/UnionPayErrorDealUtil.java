package com.marks.module.web.pay.unionpay.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.common.util.Constants;
import com.marks.module.sys.system.core.listener.DatabaseHelper;
import com.marks.module.web.pay.unionpay.dao.UnionPayDao;
import com.marks.module.web.pay.unionpay.pojo.UnionPayLog;
import com.marks.module.web.pay.unionpay.thread.pool.PayThreadPool;


/**
 * 定时读取银联交易报文表，看是否有交易异常的数据（做了交易，但没收到银联通知返回报文），并做相应处理
 * @author zqsheng
 * @createtime 2015.04.17
 */
public class UnionPayErrorDealUtil extends QuartzJobBean{
	
	private static final Logger log = Logger.getLogger(UnionPayErrorDealUtil.class);
	
	private UnionPayDao unionPayDao;
	public void doJob(){
		log.info("定时[读取银联交易报文表]开始");
		try {
			unionPayDao = (UnionPayDao)DatabaseHelper.getBean(UnionPayDao.class);
			findUnionPayError();
		} catch (Exception e) {
			log.info("Exception:",e);
		}
		log.info("定时[读取银联交易报文表]结束");
	}
	
	/**
	 * 查找银联交易没通知返回结果的报文数据
	 */
	private void findUnionPayError(){
		List<UnionPayLog> eMsgList = unionPayDao.queryErrorMsg();	
		if(eMsgList != null && eMsgList.size()>0) {
			for(UnionPayLog msg : eMsgList) {
				if(!"wap".equals(msg.getReqReserved())) {
					continue;
				}
				log.info("存在发起银联交易却没返回通知的报文，交易场景：消费支付，交易订单号："+msg.getOrderId()+",订单时间:"+msg.getTxnTime());
				//调银联交易状态查询接口查询该交易状态
				Map<String, String> lastPayMsg = UnionPay_Wap.deal_query(msg.getOrderId(), msg.getTxnTime());
				if("00".equals(lastPayMsg.get("respCode"))) { //00-查询成功
					msg.setQueryId(lastPayMsg.get("queryId"));
					msg.setRespCode(lastPayMsg.get("origRespCode"));
					msg.setRespMsg(lastPayMsg.get("origRespMsg"));
					msg.setSettleAmt(lastPayMsg.get("settleAmt"));
					msg.setSettleDate(lastPayMsg.get("settleDate"));
					msg.setTraceNo(lastPayMsg.get("traceNo"));
					msg.setTraceTime(lastPayMsg.get("traceTime"));
					msg.setAccNo(lastPayMsg.get("accNo"));
					msg.setStatus("1");
					//被查询的交易是成功的，则补充之前没有完成的业务
					if("00".equals( lastPayMsg.get("origRespCode"))) {
						/**---------业务处理--------**/
						if("01".equals(msg.getTxnType())) { //交易类型 01-消费(支付)
							if("wap".equals(msg.getReqReserved())) {//手机端wap支付
								log.info("手机端-wap支付成功后-业务处理...");
								
							}
						}
					}
					unionPayDao.updateUnionPayLog(msg);
				} else { //respCode为34-查无交易
					msg.setStatus("1");
					msg.setRespCode(lastPayMsg.get("respCode"));
					msg.setRespMsg(lastPayMsg.get("respMsg"));
					unionPayDao.updateUnionPayLog(msg);
				} 
			}
		}
    }

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}
	
}


