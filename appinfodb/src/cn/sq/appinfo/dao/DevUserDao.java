package cn.sq.appinfo.dao;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.DevUser;

public interface DevUserDao {	
	
	DevUser getDevUserNameAanPwd(@Param("devCode") String devCode,@Param("devPassword") String devPassword);
}
