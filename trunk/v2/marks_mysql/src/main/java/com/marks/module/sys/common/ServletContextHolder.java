package com.marks.module.sys.common;
import java.io.File;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class ServletContextHolder implements ServletContextAware {

	private static ServletContext servletCtx;

	public void setServletContext(ServletContext servletContext) {
		ServletContextHolder.servletCtx = servletContext;
	}

	public static String getServletContextPath() {
		return servletCtx.getRealPath(File.separator);
	}
	
	public static InputStream getResourceAsStream(String path) {
		return servletCtx.getResourceAsStream(path);
	}
}
