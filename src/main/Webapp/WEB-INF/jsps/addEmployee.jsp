<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
	<h2>Adding Employee:</h2>
	<form action="saveEmployeeToDB" method="post">
		Name:<input type="text" name="name"><br><br>
		Email:<input type="text" name="email"><br><br>
		Address:<input type="text" name="address"><br><br>
		Salary:<input type="text" name="salary"><br><br>
		<input type="submit" value="Add Employee"><br><br>
	</form>
${message}<br>

<a href="displayEmployee">View All Employees</a>
</body>
</html>