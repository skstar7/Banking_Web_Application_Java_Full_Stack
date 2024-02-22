<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome to active account page</h1>



	<%
	List<BankAccount> list = (List<BankAccount>) request.getSession().getAttribute("list");

	if (list.isEmpty()) {
	%>

	<h1>No acctive bank acc</h1>

	<%
	} else {
	%>


	<h1>Select bank accounts</h1>


	<%
	for (BankAccount bank_account : list) {
	%>

	<a href="setActiveAccount?accno=<%=bank_account.getAcc_no()%>">
		<button><%=bank_account.getAcc_no()%></button>
	</a>

	<%}%>


	<%}%>

</body>
</html>