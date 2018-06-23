package com.marks.module.report.home.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.report.home.dao.HomeDao;
import com.marks.module.report.home.service.HomeService;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;
}
