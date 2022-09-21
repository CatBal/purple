package purple.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForumDao {
	private static final Logger log = LogManager.getLogger(ForumDao.class);

	private static final String GET_ALL = "SELECT forum_id, name, description FROM forum";

	private DataSource ds;

	public ForumDao(DataSource ds) {
		this.ds = ds;
	}

	public List<Forum> getAll() {
		try (Connection conn = ds.getConnection(); //
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(GET_ALL)) {
			List<Forum> result = new ArrayList<Forum>();
			while (rs.next()) {
				Forum forum = new Forum(rs.getInt(1), rs.getString(2), rs.getString(3));
				result.add(forum);
			}
			return result;
		} catch (SQLException se) {
			log.error("Can't get forum", se);
			throw new IllegalStateException("Database problem!");
		}
	}
}
