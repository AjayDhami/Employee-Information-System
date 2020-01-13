<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>

	<h2>Edit Employee Details:</h2>
	<form action="updateEmployeeToDB" method="post">
		ID:<input type="text" name="id" value="${employeeUpdateDetails.id}" readonly="readonly"><br><br>
		Name:<input type="text" name="name" value="${employeeUpdateDetails.name}"><br><br>
		Email:<input type="text" name="email" value="${employeeUpdateDetails.email}"><br><br>
		Address:<input type="text" name="address" value="${employeeUpdateDetails.address}"><br><br>
		Salary:<input type="text" name="salary" value="${employeeUpdateDetails.salary}"><br><br>
		<input type="submit" value="Update Employee"><br><br>
	</form>

</body>
</html>