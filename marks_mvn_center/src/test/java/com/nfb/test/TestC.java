package com.nfb.test;

import org.junit.Test;

public class TestC {

	private WxFwUtil util = WxFwUtil.getInstance();

	/*@Test
	public void getUserInfo() throws Exception {
		WxUser user=util.getUserInfo("wxbank", "oDkf1so5GFsBZW5SzzJpn3-nLSUY");
		System.out.println(user.getOpenid());
		System.out.println(user.getAccountid());
		System.out.println(user.getCity());
		System.out.println(user.getCountry());
		System.out.println(user.getGroupid());
		System.out.println(user.getImageurl());
		System.out.println(user.getIssubscribe());
		System.out.println(user.getLanguage());
		System.out.println(user.getNickname());
		System.out.println(user.getProvince());
		System.out.println(user.getRemark());
		System.out.println(user.getSex());
		System.out.println(user.getTagid_list());
		System.out.println(user.getUnionid());

	}*/

	/*@Test
	public void sendCustomTextMsg() throws Exception {
		Result result=util.sendCustomTextMsg("wxbank", "oDkf1so5GFsBZW5SzzJpn3-nLSU","哈啊哈是的发送到发送到");
		System.out.println(result.getCode() +"-"+result.getMessage());
	}*/

	
	/*@Test
	public void createQrcode() throws Exception {
		String ticket=util.createQrcode("wxbank", 0, 25000, 1212121);
		System.out.println(ticket);
	}*/
	/*@Test
	public void getWXUserOpenId() throws Exception {
		UserGet ticket=util.getWXUserOpenId("wxbank", "");
		System.out.println(ticket.getNext_openid());
	}*/
	/*@Test
	public void pushMessage() throws Exception {
		 ModuleMsg mm = new ModuleMsg();
		 mm.setAccountid("wxbank");
		 mm.setTemplate_id("H3IsxJ9dnHJ0t_AC-paploqF586frGpcLMDa1CYop5w");
		 mm.setTouser("oDkf1so5GFsBZW5SzzJpn3-nLSUY");
			String url="";
			mm.setUrl(url);
			Msg first = new Msg();
			String weihao = "24135234523452345";
			weihao = weihao.substring(weihao.length()-4, weihao.length());
			first.setValue("您的尾号为"+weihao+"的账户有变动了哦！");
			Msg keynote1 = new Msg();
			//"交易时间："+
			keynote1.setValue("sdgsdfgsdfgs ");
			Msg keynote2 = new Msg();
			//"交易类型"+
			String jylx = "asdxcvadfasd";
			
			keynote2.setValue(jylx);
			Msg keynote3 = new Msg();
			//"交易金额："+
			String str3=" asfdasd元";
			
			keynote3.setValue(str3);
			Msg remark = new Msg();
			String remarkStr="asdfasdfas";
			remark.setValue(remarkStr);
			remark.setColor("#1111EE");	
			ModuleContentMsg mcm = new ModuleContentMsg();
			mcm.setFirstmsg(first);
			mcm.addKeyword(keynote1);
			mcm.addKeyword(keynote2);
			mcm.addKeyword(keynote3);
			mcm.setRemarkmsg(remark);		
			mm.setData(mcm.toJsonString());
		Result ticket=util.pushMessage( mm);
		System.out.println(ticket.getCode()+ticket.getMessage());
	}*/

	@Test
	public void getJsSDKTicket() throws Exception {
		
		String ticket=util.getJsSDKTicket("wxbank");
		System.out.println(ticket);
	}

}
