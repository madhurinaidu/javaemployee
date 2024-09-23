<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.centered-form {
	text-align: center; /* Center the form horizontally */
	margin-top: 100px; /* Adjust the top margin to center vertically */
	/* You can adjust these values based on your design requirements */
}

.centered-form form {
	display: inline-block;
}
</style>
</head>
<body>
	<div class="centered-form">
		<form action="/loanapplied" method="post">

			EmployeeId:<input type="text" name="empNo"><br></br> Request
			Type:<input type="text" name="loanSubtype" value="Loan"><br></br>

			<!-- <label for="leaveType">Request Type:</label>
    <select id="leaveType" name="loanSubtype">
        <option value="Leave">Leave</option>
        <option value="Loan">Loan</option>
    </select> -->

			<label for="leaveSubtype">Request Subtype:</label> <select
				id="leaveSubtype" name="loanType">
				<option value="Home Loan">Home Loan</option>
				<option value="Personal Loan">Personal Loan</option>
			</select><br></br> EnterAmount:<input type="text" name="loanamount"> <input
				type="submit">

		</form>
		<div style="color: red;">
			<p>${leaveApplied}</p>
		</div>
	</div>
	<p>Username: ${empDetails.empName}</p>
	<p>Personal Loan Balance: ${empDetails.persnalloan}</p>
	<p>Home Balance: ${empDetails.homeloan}</p>



</body>
</html>