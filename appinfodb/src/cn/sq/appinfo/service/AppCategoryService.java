package cn.sq.appinfo.service;

import java.util.List;

import cn.sq.appinfo.pojo.AppCategory;

public interface AppCategoryService {

	// 根据父级Id查询对应分类
	List<AppCategory> getAppCategories(Integer parenId);
}
