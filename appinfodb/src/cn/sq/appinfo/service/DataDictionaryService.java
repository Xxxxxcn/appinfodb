package cn.sq.appinfo.service;

import java.util.List;

import cn.sq.appinfo.pojo.DataDictionary;

public interface DataDictionaryService {
	
	List<DataDictionary> DataDictionaryTypeCode(String typeCode);
}
