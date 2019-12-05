package cn.sq.appinfo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.AppVersionDao;
import cn.sq.appinfo.dao.AppinfoDao;
import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.pojo.AppVersion;
import cn.sq.appinfo.service.AppinfoService;
import cn.sq.appinfo.tools.Page;

@Service
public class AppinfoServiceimpl implements AppinfoService {

	@Resource
	private AppinfoDao appinfoDao;
	
	@Resource
	private AppVersionDao appVersionDao;

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer pageInex,Integer pageSize) {
		return appinfoDao.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId,pageInex,pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId) {
		return appinfoDao.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2,queryCategoryLevel3, queryFlatformId, devId);
	}

	@Override
	public Integer AddAppInfo(AppInfo appInfo) {
		return appinfoDao.InsertAppInfo(appInfo);
	}

	@Override
	public AppInfo getAppinfoIdandAPKName(Integer id, String APKName) {
		return appinfoDao.getAppinfoIdandAPKName(id, APKName);
	}

	@Override
	public boolean updateStatus(Integer id, Integer status) {
		return appinfoDao.updateAppinfoStatu(id, status) > 0;
	}

	@Override
	public boolean DeleteAppinfoById(Integer id) {
		return appinfoDao.DeleteAppinfoById(id)>0;
	}

	@Override
	public Integer UpdateAppinfo(AppInfo appInfo) {
		return appinfoDao.UpdateAppinfo(appInfo);
	}

	@Override
	public boolean DeleteLogo(Integer id) {
		boolean falg = false;
			if(appinfoDao.DeleteAppinfoById(id)>0 && appVersionDao.DeleteAppversion(id)>0) {
				falg = true;
			}
		return falg;
	}

	@Override
	public boolean UpdateAppinfoStatus(AppInfo appInfo) {
		AppInfo appInfo2 = appinfoDao.getAppinfoIdandAPKName(appInfo.getId(), null);
		AppVersion appVersion = new AppVersion();
		AppInfo appInfo1 = new AppInfo();
		switch (appInfo2.getStatus()) {
		case 2:			
			appVersion.setId(appInfo.getVersionId());
			appVersion.setPublishStatus(2);	
			appVersion.setModifyDate(new Date());
			appVersionDao.UpdateAppversion(appVersion);
			appInfo1.setId(appInfo.getId());
			appInfo1.setModifyDate(new Date());
			appInfo1.setStatus(4);
			appinfoDao.UpdateAppinfo(appInfo1);
			break;
		case 4:
			appVersion.setId(appInfo.getVersionId());
			appVersion.setPublishStatus(2);	
			appVersion.setModifyDate(new Date());
			appVersionDao.UpdateAppversion(appVersion);
			appInfo1.setId(appInfo.getId());
			appInfo1.setModifyDate(new Date());
			appInfo1.setStatus(5);
			appinfoDao.UpdateAppinfo(appInfo1);
			break;
		case 5:
			appInfo1.setId(appInfo.getId());
			appInfo1.setModifyDate(new Date());
			appInfo1.setStatus(4);
			appinfoDao.UpdateAppinfo(appInfo1);
			break;
		default:
			return false;
		}
		return true;
	}
}
