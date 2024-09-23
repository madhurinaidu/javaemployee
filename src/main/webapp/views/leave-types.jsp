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
<h1>Leave Types</h1>
      <%-- <p>Employee Number: ${authenticatedEmpno}</p>
     --%>
    <!-- Table for displaying leave types -->
    <table border="1">
        <thead>
            <tr>
                <th>Leave No</th>
                <th>Leave Type</th>
                <th>Leave Subtype</th>
                <th>Emp_no</th>
                
                <th>Status</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${leaveTypeList}" var="leaveType">
            
            <tr >
                <td><c:out value="${leaveType.leaveNo}"/></td>
                <td ><c:out value="${leaveType.leaveType}"/>
                <td ><c:out value="${leaveType.leaveSubtype}"/></td>
                <td ><c:out value="${leaveType.empNo}"/></td>
                
                
                
                <td ><c:out value="${leaveType.status}"/></td>
                
               
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
</body>
</html>