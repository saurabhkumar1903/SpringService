<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 <%@ page isELIgnored="false" %> 
</head>
<body>

<p>${msg}</p>
<h1>SignUp Form</h1>
<form action="signup" method="post">
<input type="text" name="userid">
<input type="password" name="password">
 <input type="submit" value="submit">
 </form>
 
 <h1>SignIn Form</h1>
<form action="signin" method="post">
<input type="text" name="userid">
<input type="password" name="password">
 <input type="submit" value="submit">
 </form>

</body>
</html>