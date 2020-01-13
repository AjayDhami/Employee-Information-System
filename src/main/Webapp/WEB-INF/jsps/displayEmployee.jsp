<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Employee</title>
</head>
<body>
	<h2>Employees:</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Salary</th>
		</tr>

		<c:forEach items="${listOfEmployee}" var="employeeList">
			<tr>
				<td>${employeeList.id}</td>
				<td>${employeeList.name}</td>
				<td>${employeeList.email}</td>
				<td>${employeeList.address}</td>
				<td>${employeeList.salary}</td>
				<td><a href="showEditEmployeePage?id=${employeeList.id}">Edit</a></td>
				<td><a href="deleteEmployee?id=${employeeList.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="addEmployee">Add Employee</a>
</body>
</html>