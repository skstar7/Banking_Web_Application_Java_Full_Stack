package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogOut extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().invalidate(); // it is use to destory or kill the seassion which has been created  // removeAttribut ealso work

		resp.getWriter().print("<h1> Log out succesfull </h1>");

		req.getRequestDispatcher("index.html").include(req, resp);
	}
}