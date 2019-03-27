package com.demo.service;

import java.util.List;

import com.demo.pojo.BaseDict;

public interface BaseDictService {
	//根据类别代码查询
	
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
	
}
