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
	<h1>Leave Sanctioned Details</h1>

	<!-- Table for displaying leave sanctioned details -->
	<table border="1">
		<thead>
			<tr>
				<th>Employee No</th>
				<th>Sanctioned No</th>
				<th>Designation</th>
				<th>Reference No</th>
				<th>EmpName</th>
				<th>JoinDate</th>
				<th>status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${leaveSanctionedList}" var="leaveSanctioned">
				<tr>
					<td><c:out value="${leaveSanctioned.empNo}" /></td>
					<td><c:out value="${leaveSanctioned.sanctionedNo}" /></td>
					<td><c:out value="${leaveSanctioned.designation}" /></td>
					<td><c:out value="${leaveSanctioned.referenceNo}" /></td>
					<td><c:out value="${leaveSanctioned.empname}" /></td>
					<td><c:out value="${leaveSanctioned.jionDate}" /></td>
					
					<td><c:out value="${leaveSanctioned.status}" /></td>
				
					<!-- Add more columns as needed -->
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>