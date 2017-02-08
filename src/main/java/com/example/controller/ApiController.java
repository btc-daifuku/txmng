package com.example.controller;

import com.example.controller.request.CreateSampleRequest;
import com.example.dto.SampleDTO;
import com.example.logic.SampleLogic;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private SampleLogic sampleLogic;

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public SampleDTO getSample(@RequestParam("id") String id) {


		logger.info("GET /get");

		if (StringUtils.isEmpty(id)) {
			logger.warn("GET /get validation error.");
			SampleDTO sampleDTO = new SampleDTO();
			sampleDTO.setMsg("validation error.");
			return sampleDTO;
		}

		SampleDTO sampleDTO = sampleLogic.getById(id);

		logger.info("GET /get success.");
		return sampleDTO;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public SampleDTO createSample(@Validated @RequestBody CreateSampleRequest request, BindingResult bindingResult) {

		logger.info("POST /create");

		if (bindingResult.hasErrors()) {
			logger.warn("POST /create validation error.");
			SampleDTO sampleDTO = new SampleDTO();
			sampleDTO.setMsg("validation error.");
			return sampleDTO;
		}

		SampleDTO sampleDTO = sampleLogic.insert(request.getValue());
		sampleDTO.setMsg("success.");

		logger.info("POST /create success.");
		return sampleDTO;
	}

	@ExceptionHandler({Exception.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public void ApiExceptionHandler(Exception e) {
		logger.error(ExceptionUtils.getMessage(e) + " statckTrace:" + ExceptionUtils.getStackTrace(e), e);
	}
}
