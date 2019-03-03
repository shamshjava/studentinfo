<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>Enter Student Details</h2>
<form:form action="addupdateStudent" modelAttribute="student">
	<b>Student ID :</b> <form:input path="id" size="30" /><br><br>
	<b>Student Name :</b> <form:input path="name" size="30" /><br><br>
	<b>Student Tech :</b> <form:input path="tech" size="30" /><br><br>
	<input type="submit" value="Add/Update">
</form:form>

<form action="findAllStudent">
	<input type="submit" value="Find All">
</form>

<form action="findStudent">
	<b>Student ID :</b> <input type="text" name="id"><br><br>
	<input type="submit" value="Find">
</form>


</body>
</html>