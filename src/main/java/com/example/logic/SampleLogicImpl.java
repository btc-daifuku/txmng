package com.example.logic;

import com.example.dao.SampleDao;
import com.example.dto.SampleDTO;
import com.example.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional(rollbackFor = Exception.class)
public class SampleLogicImpl implements SampleLogic {

	@Autowired
	private SampleDao sampleDao;

	@Override
	@Transactional(readOnly = true)
	public SampleDTO getById(String id) {
		SampleDTO sampleDTO = new SampleDTO();
		List<Sample> samples = sampleDao.getById(id);
		if (samples == null || samples.size() == 0) {
			sampleDTO.setMsg("not found.");
			return sampleDTO;
		}
		sampleDTO.setId(samples.get(0).getId());
		sampleDTO.setValue(samples.get(0).getVal());
		sampleDTO.setMsg("found.");

		return sampleDTO;
	}

	@Override
	@Transactional
	public SampleDTO insert(String val) {
		String id = UUID.randomUUID().toString();
		Sample sample = new Sample();
		sample.setId(id);
		sample.setVal(val);
		sampleDao.insert(sample);

		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setId(id);
		sampleDTO.setValue(val);

		return sampleDTO;
	}

	@Override
	public void update(String id, String val) {

	}

	@Override
	public void deleteById(String id) {

	}
}
