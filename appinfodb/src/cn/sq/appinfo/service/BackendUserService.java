package cn.sq.appinfo.service;

import cn.sq.appinfo.pojo.BackendUser;

public interface BackendUserService {
	
	BackendUser login(String name,String pwd);
}
