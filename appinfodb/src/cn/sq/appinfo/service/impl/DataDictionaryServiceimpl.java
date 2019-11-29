package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.DataDictionaryDao;
import cn.sq.appinfo.pojo.DataDictionary;
import cn.sq.appinfo.service.DataDictionaryService;

@Service
public class DataDictionaryServiceimpl implements DataDictionaryService{

	@Resource
	private DataDictionaryDao dd;
	@Override
	public List<DataDictionary> DataDictionaryTypeCode(String typeCode) {
		return dd.selDataDictionarytypeCode(typeCode);
	}
	
}
