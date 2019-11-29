package cn.sq.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.pojo.DataDictionary;

public interface DataDictionaryDao {
	
	//查询平台 状态 信息
	List<DataDictionary> selDataDictionarytypeCode(@Param("typeCode") String typeCode);
}
