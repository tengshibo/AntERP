package com.anterp.modules;

import org.springframework.ui.Model;

public class Controllers {

	public static final String AccInfo = "accountInfo";
	public static final String JsonViewName = "aerpJsonView";

	public static void setSuccess(Model model) {
		model.addAttribute("ok", true);
	}

	public static void setError(Model model, String errorId, String errorDesc) {
		model.addAttribute("ok", false);
		model.addAttribute("errorId", errorId);
		model.addAttribute("errorDesc", errorDesc);
	}

}
