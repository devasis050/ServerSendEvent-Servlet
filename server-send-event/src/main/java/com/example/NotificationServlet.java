package com.example;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test"}, asyncSupported = true)
public class NotificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/event-stream");
		AsyncContext actx = req.startAsync(req,res);
		//Use the context to use it asynchronously. We may look into listener for better control.
		actx.setTimeout(10 * 1000);
		
		actx.getResponse().getWriter().println("First Response");
		actx.getResponse().getWriter().flush();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actx.getResponse().getWriter().println("Second Response");
		actx.complete();
	}

}
