package com.anterp.lib;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lib/http")
public class HttpTransfer {

	@RequestMapping("/doForward")
	public void doForward(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("asTarget").forward(request, response);
	}

	@RequestMapping("/doRedirect")
	public void doRedirect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("asTarget");
	}

	@RequestMapping("/asTarget")
	public void asTarget(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write("This is target page.");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}
}
