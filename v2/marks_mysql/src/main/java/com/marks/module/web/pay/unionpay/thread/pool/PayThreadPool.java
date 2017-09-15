package com.marks.module.web.pay.unionpay.thread.pool;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.marks.module.sys.common.SpringContextHolder;
import com.marks.module.web.pay.unionpay.dao.UnionPayDao;
import com.marks.module.web.pay.unionpay.pojo.UnionPayLog;

public class PayThreadPool {
	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(10);// 开10个线程
	}

	public static void destroy() {
		pool.shutdown();
	}

	/**
	 * 银联支付日志记录
	 */
	public static void saveUnionPayLog(Map<String, String> valideData, String status) {
		pool.execute(new SaveUnionPayLogThread(valideData, status));
	}
}





/**
 * 保存银联返回的通知报文信息线程类
 * 
 * @author zqsheng
 * @createTime 2015-04-16
 */
class SaveUnionPayLogThread extends Thread {
	private Logger logger = Logger.getLogger(SaveUnionPayLogThread.class);
	private UnionPayDao unionPayDao = (UnionPayDao) SpringContextHolder.getBean(UnionPayDao.class);
	private Map<String, String> valideData;
	private String status;

	public SaveUnionPayLogThread(Map<String, String> valideData, String status) {
		super();
		this.valideData = valideData;
		this.status = status;
	}

	public void run() {
		try {
			logger.info("保存银联交易报文.......");
			UnionPayLog unionPayMsg = new UnionPayLog();
			unionPayMsg.setTxnType(valideData.get("txnType"));// 交易类型
			unionPayMsg.setTxnSubType(valideData.get("txnSubType"));// 交易子类型
			unionPayMsg.setBizType(valideData.get("bizType"));// 业务类型
			unionPayMsg.setMerId(valideData.get("merId"));// 商户号码
			unionPayMsg.setOrderId(valideData.get("orderId"));// 订单号
			unionPayMsg.setTxnTime(valideData.get("txnTime"));// 订单发送时间
			unionPayMsg.setTxnAmt(valideData.get("txnAmt"));// 交易金额 ,单位(分)
			unionPayMsg.setQueryId(valideData.get("queryId"));// 交易查询流水号，供后续查询用
			unionPayMsg.setRespCode(valideData.get("respCode"));// 响应码
			unionPayMsg.setRespMsg(valideData.get("respMsg"));// 响应信息
			unionPayMsg.setSettleAmt(valideData.get("settleAmt"));// 清算金币
			unionPayMsg.setSettleDate(valideData.get("settleDate"));// 清算日期
			unionPayMsg.setTraceNo(valideData.get("traceNo"));// 系统跟踪号
			unionPayMsg.setTraceTime(valideData.get("traceTime"));// 交易传输时间
			unionPayMsg.setAccNo(valideData.get("accNo"));// 账号
			unionPayMsg.setCustomerNm(valideData.get("customerNm"));// 卡号姓名
			unionPayMsg.setChannelType(valideData.get("channelType"));// 渠道类型
																		// 07-互联网;08-手机
			unionPayMsg.setReqReserved(valideData.get("reqReserved"));// 请求方保留域，交易应答时会原样返回
			unionPayMsg.setStatus(status);// 已交易,排查状态 0： 待排查
											// 1：已排查；对于没有返回码的报文需要排查。
			// unionPayDao.saveUnionPayMsg(unionPayMsg);
			UnionPayLog payMsg = unionPayDao.getUnionPayLogByOrderId(unionPayMsg.getOrderId());
			if (payMsg == null) {
				unionPayDao.saveUnionPayLog(unionPayMsg);
			} else {
				unionPayDao.updateUnionPayLog(unionPayMsg);
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
	}
}
