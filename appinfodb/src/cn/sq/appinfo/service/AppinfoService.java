package cn.sq.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
}
