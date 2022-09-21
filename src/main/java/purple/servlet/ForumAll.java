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

/**
 * Servlet implementation class Forum
 */
@WebServlet("/forum")
public class ForumAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/purple")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ForumDao dao = new ForumDao(ds);
		List <Forum> forum = dao.getAll();
		request.setAttribute("forum", forum);
		request.getRequestDispatcher("forum.jsp").forward(request, response);
	}

}
