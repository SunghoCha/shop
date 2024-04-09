<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>

</head>
<body>
	<table class="table table-bordered">
  <tr>
    <td>번호</td>
    <td>아이디</td>
    <td>등급</td>
    <td>이름</td>
    <td>직업</td>
    <td>고용날짜</td>
    <td>권한</td>
  </tr>
 	<c:forEach var="vo" items="${list}">
  	  <tr>
	    <td>${vo.empNo}</td>
	    <td>${vo.empId}</td>
	    <td>${vo.grade}</td>
	    <td>${vo.empName}</td>
	    <td>${vo.empJob}</td>
	    <td>${vo.hireDate}</td>
	    <td>${vo.active}</td>
	  </tr>
	</c:forEach>
	<tr>
 	 <td colspan="8" align="right"><input type="button" value="회원가입" class="btn" onclick="location.href='emp/empForm.jsp'"/></td>
 	</tr>
  </table>
</body>
</html>