package com.example.pblist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.pblist.dao.PhonebookDao;
import com.example.pblist.dao.PhonebookDaoImpl;
import com.example.pblist.vo.PhonebookVo;

@WebServlet("/pl")
public class PblistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		String actionName = req.getParameter("a");
		
		if ("form".equals(actionName)) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/pblist/form.jsp");
			rd.forward(req, resp);
		} else {
			PhonebookDao dao = new PhonebookDaoImpl();
			List<PhonebookVo> list = dao.getList();

			req.setAttribute("list", list);
			req.setAttribute("search", "");

			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/pblist/index.jsp");
			rd.forward(req, resp);
		}
	}
		

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		String actionName = req.getParameter("a");
		
		if ("add".equals(actionName)) {
			//	a=add
			// 파라미터 받아오기
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String tel = req.getParameter("tel");

			//	VO 객체 생성
			PhonebookVo vo = new PhonebookVo();
			vo.setName(name);
			vo.setHp(hp);
			vo.setTel(tel);

			//	DAO / INSERT 처리
			PhonebookDao dao = new PhonebookDaoImpl();
			int insertedCount = dao.insert(vo);
		
			//	처리 후 list페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/");
			
		} else if ("search".equals(actionName)) {
			
			PhonebookDao dao = new PhonebookDaoImpl();
			String keyword = (String)req.getParameter("search");
			List<PhonebookVo> list = dao.search(keyword);
			
			req.setAttribute("list", list);
			
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/pblist/index.jsp");
			rd.forward(req, resp);
			
		}else if ("delete".equals(actionName)) {
			//	a=delete면
			//	파라미터 받기
			Long id = Long.valueOf(req.getParameter("id"));
			//	DAO 불러오기
			PhonebookDao dao = new PhonebookDaoImpl();
			//	삭제
			int deletedCount = dao.delete(id);
	
			//	처리 후 list페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/");
		} else {
			doGet(req, resp);
		}
	}
}