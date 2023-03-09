package com.kusumika.school.mapper.kusumikadb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kusumika.school.bean.Fees;
import com.kusumika.school.bean.FeesCollection;

@Mapper
public interface FeesMapper {

	List<Fees> getTotalFees(@Param("householdId") int householdId);

	FeesCollection getFeesCollectionReport(@Param("householdId") int householdId);
	
}
