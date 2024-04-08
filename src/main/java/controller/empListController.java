package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empDAO;
import model.empVO;


@WebServlet("/empList.do")
public class empListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트 요청 받기 (/empList.do)
		// 2. emp 전체 리스트 가져오기
		empDAO dao = new empDAO();
		List<empVO> list = dao.getEmpList();
		// 객체 바인딩(request 바인딩)
		request.setAttribute("list", list);
		// forward 기법
		RequestDispatcher rd = request.getRequestDispatcher("emp/empList.jsp");
		rd.forward(request, response);
	}
}
