package purple.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import purple.dao.Subscriber;
import purple.dao.SubscriberDao;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/purple")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = "registration.jsp";
		if (username != null && password != null && !username.isBlank() && !password.isBlank()) {
			SubscriberDao dao = new SubscriberDao(ds);
			Subscriber user = dao.insert(username, password);
			if (user != null) {
				url = "index.html";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
