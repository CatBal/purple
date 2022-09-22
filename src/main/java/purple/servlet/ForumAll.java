package purple.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import purple.dao.Forum;
import purple.dao.ForumDao;
import purple.dao.Subscriber;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/forum")
public class ForumAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/purple")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Subscriber user = (Subscriber) session.getAttribute("user");
		ForumDao dao = new ForumDao(ds);
		List<Forum> forum = dao.getAll();
		if (user == null) {
			request.setAttribute("forum", forum);
		} else {
			List<Forum> myForum = dao.getAll(user.getId());
			List<Forum> otherForum = new ArrayList<Forum>(forum);
			otherForum.removeAll(myForum);
			request.setAttribute("myForum", myForum);
			request.setAttribute("otherForum", otherForum);
		}

		request.getRequestDispatcher("forum.jsp").forward(request, response);
	}

}
