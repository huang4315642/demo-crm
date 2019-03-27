package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.BaseDictMapper;
import com.demo.pojo.BaseDict;
import com.demo.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;


	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		// TODO Auto-generated method stub
		List<BaseDict> list = this.baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
		return list;
	}

}
