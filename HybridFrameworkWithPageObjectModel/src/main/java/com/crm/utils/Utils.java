package com.crm.utils;

import com.crm.base.Base;

public class Utils extends Base{

	public static int PAGE_LOAD_TIMEOUT=15;
	public static int IMPLICITLY_WAIT=20;
	
	public static void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
}
