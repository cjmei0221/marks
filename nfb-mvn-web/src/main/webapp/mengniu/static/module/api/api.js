define([], function(){

    var exports = {

        getWxSign: '/js/config.do', //获取微信签名

        getGoodList: '/products/getProductList.do', //获取商品列表接口
        
        getGoodDetail: '/getGoodDetail.do', //获取商品详细信息

        waitInStock: '/waitForStockIn.do', //待入库

        waitInStockForFive: '/waitForStockInOfDmz.do', //待入库 5

        waitOutStock: '/waitForStockOut.do', //待出库

        waitCheckStock: '/waitForCheckStock.do', //待盘点

        waitReturnStock: '/waitForReturnProduct.do', //待退库

        getWaitListStock: '/waitListForStock.do', //获取待确认列表

        stockIn: '/stockIn.do', //确认入库

        stockOut: '/stockOut.do', //确认出库

        checkStock: '/checkStock.do', //确认盘点

        returnProduct: '/returnProduct.do', //确认退库

        nextScanSNQR: '/nextScanSNQR.do', //接着扫

        clearWaitList: '/clearWaitListForStock.do', //清空待确认列表

        submitOrder: '/order/submitOrder.do', //提交订单

        getOrderList: '/order/queryOrderList.do', //获取订单列表

        cancelOrder: '/order/cancelOrder.do', //取消订单

        confirmGet: '/order/endOrder.do', //确认收货

        getOrderDetail: '/order/getOrderDetail.do', //获取订单详情

        sendMessage: '/account/sendMessage.do', //获取手机验证码

        bindMember: '/StoreInfo/bindMember.do', //绑定会员店铺

        register: '/memberInfo/register.do', //注册

        getMemberList: '/query/memberList.do', //获取会员列表

        getProductBaseInfoByPnNo : '/point/getProductBaseInfoByPnNo.do',//根据产品PN码获取产品待积分详情

        customerGetPoint : '/point/customerGetPoint.do',//用户获取积分

        getStockList: '/StockLog/query.do', //获取库存记录列表

        getNowStockList: '/Store/currentStock.do', //获取当前库存列表

        getStockDetailList: '/Product/currentStock/detail.do', //获取当前库存详细列表

        getShopList: '/StoreInfo/list.do', //获取门店列表

        confirmOrder: '/orderInfo/aduit.do', //确认订单

        getNotAuditList: '/orderAduit/orderInfoList.do', //未确认订单列表

        getAuditedList: '/orderAduit/list.do', //获取已确认列表

        unionPay: '/unionpay/pay.do', //银联支付接口

        aliPay: '/alipay/payHtml.do', //支付宝支付接口

        wxPay: '/WXPay/preorder.do', //微信支付接口

        getGuiderInfo: '/query/shopGuider.do', //获取导购信息

        getSalesmanWorkbench: '/SalesMan/workBench.do', //获取业务员工作台信息

        setPassword: '/returnBonusStoreAcc/updatePassword.do', //设置提现密码

        userInfo: '/login/getUserInfo.do', //获取用户信息

        getBalance: '/returnBonusStoreAcc/queryAcc.do', //查询个人余额

        getWirhdrawList: '/returnBonusSetting/queryCashDetail.do', //获取提现记录

        toWithdraw: '/returnBonusStoreAcc/cashReturnBonus.do', //提现

        getRebateList: '/returnBonusSetting/queryReturnBonusDetail.do', //获取返利列表

        getCostList: '/chargePool/storeGetChargeRecordInfo.do', //获取费用返利列表

        downWxImg: '/js/media.do', //下载微信图片

        getTotalCost: '/chargePool/getChargePoolByPartnerId.do', //获取费用池总数

        getApplyCostRecord: '/chargePool/partnerGetChargeGetBaseInfoList.do', //获取申请费用记录

        partnerGetShop: '/chargePool/partnerGetStore.do', //合伙人获取店铺

        costWays: '/chargePool/getChargeUseWay.do', //获取费用用途

        submitCost: '/chargePool/partnerSubmitCharge.do', //提交费用申请

        costPoolList: '/chargePool/partnerGetChargePoolGetRecord.do', //资金来源

        getNoApprovalList: '/chargePool/getProvinceUncheckWithDrawRecord.do', //获取费用未审批列表

        getApprovaledList: '/chargePool/getProvinceHaveCheckWithDrawRecord.do', //获取费用已审批列表

        getApprovalDetail: '/chargePool/getWithDrawRecord.do', //获取费用审批详情

        toApproval: '/chargePool/provinceCheck.do', //省负责人审核

        getLinkageAddress: '/SysAddress/list.do', //获取联动地址

        bindUserInfo: '/WeChat/userInfo.do', //绑定---获取用户信息

        getOrderNum: '/order/getOrderCount.do', //获取订单数量

        getNoAuditNum: '/orderAduit/countOrdersByNeedToAduit.do', //获取未确认订单数量

        submitApplyStore: '/StoreInfo/save.do', //提交门店申请

        saveBankCardInfo: '/bankCardInfo/save.do', //保存银行卡信息

        applyPartner: '/PartnerInfo/save.do', //申请合伙人

        getBankCardInfo: '/BandCardInfo/query.do', //获取银行卡信息

        submitFreeOrder: '/order/payForFreeOrder.do', //提交免费订单

        bindTipsPartnerInfo: '/afterBinding/partner.do', //店主绑定成功后查询合伙人信息

        principalGetStoreList: '/Province/getStoreList.do', //省负责人获取门店列表

        isDoExam: '/Partner/isExamAndPass.do', //是否参加过考试

        saveExamResult: '/Partner/ExamResultSave.do', //保存考试结果

        delWaitConfirm: '/deleteWaitStatus.do', //删除当个待确认产品

        hasAreaCode: '/isExist/sysBusUnit.do', //是否存在区域编号

        hasPartner: '/isExist/partnerInfo.do', //是否存在合伙人

        recognizancePay: '/WXPay/prestoredeposit.do', //支付保证金

        getAllZoneList: '/getSysBusUnitList/ByParentId.do', //获取所有地区

        getZoneNodeList: '/getPriorSysBusUnitList/ById.do', //获取地区节点列表

        /*jzl*/



        /*lzs*/
        customerSign: '/point/customerSign.do',//会员签到 
        
        getUserPoint: '/point/getUserPoint.do',//获取会员积分账号

        confirmCustomerInfo: '/point/confirmCustomerInfo.do',//校验会员信息

        submitPointApplication: '/point/submitPointApplication.do',//店主或导购提交积分申请

        getAllProductBaseInfoByPnNoList: '/point/getAllProductBaseInfoByPnNoList.do',//根据PN_NO List获取所有产品积分信息

        binding_account : '/account/binding.do',//绑定会员

        binding_peopleManage : '/PeopleManage/binding.do',//绑定店长

        getMemberInfo: '/MemberInfo/query.do', //获取会员信息

        saveMemberInfo: '/memberInfo/modify.do', //保存会员信息

        getExchangeGoodList: '/exchange/getProductList.do', //获取兑换商品列表

        memberToExchange: '/exchange/toExchange.do', //会员兑换商品

        getExchangeLogList: '/exchange/getExchangeList.do', //获取兑换记录列表

        getIntegralLogList: '/point/customerGetPointGetRecord.do', //获取积分记录列表

        queryShopInfo: '/StoreInfo/query.do', //查询店铺信息

        getNotStoreAuditList: '/storeInfoAduit/list.do', //获取未审核门店列表

        toAuditStore: '/storeInfoAduit/aduit.do', //门店审核

        getStoreAuditedList: '/storeInfoAduit/storeAduitLoglist.do', //获取已确认门店列表

        getStoreInfo: '/StoreRelateInfo/query.do', //获取门店信息

        verifyIntegral: '/point/checkPoint.do', //验证积分

        queryLogistics: '/order/getExpressInfoList.do', //查询物流信息

        submitSubIntegral: '/point/otherManGetPoint.do', //提交积分

    };

    return exports;

});