package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhonebookDAO;
import dao.PhonebookDAOImpl;
import vo.PhonebookVO;


// 인코팅 설정때문에 web.xml 사용
//@WebServlet(name = "contact", urlPatterns = "/ps")
public class ContactServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");

		if ("insert".equals(actionName)) {
			// a = form이면 회원가입으로 이동
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/addform.jsp");
			// 전달
			rd.forward(req, resp);

		} else {
			// 신규가입 아니면 리스트 불러오기. 인덱스의 reset도 동일하게 리스트 불러오기
			PhonebookDAO dao = new PhonebookDAOImpl();
			List<PhonebookVO> list = dao.getlist();
			req.setAttribute("list", list);
			req.setAttribute("search", "");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 등록
		String actionName = req.getParameter("a");
		if ("add".equals(actionName)) {
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String tel = req.getParameter("tel");

			PhonebookVO vo = new PhonebookVO();

			System.out.printf("%s-%s-%s", name, hp, tel);

			vo.setName(name);
			vo.setHp(hp);
			vo.setTel(tel);

			PhonebookDAO dao = new PhonebookDAOImpl();
			boolean insertbl = dao.insert(vo);
			System.out.print(insertbl);

			resp.sendRedirect(req.getContextPath() + "/ps");
		}
		
		// 삭제
		else if("delete".equals(actionName)) {
			Long id;
			id = Long.valueOf(req.getParameter("id"));
			PhonebookDAO dao = new PhonebookDAOImpl();
			boolean deletebl = dao.delete(id);
			System.out.println(deletebl);
			resp.sendRedirect(req.getContextPath() + "/ps");

		} 
		
		// 검색
		else if ("search".equals(actionName)) {
			String search = req.getParameter("search");
			PhonebookDAO dao = new PhonebookDAOImpl();
			List<PhonebookVO> list = dao.search(search);
			req.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			req.setAttribute("search", search);
			rd.forward(req, resp);
		}
		else if ("reset".equals(actionName)) {
			String search = req.getParameter("search");
			PhonebookDAO dao = new PhonebookDAOImpl();
			List<PhonebookVO> list = dao.search(search);
			req.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}

	}

}