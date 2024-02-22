<%@page import="Dto.BankTransactionHistory"%>
<%@page import="java.util.List"%>
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

	<%
	long acno = (long) request.getSession().getAttribute("account_num");

	BankDao bank_dao = new BankDao();
	BankAccount bank_account = bank_dao.find(acno);

	List<BankTransactionHistory> list = bank_account.getTransaction_list();
	%>

	<table>


		<tr>

			<th>Tid</th>
			<th>Deposite</th>
			<th>Withdraw</th>
			<th>Balance on that time</th>
			<th>Date</th>

		</tr>




		<%
		for (BankTransactionHistory bankTransaction : list)

		{
		%>


		<tr>


			<th><%=bankTransaction.getTransaction_id()%></th>
			<th><%=bankTransaction.getDeposite()%></th>
			<th><%=bankTransaction.getWithdraw()%></th>
			<th><%=bankTransaction.getBalance()%></th>
			<th><%=bankTransaction.getDate_time()%></th>


		</tr>

		<%
		}
		%>


	</table>

	<a href="account_home.html">back to account home</a>



</body>
</html>