package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Server;

import Dao.BankDao;
import Dto.BankTransactionHistory;
import Dto.BankAccount;

@WebServlet("/deposite")
public class Deposite extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long ammount = Long.parseLong(req.getParameter("amount"));

		Long acno = (Long) req.getSession().getAttribute("account_num");
		BankDao bank_dao = new BankDao();
		BankAccount bank_account = bank_dao.find(acno);

		bank_account.setAmount(bank_account.getAmount() + ammount);

		BankTransactionHistory bankTransaction = new BankTransactionHistory();
		bankTransaction.setDeposite(ammount);
		bankTransaction.setWithdraw(0);
		bankTransaction.setBalance(bank_account.getAmount());
		bankTransaction.setDate_time(LocalDateTime.now());
		List<BankTransactionHistory> list2 = bank_account.getTransaction_list();
		list2.add(bankTransaction);
		bank_account.setTransaction_list(list2);

		bank_dao.update_the_details(bank_account);

		resp.getWriter().print("<h1> Amount deposite succesfully </h1>");

	}
}