package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 데이터베이스 연결객체 생성(Connection)
	private void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user= "root";
		String password = "1234";
		// MySql Driver Loading
		try {
			// 동적로딩
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 데이터베이스 연결 끊기
	private void dbClose() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<empVO> getEmpList() {
		String sql = "SELECT * FROM emp";
		List<empVO> list = new ArrayList<empVO>(); 
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
			String empNo = rs.getString("emp_no");
			String empId = rs.getString("emp_id");
			String empPw = rs.getString("emp_pw");
			int grade =	rs.getInt("grade");
			String empName = rs.getString("emp_name");
			String empJob = rs.getString("emp_job");
			String hireDate	= rs.getString("hire_date");
			String updateDate =	rs.getString("update_date");
			String createDate =	rs.getString("create_date");
			String active =	rs.getString("active");
			empVO vo = new empVO(empNo, empId, empPw, grade, empName, empJob, hireDate, updateDate, createDate, active);
			list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		dbClose();
		}
		return list;
	}

	public int registerEmp(empVO vo) {
		String sql = "INSERT INTO emp (emp_id, emp_pw, grade, emp_name, emp_job, hire_date, update_date, create_date, active) "
				+ "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW(), ?)";
		getConnect();
		int cnt = -1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmpId());
			psmt.setString(2, vo.getEmpPw());
			psmt.setInt(3, vo.getGrade());
			psmt.setString(4, vo.getEmpName());
			psmt.setString(5, vo.getEmpJob());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getActive());
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
}
