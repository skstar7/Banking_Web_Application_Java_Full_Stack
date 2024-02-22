package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		
		BankDao bank_dao=new BankDao();
		
		if(email.equals("admin@gmail.com") && name.equals("admin")) 
		{
			resp.getWriter().print("<h1>Admin_lokkkogin_success</h1>");
			List<BankAccount> list= bank_dao.fetchAll();
			
			//session tracking
			
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("admin_home.jsp").forward(req, resp);
			resp.getWriter().print("<h1>Admin_login_success</h1>");
		}
		else 
		{
			resp.getWriter().print("<h1>Invalid Credentials</h1>");
		}
	}
}
