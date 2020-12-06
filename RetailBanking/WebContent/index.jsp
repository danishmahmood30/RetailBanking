<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Server Running</h1>
<form action="${pageContext.request.contextPath}/ControllerServlet">
<button type="submit" name="action" value="view" >Click</button>
</form>
<button type="submit" name="action" value="see" formaction="<%=request.getContextPath()%>/ControllerServlet?action=viewAll" >Click</button>
</body>
</html>