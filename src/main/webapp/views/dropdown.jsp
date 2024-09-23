<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/hello" method="post">

emp:<input type="text" name="empNo"><br></br>


    <label for="requestType">Request Type:</label>
    <select id="requestType" name="requestType">
        <option value="Leave">Leave</option>
        <option value="Loan">Loan</option>
    </select>

    <label for="requestSubtype">Request Subtype:</label>
    <select id="requestSubtype" name="requestSubtype">
    </select>


<script>
    const requestTypeDropdown = document.getElementById("requestType");
    const requestSubtypeDropdown = document.getElementById("requestSubtype");

    // Define a function to update the "request subtype" dropdown
    function updateRequestSubtypeOptions() {
        const selectedRequestType = requestTypeDropdown.value;
        requestSubtypeDropdown.innerHTML = "";

        if (selectedRequestType === "Leave") {
            const leaveOptions = ["Sick Leave", "Personal Leave"];
            leaveOptions.forEach((option) => {
                const optionElement = document.createElement("option");
                optionElement.textContent = option;
                optionElement.value = option;
                requestSubtypeDropdown.appendChild(optionElement);
            });
        } else if (selectedRequestType === "Loan") {
            const loanOptions = ["Home Loan", "Personal Loan"];
            loanOptions.forEach((option) => {
                const optionElement = document.createElement("option");
                optionElement.textContent = option;
                optionElement.value = option;
                requestSubtypeDropdown.appendChild(optionElement);
            });
        }
    }

    // Listen for changes in the "request type" dropdown
    requestTypeDropdown.addEventListener("change", updateRequestSubtypeOptions);

    // Initialize the "request subtype" dropdown based on the initial "request type"
    updateRequestSubtypeOptions();
</script>
date:<input type="text" name="inwardDate"><br></br>
gdatw:<input type="text" name="grevianceDate"><br></br>
status<input type="text" name="status"><br></br>
remarks<input type="text" name="remarks"><br></br>
empdisg<input type="text" name="empDesig"><br></br>
<input type="submit">
</form>

</body>
</html>