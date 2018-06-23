package com.marks.module.report.home.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marks.module.core.controller.SupportContorller;
import com.marks.module.report.home.service.HomeService;

@Controller
public class HomeController extends SupportContorller {
	private static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private HomeService homeService;
	@Override
	public Logger getLogger() {
		return logger;
	}

}
