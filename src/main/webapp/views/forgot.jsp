<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
        .error {
            color: red;
        }
       
        .centered-form {
            text-align: center; 
            margin-top: 100px; 
             }

        .centered-form form {
            display: inline-block;
        }
    
    </style>
</head>
<body>

<div class="centered-form">
<div class="error">
        <c:if test="${not empty error}">
            <span>${error}</span>
        </c:if>
    </div>
  <h4>Enter Username</h4><br></br>
 <form action="/forgot" method="post">
 
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
          <input type="submit" value="submt">
             </form>
    </div>
</body>
</html>