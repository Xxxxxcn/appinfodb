package cn.sq.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.AppVersion;

public interface AppVersionService {
	
	public AppVersion getAppVersion(Integer id);
	
	public List<AppVersion> getAppVersionappId(Integer appId);
	
	public boolean InsertAppVersion(AppVersion appVersion);
	
	public Integer Deleteapk(Integer appId);
	
	public boolean UpdateAppversion(AppVersion appVersion);
}
