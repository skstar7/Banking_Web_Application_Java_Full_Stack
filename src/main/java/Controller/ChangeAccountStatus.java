package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
import java.util.List;

@WebServlet("/changestatus")
public class ChangeAccountStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String ac_no = req.getParameter("acno");
		long acc_no = Long.parseLong(ac_no);
		
		BankDao bank_dao = new BankDao();

		BankAccount bank_account = bank_dao.fetch_account_details(acc_no);

		if (bank_account.isStatus()) {
			bank_account.setStatus(false);
		} else {
			bank_account.setStatus(true);
		}

		bank_dao.update_the_details(bank_account);

		resp.getWriter().print("<h1>Status get updated </>");

		List<BankAccount> list = bank_dao.fetchAll();
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("admin_home.jsp").include(req, resp);

	}

}
