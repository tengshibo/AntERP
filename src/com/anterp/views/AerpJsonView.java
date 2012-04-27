package com.anterp.views;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.view.AbstractView;

/**
 * This is AntERP JSON view, used to render AJAX response.
 */
public class AerpJsonView extends AbstractView {

	private static Logger logger = Logger.getLogger(AerpJsonView.class);

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter writer = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String responseObject = objectMapper.writeValueAsString(model);
			writer = response.getWriter();
			writer.write(responseObject);
			writer.flush();
		} catch (Throwable t) {
			logger.error("Write jsonResponse error:", t);
		} finally {
			writer.close();
		}
	}

}
