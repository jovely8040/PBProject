package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name="home", urlPatterns = "/")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 시작하면서 리스트 한번 하고 시작. 바로 이동.
		// 만약 로그인이나 앞전에 수행할 것이 있으면 없어도 될 것같음.
		resp.sendRedirect(req.getContextPath() + "/ps");


//		RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
//		rd.forward(req, resp);
//		


	}

}