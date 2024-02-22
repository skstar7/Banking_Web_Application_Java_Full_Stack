<%@page import="Dto.Customer"%>
<%@page import="Dto.BankAccount"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Balance check page</h1>

	<%
	long acno = (long) request.getSession().getAttribute("account_num");

	BankDao bank_dao = new BankDao();
	BankAccount bank_account = bank_dao.find(acno);

	Customer customer = bank_account.getCustomer();
	%>



	<h1>
		Hello<%
	if (customer.getGender().equals("male")) {
	%>
		Mr<%} else {%>
		Ms.<%
	}
	%>
		<%=customer.getCname()%>
		Your Account Balance is:
		<%=bank_account.getAmount()%></h1>


	<a href="account_home.html">Back</a>

</body>
</html>