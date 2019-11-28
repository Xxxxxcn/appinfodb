package cn.sq.appinfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.BackendUserDao;
import cn.sq.appinfo.pojo.BackendUser;
import cn.sq.appinfo.service.BackendUserService;

@Service
public class BackendUserServiceimpl implements BackendUserService{
	
	@Resource
	private BackendUserDao bu;
	
	@Override
	public BackendUser login(String name, String pwd) {
		return bu.getBackendUserNameAanPwd(name, pwd);
	}

}
