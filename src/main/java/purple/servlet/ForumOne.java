package purple.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import purple.dao.Forum;
import purple.dao.ForumDao;
import purple.dao.Message;
import purple.dao.MessageDao;

/**
 * Servlet implementation class ForumOne
 */
@WebServlet("/forum/get") // per andare ad un singolo forum
public class ForumOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/purple")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		MessageDao messageDao = new MessageDao(ds);
		List<Message> messages = messageDao.getMessages(id);
		request.setAttribute("messages", messages);
		ForumDao forumDao = new ForumDao(ds);
		Forum forum = forumDao.get(id);
		request.setAttribute("forum", forum);
		request.getRequestDispatcher("/forumMessages.jsp").forward(request, response);
	}

}
