<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
 .centered-message {
            text-align: center;
            font-weight: bold;
            color: green;
        }
        </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 style="text-align: center;">teamlead Approval</h1>

<table border="1" id="approvalTable">
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

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${inwardDetailsList}" var="inward">
                <c:choose>
                 <c:when test="${inward.status == 'manager also approved' or inward.status == 'rejected by manager' or inward.status=='rejected by hr'  or inward.status=='waiting for manager' or inward.status=='waiting for hr'or inward.status=='rejected by teamlead' }">
                    </c:when>     
               <c:otherwise>
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
					       <form action="/leave/${inward.inwardNo}" method="POST">
                                    <%-- <button type="submit" ${inward.status == 'inward.inwardNo' ? 'disabled' : ''}>Approve</button>
                              --%>   <button>Approve</button>
                                </form>
                                <form action="/teamlead/${inward.inwardNo}" method="POST">
                               
                                <button>Reject</button>
                              </form>
                               
                        </td>
                          </c:otherwise>
                          
                </c:choose>
                       
					
				
			</c:forEach>
			
		</tbody>
	</table>
	<form action="/home" method="get">
<button>logout</button>
</form>
 <script>
        // Check if there are no rows to display
        var table = document.getElementById("approvalTable");
        if (table.rows.length <= 1) { // If there's only one row, it's the header row
            table.style.display = "none"; // Hide the table
            // Display a message when there are no rows
            var message = document.createElement("p");
            message.textContent = "There are no Leave request";
            message.className = "centered-message"; 
            document.body.appendChild(message);
        }
    </script>
</body>
</html>