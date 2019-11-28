package cn.sq.appinfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.DevUserDao;
import cn.sq.appinfo.pojo.DevUser;
import cn.sq.appinfo.service.DevUserService;

@Service
public class DevUserServiceimpl implements DevUserService {

	@Resource
	private DevUserDao ud;
	
	@Override
	public DevUser login(String devName, String devPassword) {
		return ud.getDevUserNameAanPwd(devName, devPassword);
	}

}
