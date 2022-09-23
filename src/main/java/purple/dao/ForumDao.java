package purple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private static final String GET_ALL_BY_SUBSCRIBER = """
			SELECT f.forum_id, f.name, f.description
			FROM forum f join subscription s
			USING (forum_id)
			WHERE s.subscriber_id = ?""";
	private static final String GET_BY_ID = """
			SELECT forum_id, name, description
			FROM forum
			WHERE forum_id=?""";

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

	/**
	 * get all forum for the current id
	 * 
	 * @param id subscriber id
	 * @return forum list
	 */
	public List<Forum> getAll(int id) {
		try (Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(GET_ALL_BY_SUBSCRIBER)) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
				List<Forum> result = new ArrayList<Forum>();
				while (rs.next()) {
					Forum forum = new Forum(rs.getInt(1), rs.getString(2), rs.getString(3));
					result.add(forum);
				}
				return result;
			}
		} catch (SQLException se) {
			log.error("Can't get forum", se);
			throw new IllegalStateException("Database problem!");
		}
	}

	public Forum get(int id) {
		try (Connection conn = ds.getConnection(); PreparedStatement st = conn.prepareStatement(GET_BY_ID)) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return new Forum(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			}
		} catch (SQLException se) {
			log.error("Can't get forum", se);
		}
		throw new IllegalStateException("Database problem!");
	}
}
