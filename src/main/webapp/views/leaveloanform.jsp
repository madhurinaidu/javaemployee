<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<h1> Employee leave form</h1>
<form action="/dummy2" method="post">

EmployeeCode:<input type="text" name="empNo"><br></br>

Request Type:<input type="text"  name="leaveSubtype" value="Leave"><br></br>
   
    <br></br>

    <label for="leaveSubtype">Request Subtype:</label>
    <select id="leaveSubtype" name="leaveType">
    <option value="Sick Leave">Sick Leave</option><br></br>
        <option value="Personal Leave">Personal Leave</option>
    </select>



 <br></br>
 <label for="fromdate">From Date:</label>
        <input type="date" name="fromdate" id="fromdate" required onchange="calculateNumberOfDays()"><br></br>
        
        <label for="todate">To Date:</label>
        <input type="date" name="todate" id="todate" required onchange="calculateNumberOfDays()"><br></br>

        <label for="numberofdays">Number of Days:</label>
        <input type="text" name="numberofdays" id="numberofdays" readonly><br></br>

       / <script>
        function calculateNumberOfDays() {
            var fromDate = new Date(document.getElementById("fromdate").value);
            var toDate = new Date(document.getElementById("todate").value);

            var timeDiff = toDate - fromDate;
            var daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));

            document.getElementById("numberofdays").value = daysDiff;
        }
    </script>
    
        
<input type="submit">

</form>

<div style="color: red;">
            <p>${leaveApplied}</p>
        </div>
</div>
 <!-- Pre-fill other fields from the EmpDetails object -->
    <p>Username: ${empDetails.empName}</p>
    <p>Sick Leave Balance: ${empDetails.sickleave}</p>
    <p>Personal Leave Balance: ${empDetails.persnalleave}</p>

</body>

</html>