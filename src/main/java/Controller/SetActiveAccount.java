package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setActiveAccount")
public class SetActiveAccount extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String accno = req.getParameter("accno");

		long account_num = Long.parseLong(accno);

		req.getSession().setAttribute("account_num", account_num);
		req.getRequestDispatcher("account_home.html").include(req, resp);

	}

}
