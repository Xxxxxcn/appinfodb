package cn.sq.appinfo.tools;

import java.util.UUID;

public class DIUU {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
