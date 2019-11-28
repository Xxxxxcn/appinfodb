package cn.sq.appinfo.dao;

import javax.validation.constraints.Past;

import cn.sq.appinfo.pojo.BackendUser;

public interface BackendUserDao {
	
	BackendUser getBackendUserNameAanPwd(@Past String devName,@Past String devPassword);
}
