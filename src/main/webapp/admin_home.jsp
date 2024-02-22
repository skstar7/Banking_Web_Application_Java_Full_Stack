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

<h1>Welcome_to_Admin_home_page</h1>
<body>
	<%
	List<BankAccount> list = (List<BankAccount>) request.getSession().getAttribute("list");
	%>
	<table border="1">
		<tr>
			<th>Account_number</th>
			<th>Account_Type</th>
			<th>Customer_name</th>
			<th>Customer_id</th>
			<th>Account_Status</th>
			<th>Change_number</th>
		</tr>
		<%
		for (BankAccount bank_account : list) {
		%>

		<tr>
			<th><%=bank_account.getAcc_no()%></th>
			<th><%=bank_account.getAcc_type()%></th>
			<th><%=bank_account.getCustomer().getCname()%></th>
			<th><%=bank_account.getCustomer().getCid()%></th>
			<th><%=bank_account.isStatus()%></th>
			<th><a href="changestatus?acno=<%=bank_account.getAcc_no()%>">
					<button>Change_status</button>
			</a></th>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>