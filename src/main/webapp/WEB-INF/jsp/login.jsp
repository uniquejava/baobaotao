<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Baobaotao Forum Login</title>
</head>
<body>
<c:if test="${not empty error }">
	<div style="color: red"><c:out value="${error }"></c:out></div>
</c:if>

<form action="<c:url value="/loginCheck.html"/>" method="post">
	USER NAME:
	<input type="text" name="userName"/>
	<br/>
	PASSWORD:
	<input type="password" name="password"/>
	<br>
	<input type="submit" value="login"/> 
	<input type="reset" value="reset"/> 
</form>
</body>
</html>