package com.example.dao;


import com.example.model.Sample;

import java.util.List;

public interface SampleDao {

	public List<Sample> getById(String id);

	public void insert(Sample sample);

	public void update(Sample sample);

	public void deleteById(String id);
}
