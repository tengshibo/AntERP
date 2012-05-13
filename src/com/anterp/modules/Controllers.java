package com.anterp.modules;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.anterp.tool.JsonUtil;

public class Controllers {

	public static final String IndexJSP = "/index/index.jsp";
	public static final String AccInfo = "accountInfo";
	public static final String AccInfoJson = "accountInfoJson";
	public static final String JsonViewName = "aerpJsonView";

	public static void setSuccess(Model model) {
		model.addAttribute("ok", true);
	}

	public static void setError(Model model, String errorId, String errorDesc) {
		model.addAttribute("ok", false);
		model.addAttribute("errorId", errorId);
		model.addAttribute("errorDesc", errorDesc);
	}

	public static void setSessionExpired(Model model) {
		model.addAttribute("ok", false);
		model.addAttribute("errorId", "session.001");
		model.addAttribute("errorDesc", "会话过期，请重新登录。");
	}

	public static void setSessionExpired(HttpServletResponse httpResponse)
			throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ok", false);
		map.put("errorId", "session.001");
		map.put("errorDesc", "会话过期，请重新登录。");
		httpResponse.getWriter().write(JsonUtil.toJson(map));
	}

}
