package cn.sq.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.tools.Page;

public interface AppinfoService {

	//按条件查询
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer pageInex,Integer pageSize);

	//查询对应的数据数量
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId);
	
	public Integer AddAppInfo(AppInfo appInfo);
	
	public AppInfo getAppinfoIdandAPKName(Integer id,String APKName);
	
	public boolean updateStatus(Integer id,Integer status);
}
