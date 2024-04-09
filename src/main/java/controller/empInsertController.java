package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empDAO;
import model.empVO;


@WebServlet("/empInsert.do")
public class empInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 파라미터 수집(VO)
		String empId = request.getParameter("empId");
		String empPw = request.getParameter("empPw");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String empName = request.getParameter("empName");
		String empJob = request.getParameter("empJob");
		String hireDate = request.getParameter("hireDate");
		String active = request.getParameter("active");
		
		// 디버깅
		System.out.println("[empFormController] request param empId : " + empId);
		System.out.println("[empFormController] request param empPw : " + empPw);
		System.out.println("[empFormController] request param grade : " + grade);
		System.out.println("[empFormController] request param empName : " + empName);
		System.out.println("[empFormController] request param empJob : " + empJob);
		System.out.println("[empFormController] request param hireDate : " + hireDate);
		System.out.println("[empFormController] request param active : " + active);
		// VO 값세팅
		empVO vo = new empVO();
		vo.setEmpId(empId);
		vo.setEmpPw(empPw);
		vo.setGrade(grade);
		vo.setEmpName(empName);
		vo.setEmpJob(empJob);
		vo.setHireDate(hireDate);
		vo.setActive(active);
		// model이 db 거쳐서 결과값 반환
		empDAO dao =  new empDAO();
		int cnt = dao.registerEmp(vo);
		if (cnt > 0) {
			//가입 성공
			response.sendRedirect("/MVC01/empList.do");
		} else {
			throw new ServletException("not insert");
		}
	}
}
