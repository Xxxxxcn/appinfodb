package cn.sq.appinfo.dao;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.AppVersion;

public interface AppVersionDao {
	
	public AppVersion getAppVersion(@Param("id")Integer id);
}
