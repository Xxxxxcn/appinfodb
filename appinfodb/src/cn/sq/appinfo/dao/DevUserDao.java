package cn.sq.appinfo.dao;

import javax.validation.constraints.Past;

import cn.sq.appinfo.pojo.DevUser;

public interface DevUserDao {	
	
	DevUser getDevUserNameAanPwd(@Past String devName,@Past String devPassword);
}
