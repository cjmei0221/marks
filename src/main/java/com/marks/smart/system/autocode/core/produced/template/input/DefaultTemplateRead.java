package com.marks.smart.system.autocode.core.produced.template.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.management.RuntimeErrorException;

/**
 * 读取文件
 * @author ykai5
 *
 */
public class DefaultTemplateRead implements TemplateInput {

	private Reader reader;

	public StringBuffer readTemplate(File templateFile) {
		
		StringBuffer sBuffer = new StringBuffer();
		try {
			InputStream in = new FileInputStream(templateFile);
			reader = new InputStreamReader(in);
			int tempchar;
			while((tempchar=reader.read())!=-1){
				sBuffer.append((char)tempchar);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeErrorException(null, "找不到文件！");
		} catch (IOException e) {
			throw new RuntimeErrorException(null, "文件读取失败！");
		}

		return sBuffer;
	}
	
	public static void main(String[] args) {
		String fileSrc = System.getProperty("user.dir");
		File file = new File("D:\\workspace\\clusterScheme\\src\\main\\resources\\local\\template\\daoInterface.template");
		StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
		System.out.println(sBuffer);
	}

}
