package cn.sq.appinfo.service;

import javax.validation.constraints.Past;

import org.springframework.web.bind.annotation.PathVariable;

import cn.sq.appinfo.pojo.DevUser;

public interface DevUserService {
	
	DevUser login(String devName,String devPassword);
}
