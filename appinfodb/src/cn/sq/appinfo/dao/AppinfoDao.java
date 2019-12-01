package cn.sq.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.tools.Page;

public interface AppinfoDao {
	
	//按条件查询切分页
	public List<AppInfo> getAppInfoList(@Param("softwareName")String querySoftwareName,
										@Param("status")Integer queryStatus,
										@Param("categoryLevel1")Integer queryCategoryLevel1,
										@Param("categoryLevel2")Integer queryCategoryLevel2,
										@Param("categoryLevel3")Integer queryCategoryLevel3,
										@Param("flatformId")Integer queryFlatformId,
										@Param("devId")Integer devId,
										@Param("pageInex")Integer pageInex,
										@Param("pageSize")Integer pageSize);

	public int getAppInfoCount(@Param("softwareName")String querySoftwareName,
							   @Param("status")Integer queryStatus,
							   @Param("categoryLevel1")Integer queryCategoryLevel1,
							   @Param("categoryLevel2")Integer queryCategoryLevel2,
							   @Param("categoryLevel3")Integer queryCategoryLevel3,
							   @Param("flatformId")Integer queryFlatformId,
							   @Param("devId")Integer devId);
	
	public Integer InsertAppInfo(AppInfo appInfo);
	
	public AppInfo getAppinfoIdandAPKName(@Param("id")Integer id,@Param("APKName") String APKName);
	
	public Integer updateAppinfoStatu(@Param("id")Integer id,@Param("status")Integer status);
}
