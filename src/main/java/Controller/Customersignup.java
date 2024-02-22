package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/customersignup")
public class Customersignup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String mob = req.getParameter("mob");
		long mobile = Long.parseLong(mob);
		String pwd = req.getParameter("pwd");
		String eid = req.getParameter("email");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");

//		resp.getWriter().println("   name    |      mob      |       pwd       |         eid            |  gender  |      dob       |   ");
//		resp.getWriter().print(name+"        |"+mobile+"        |"+pwd+"          |"+eid+"                 |"+gender+"        |"+dob);
//		resp.getWriter().print("<h1>"+name+"<h1>"
//				+ "<h1>"+mobile+"<h1>"
//				+ "<h1>"+pwd+"<h1>"
//				+ "<h1>"+eid+"<h1>"
//				+ "<h1>"+gender+"<h1>"
//				+ "<h1>"+dob+"<h1>");

		Date date = Date.valueOf(dob);// here it is indicating that we ghave converted successfully String to
										// datevalue-
		Period period = Period.between(date.toLocalDate(), LocalDate.now());

		int age = period.getYears();
		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDao();

		if (age > 18) {

			if (customerDao.check1(eid).isEmpty() && customerDao.check2(mobile).isEmpty()) {
//			resp.getWriter().print("Eligible");
				customer.setCname(name);
				customer.setEmail(eid);
				customer.setGender(gender);
				customer.setMob(mobile);
				customer.setPwd(pwd);
				customer.setDob(date);
				customerDao.save(customer);
				List<Customer> list = customerDao.check1(eid);
				Customer customer1 = list.get(0);

				if (customer1.getGender().equals("female")) {

					resp.getWriter().print("<h1>Hello madam</h1>");
				} else {
					resp.getWriter().print("<h1>Hello sir</h1>");
				}
				resp.getWriter().print(
						"<h1>Account has created Successfully your customerid is :" + customer1.getCid() + "<h1>");
				req.getRequestDispatcher("customer_login.html").include(req, resp);
			} else {
				resp.getWriter().print(
						"<h1>This email id:" + eid + "and this mobile no:" + mob + "is already existed" + "<h1>");
			}

		} else {
			resp.getWriter().print("<h1>He is not eligible for creating bank account<h1>");
		}

	}
}
