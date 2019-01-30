<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="fundTransfer" method="post">
		Senders Account Number: <input name="sendersAccountNumber"/><br/>
		Receivers Account Number: <input name="receiversAccountNumber"/><br/>
		Amount : <input name="amount"/><br/>
	<input type="submit"/>
</form>
</body>
</html>