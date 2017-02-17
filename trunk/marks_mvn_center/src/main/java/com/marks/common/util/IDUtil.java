package com.marks.common.util;

import java.util.UUID;


public class IDUtil {
	
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString().replace("-", "").toUpperCase();
		return id;
	}
	
}
