package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.AppCategoryDao;
import cn.sq.appinfo.pojo.AppCategory;
import cn.sq.appinfo.service.AppCategoryService;

@Service
public class AppCategoryServiceimpl implements  AppCategoryService{

	@Resource
	private AppCategoryDao ad;
	@Override
	public List<AppCategory> getAppCategories(Integer parenId) {
		return ad.getAppCategories(parenId);
	}

}
