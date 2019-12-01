package cn.sq.appinfo.service;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.AppVersion;

public interface AppVersionService {
	
	public AppVersion getAppVersion(Integer id);
}
