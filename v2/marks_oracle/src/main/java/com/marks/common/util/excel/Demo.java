package com.marks.common.util.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		exportExcel(); //将模拟数据导出到  D:/demo.xls
		exportExcelByTemplate(); //将模拟数据导出到  D:/demo4Template.xls
		System.out.println("Hello World");
	}
	
	public static void exportExcel(){
		
		List<List> sysUserList = new ArrayList<List>() ;
		for(int i=1;i<=5;i++) {
			//将导出数据转换成list格式，按head顺序放入list
			List<Object> item = new ArrayList<Object>();
			item.add(i+"");
			item.add("admin"+i);
			item.add("11111");
			item.add("8888");
			item.add(i+"");
			sysUserList.add(item);
		}
		
//---------------web程序---------------------
//		ExcelUtil.exportExcel(response,"test",new String[]{"用户账号","用户昵称","密码","用户手机号"},sysUserList);
//------------------------------------------
		
//---------------java程序--------------------
		OutputStream os=null;
		try {
			os = new FileOutputStream("D:/demo.xls");
			ExcelUtil.exportExcel(os,"test",new String[]{"用户账号","用户昵称","密码","用户手机号"},sysUserList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//------------------------------------------
		
	}

	public static void exportExcelByTemplate(){

		//模拟导出数据，正式数据可用实体类代替map
		List<Map<String,Object>> sysUserList = new ArrayList<Map<String,Object>>() ;
		for(int i=1;i<=5;i++) {
			Map<String,Object> itemMap = new HashMap<String,Object>();
			itemMap.put("account","admin"+i);
			itemMap.put("nickName","11111");
			itemMap.put("password","8888");
			itemMap.put("phone",i);
			sysUserList.add(itemMap);
		}

		Map<String,Object> beanParams = new HashMap<String,Object>(); //数据集
		beanParams.put("list", sysUserList);  //绑定数据，在模板中可用el表达式获取数据
		
//----------------web程序--------------------
//		String realPath = request.getSession().getServletContext().getRealPath("").replaceAll("\\\\","/") ; //获取项目在硬盘的位置
//		String mobanPath = realPath + "/WEB-INF/template/testTemplate.xls"; //导出模板路径
//		ExcelUtil.exportExcelByTemplate(response, beanParams, mobanPath, "testTemplate.xls");
//------------------------------------------
		
//----------------java程序------------------
		OutputStream os=null;
		try {
			os = new FileOutputStream("D:/demo4Template.xls");
			String mobanPath = System.getProperty("user.dir")+"/template/DemoTemplate.xls" ;
			ExcelUtil.exportExcelByTemplate(os, beanParams, mobanPath, "demo4Template.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//------------------------------------------
	}

}
