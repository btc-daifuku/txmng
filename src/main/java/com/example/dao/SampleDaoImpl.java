package com.example.dao;

import com.example.mapper.SampleMapper;
import com.example.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleDaoImpl implements SampleDao {

	@Autowired
	private SampleMapper sampleMapper;

	@Override
	public List<Sample> getById(String id) {
		List<Sample> samples = sampleMapper.getById(id);
		return samples;
	}

	@Override
	public void insert(Sample sample) {
		sampleMapper.insert(sample);

	}

	@Override
	public void update(Sample sample) {
		sampleMapper.update(sample);

	}

	@Override
	public void deleteById(String id) {
		sampleMapper.deleteById(id);
	}
}
