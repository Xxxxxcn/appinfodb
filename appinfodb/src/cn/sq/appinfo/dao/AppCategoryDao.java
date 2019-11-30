package cn.sq.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.AppCategory;

public interface AppCategoryDao {

	//根据父级Id查询对应分类
	List<AppCategory> getAppCategories(@Param("parentId")Integer parentId);
}
