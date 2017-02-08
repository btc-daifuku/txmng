package com.example.logic;

import com.example.dto.SampleDTO;

public interface SampleLogic {

	public SampleDTO getById(String id);

	public SampleDTO insert(String val);

	public void update(String id, String val);

	public void deleteById(String id);
}
