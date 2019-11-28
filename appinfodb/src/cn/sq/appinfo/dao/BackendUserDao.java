package cn.sq.appinfo.dao;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.BackendUser;

public interface BackendUserDao {
	
	BackendUser getBackendUserNameAanPwd(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
}
