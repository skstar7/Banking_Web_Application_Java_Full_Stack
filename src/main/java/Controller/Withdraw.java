package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankTransactionHistory;
import Dto.BankAccount;

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double ammount = Double.parseDouble(req.getParameter("ammt"));

		Long acno = (Long) req.getSession().getAttribute("account_num");
		BankDao bank_dao = new BankDao();
		BankAccount bank_account = bank_dao.find(acno);

		bank_dao.update_the_details(bank_account);

		if (bank_account.getAmount() < ammount) {

			resp.getWriter().print("<h1> Insufficient account balance </h1>");

		} else {
			if (bank_account.getAcc_limit() < ammount) {
				resp.getWriter().print("<h1> Exceding amount limit </h1>");
			}

			else {
				bank_account.setAmount(bank_account.getAmount() - ammount);

				BankTransactionHistory bankTransaction = new BankTransactionHistory();

				bankTransaction.setDeposite(0);
				bankTransaction.setWithdraw(ammount);
				bankTransaction.setBalance(bank_account.getAmount());
				bankTransaction.setDate_time(LocalDateTime.now());

				List<BankTransactionHistory> list2 = bank_account.getTransaction_list();
				list2.add(bankTransaction);
				bank_account.setTransaction_list(list2);

				bank_dao.update_the_details(bank_account);

				resp.getWriter().print("<h1> Withdrwa succesfiullllllll </h1>");

			}
		}

	}

}
