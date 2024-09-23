<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Employee Details</h1>

	<!-- Table for displaying employee data -->
	<table border="1">
		<thead>
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Join Date</th>
				<th>Designation</th>
				<th>Age</th>
				<th>Gender</th>
				<!-- Add more headers for additional columns -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empDetailsList}" var="employee">

				<tr>
					<td> <c:out value="${employee.empNo}"/></td>
					<td><c:out value="${employee.empName}"/></td>
					<td><c:out value="${employee.joinDate}"/></td>
					<td><c:out value="${employee.designation}"/></td>
					<td><c:out value="${employee.age}"/></td>
					<td><c:out value="${employee.gender}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>