package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/Customerlogin")
public class CustomerLogin  extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String cid=req.getParameter("custid");
		int customerid=Integer.parseInt(cid);
		
		String password=req.getParameter("pwd");	
		
		CustomerDao customerDao =new CustomerDao();
		Customer customer=customerDao.login(customerid);
		
		if(customer==null) 
		{
			resp.getWriter().print("<h1>Invalid CUSTOMER_ID</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		}
		else 
		{
			if(customer.getPwd().equals(password)) 
			{
				resp.getWriter().print("<h1>Login Succesfully</h1>");
				//session tracking
				req.getSession().setAttribute("customer", customer);//it is use to store and set the info customer or user which will be used in future
				req.getRequestDispatcher("customer_home.html").include(req, resp);
			}
			else 
			{
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("index.html").include(req, resp);
			}
		}
		
		
		
	}
}
