package purple.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import purple.dao.Subscriber;
import purple.dao.SubscriberDao;

/**
 * Login management, we expect user to pass us parameters using username and
 * password
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(Login.class);

	@Resource(name = "jdbc/purple")
	private DataSource ds;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		log.trace(username);

		SubscriberDao dao = new SubscriberDao(ds);
		Subscriber user = dao.getSubscriber(username, password);
		if (user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("logged.jsp").forward(request, response);
		}
	}
}
