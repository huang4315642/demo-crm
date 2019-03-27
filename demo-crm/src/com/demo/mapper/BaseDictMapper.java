package com.demo.mapper;

import java.util.List;

import com.demo.pojo.BaseDict;

public interface BaseDictMapper {
	//根据类别代码查询数据
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
