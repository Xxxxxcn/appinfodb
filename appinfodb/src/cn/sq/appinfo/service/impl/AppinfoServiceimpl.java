package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.AppinfoDao;
import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.service.AppinfoService;
import cn.sq.appinfo.tools.Page;

@Service
public class AppinfoServiceimpl implements AppinfoService {

	@Resource
	private AppinfoDao appinfoDao;

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

}
