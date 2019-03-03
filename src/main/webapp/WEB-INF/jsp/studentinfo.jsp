<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Student Information</title>
<%@ page isELIgnored="false" %>
</head>
<body>
<div align="center">
		<h1><font color="green">${message}</font></h1>
</div>
<a href="home">Home</a>
	<table border="1" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Tech</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="student" items="${list}">
				<c:url var="updateLink" value="/editStudent">
					<c:param name="id" value="${student.id}"></c:param>
				</c:url>
				<c:url var="deleteLink" value="/deleteStudent">
					<c:param name="id" value="${student.id}"></c:param>
				</c:url>
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.tech}</td>
					<td><a href="${updateLink}">Edit</a></td>
					<td><a href="${deleteLink}"
						onClick="if(!(confirm('Are you sure to delete'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>