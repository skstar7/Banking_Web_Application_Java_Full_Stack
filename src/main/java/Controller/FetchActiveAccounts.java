package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.BankAccount;
import Dto.Customer;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/fetchActiveAccount")
public class FetchActiveAccounts extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Customer customer = (Customer) req.getSession().getAttribute("customer");

		List<BankAccount> list = customer.getBankaccounts();

		List<BankAccount> list2 = new ArrayList<>();

		for (BankAccount bank_account : list) {

			if (bank_account.isStatus()) {
				list2.add(bank_account);

			} else {
				resp.getWriter().print("<h1>Account is inactive </h1>");
			}
		}

		req.getSession().setAttribute("list", list2);

		req.getRequestDispatcher("active_accounts.jsp").include(req, resp);

	}

}
