package com.anterp.lab;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/common")
public class UploadController {

	private Logger logger = Logger.getLogger(UploadController.class);

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void uploadFiles(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		MultipartFile file = request.getFile("uploadFile");
		System.out.println("name:" + file.getOriginalFilename() + ",fileSize:"
				+ file.getSize());
	}

}
