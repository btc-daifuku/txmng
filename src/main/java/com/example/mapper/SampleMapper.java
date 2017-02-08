package com.example.mapper;

import com.example.model.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SampleMapper {

	public List<Sample> getById(@Param("id") String id);

	public void insert(@Param("sample") Sample sample);

	public void update(@Param("sample") Sample sample);

	public void deleteById(@Param("id") String id);
}
