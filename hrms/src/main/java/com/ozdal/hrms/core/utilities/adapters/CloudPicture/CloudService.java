package com.ozdal.hrms.core.utilities.adapters.CloudPicture;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ozdal.hrms.core.utilities.results.DataResult;

public interface CloudService {
	DataResult<Map<String, String>> upload(MultipartFile multipartFile);
	DataResult<Map> delete(String id) throws IOException;
}
