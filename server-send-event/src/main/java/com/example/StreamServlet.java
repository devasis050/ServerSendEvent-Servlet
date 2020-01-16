package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/stream"})
public class StreamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
		//By default it does not support streaming.
		//text/html supports streaming but it depends upon browser. e.g same code works differently in chrome and eclipse built in browser.
		
		
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.print("first");
		pw.flush();
		sleep();
		pw.print("Second");
	}
	
	static void sleep()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
