package com.marks.module.core.filter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
//定义具有缓存功能response
public class HttpCharacterResponseWrapper extends HttpServletResponseWrapper {
 //定义字符数组
 private CharArrayWriter cw = new CharArrayWriter();
 
 public HttpCharacterResponseWrapper(HttpServletResponse response) {
  super(response);
 }

 @Override
 public PrintWriter getWriter() throws IOException {
  return new PrintWriter(cw);
 }

 public CharArrayWriter getCw() {
  return cw;
 }

}