package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.BankAccount;
import Dto.Customer;

@WebServlet("/createbankaccount")
public class CreateBankAccount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc_type = req.getParameter("accounttype");
		Customer customer = (Customer) req.getSession().getAttribute("customer");

		// list_of_Customer_bank_Account_type present inside a customer

		List<BankAccount> list_bank_Account_type = customer.getBankaccounts();

		boolean flag = true;

		// System.out.println(account_Type);

		// this for each loop use for checking the account type already present with
		// customer or not?

		for (BankAccount bank_account : list_bank_Account_type) {
//	    	 String acc_type=bank_account.getAccount_Type();
//	    	 
//	    	 System.out.println(acc_type);
//	    	 System.out.println(acc_type.equals(account_Type));

			if (bank_account.getAcc_type().equals(acc_type)) {
				// System.out.println(account_Type);
				flag = false;
				// System.out.println(flag);
				break;
			}

		}

		if (flag == true) {
			BankAccount bank_account = new BankAccount();

			// bank_account.setAccount_No();
			// bank_account.setStatus();
			// bank_account.setAmount(0);

			bank_account.setAcc_type(acc_type);

			if (bank_account.getAcc_type().equals("savings")) {
				bank_account.setAcc_limit(10000);
			} else {
				bank_account.setAcc_limit(15000);
			}

			bank_account.setCustomer(customer);

			BankDao bankDao = new BankDao();
			bankDao.save_Account(bank_account);

			// list_of_Customer_bank_Account_type present inside a customer
			// if savings already exist then curent account wiil be created for same
			// customer
			// if current already exist then savings account wiil be created for same
			// customer
			// if savings or current acccount not present for a customer then savings or
			// current account will be created based radio button selected in account type
			// ui

			List<BankAccount> update_list_bank_Account_type = list_bank_Account_type;
			update_list_bank_Account_type.add(bank_account);

			customer.setBankaccounts(update_list_bank_Account_type);

			CustomerDao customerDao = new CustomerDao();
			customerDao.update(customer);
			req.getSession().setAttribute("customer", customerDao.findById(customer.getCid()));
			resp.getWriter()
					.print("<h1>Congratulation your " + acc_type + " bank account has created successfully" + "</h1>");

		}

		else {
			resp.getWriter().print("<h1>Your account type is already exist for same customer id.</h1>");
			// System.out.println("account type already exist");
		}
	}
}
