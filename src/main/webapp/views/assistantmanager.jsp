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
<h1>Assistant Manager Approval</h1>

<table border="1">
		<thead>
			<tr>
				<th>Inward No</th>
				<th>Grievance No</th>
				<th>Employee No</th>
				<th>Employee Designation</th>
				<th>Request Type</th>
				<th>Request Subtype</th>
				<th>Inward Date</th>
				<th>Grievance Date</th>
				<th>status</th>
				<th>Remarks</th>
				<th>Reference No</th>
				<th>Actions</th>
				<th>Actions</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${inwardDetailsList}" var="inward">

				<tr>
					<td><c:out value="${inward.inwardNo}" /></td>
					<td><c:out value="${inward.grevianceNo}" /></td>
					<td><c:out value="${inward.empNo}" /></td>
					<td><c:out value="${inward.empDesig}" /></td>
					<td><c:out value="${inward.requestType}" /></td>
					<td><c:out value="${inward.requestSubtype}" /></td>
					<td><c:out value="${inward.inwardDate}" /></td>

					<td><c:out value="${inward.grevianceDate}" /></td>
					<td><c:out value="${inward.status}" /></td>
					<td><c:out value="${inward.remarks}" /></td>
					<td><c:out value="${inward.referenceNo}" /></td>
					
					 <td>
                        <c:choose>
                            <c:when test="${inward.status == 'manager also approved'}">
                                 Approved 
                            </c:when>
                            <c:otherwise>
                                <form action="/assistantmanager/${inward.inwardNo}" method="POST">
                                    <button type="submit" ${inward.status == 'inward.inwardNo' ? 'disabled' : ''}>Approve</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${inward.status == 'manager also approved'}">
                                rejected
                            </c:when>
                            <c:otherwise>
                                <form action="/assistantmanagerloanereject/${inward.inwardNo}" method="POST">
                                    <button type="submit" ${inward.status == 'inward.inwardNo' ? 'disabled' : ''}>Reject</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
					<%-- <td>
                        <form action="assistantmanager/${inward.inwardNo }" method="post" >
                        <button type="submit">Approve</button>
                        </form> 
                        
                        
					</td>
					<td>
					<form action="assistantmanagerloanereject/${inward.inwardNo }" method="post" >
                        <button type="submit">Reject</button>
                        </form> --%>
                        
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>