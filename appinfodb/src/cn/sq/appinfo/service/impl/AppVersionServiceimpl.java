package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import cn.sq.appinfo.dao.AppVersionDao;
import cn.sq.appinfo.dao.AppinfoDao;
import cn.sq.appinfo.pojo.AppVersion;
import cn.sq.appinfo.service.AppVersionService;

@Service
public class AppVersionServiceimpl implements AppVersionService{

	@Resource
	private AppVersionDao avd;
	
	@Resource
	private AppinfoDao apps;
	@Override
	public AppVersion getAppVersion(Integer id) {
		return avd.getAppVersion(id);
	}
	@Override
	public List<AppVersion> getAppVersionappId(Integer appId) {
		return avd.getAppVersionappId(appId);
	}
	@Override
	public boolean InsertAppVersion(AppVersion appVersion) {
		boolean flag = false;
		Integer versionId = null;
		if (avd.InsertAppVersion(appVersion)> 0) {
			versionId = appVersion.getId();
			flag = true;
		}
		if (apps.updateVersionId(versionId, appVersion.getAppId()) > 0 && flag) {		
			flag = true;
		}
		return flag;
	}
	@Override
	public Integer Deleteapk(Integer appId) {
		return avd.Deleteapk(appId);
	}
	@Override
	public boolean UpdateAppversion(AppVersion appVersion) {
		return avd.UpdateAppversion(appVersion)>0;
	}
		
}
