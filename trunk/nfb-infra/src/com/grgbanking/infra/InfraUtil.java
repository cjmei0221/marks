package com.grgbanking.infra;

import com.grgbanking.infra.service.InfraService;
import com.grgbanking.infra.service.impl.InfraServiceImpl;

public class InfraUtil {
	
	public static InfraService getInstance(){
		return InfraServiceImpl.getInstance();
	}
	
}
