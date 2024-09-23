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

	<h1>${username}</h1>
	<!-- Table for displaying inward details -->
	<table border="1">
		<thead>
			<tr>
				<th>Inward No</th>
				<th>Grievance No</th>
				<th>Employee No</th>
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
					<td><c:out value="${inward.requestType}" /></td>
					<td><c:out value="${inward.requestSubtype}" /></td>
					<td><c:out value="${inward.inwardDate}" /></td>
  
					<td><c:out value="${inward.grevianceDate}" /></td>
					<td><c:out value="${inward.status}" /></td>
					<td><c:out value="${inward.remarks}" /></td>
					<td><c:out value="${inward.referenceNo}" /></td>
					<td>
						<%-- <c:choose>
                            <c:when test="${inward.status == 'manager also approved' or inward.status == 'rejected by manager' or inward.status=='rejected by hr' or inward.status=='rejected by teamlead'}">
                                 Approved
                            </c:when>
                            <c:otherwise>
                                <form action="/approve/${inward.inwardNo}" method="POST">
                                    <button type="submit" ${inward.status == 'inward.inwardNo' ? 'disabled' : ''}>Approve</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                        </td>
                        <td>
                    
                        <c:choose>
                            <c:when test="${inward.status == 'manager also approved' or inward.status == 'rejected by manager' or inward.status=='rejected by hr' or inward.status=='rejected by teamlead'}">
                               rejected
                            </c:when>
                            <c:otherwise>
                                <form action="/reject/${inward.inwardNo}" method="POST">
                                    <button type="submit" ${inward.status == 'inward.inwardNo' ? 'disabled' : ''}>Reject</button>
                                </form>
                            </c:otherwise>
                        </c:choose> --%>


						<form action="/processApproval/${inward.inwardNo}" method="post">
					
                        <input type="hidden" name="status" value="${inward.status}">
                         <input type="hidden" name="requestType" value="${inward.requestType}">
                     
                        <button type="submit" name="action" value="approve">Approve</button>
                        <button type="submit" name="action" value="reject">Reject</button>
                    </form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>