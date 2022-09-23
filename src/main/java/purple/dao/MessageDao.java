package purple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageDao {
	private static final Logger log = LogManager.getLogger(MessageDao.class);

	private static final String GET_BY_FORUM_ORDERED = """
			SELECT m.message_id, m.text, s.name, s.subscriber_id, m.timestamp
			FROM message m JOIN subscriber s
			USING (subscriber_id)
			ORDER by m.timestamp""";

	private static final String GET_BY_FORUM_ID = """
			SELECT m.message_id, m.text, m.creation, m.subscriber_id, s.name
			FROM message m join subscriber s
			USING (subscriber_id)
			WHERE forum_id = ?""";

	private DataSource ds;

	public MessageDao(DataSource ds) {
		this.ds = ds;
	}

	public List<Message> getMessage(Subscriber subscriber, String text, Timestamp timestamp) {
		try (Connection conn = ds.getConnection(); //
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(GET_BY_FORUM_ORDERED)) {
			List<Message> result = new ArrayList<Message>();
			while (rs.next()) {
				Subscriber s = new Subscriber(rs.getInt(4), rs.getString(3));
				Message message = new Message(rs.getInt(1), rs.getString(2), s, rs.getTimestamp(5));
				result.add(message);
			}
			return result;
		} catch (SQLException se) {
			log.error("Can't get message", se);
			throw new IllegalStateException("Database problem!");
		}
	}

	public List<Message> getMessages(int forumId) {
		try (Connection conn = ds.getConnection(); PreparedStatement st = conn.prepareStatement(GET_BY_FORUM_ID)) {
			st.setInt(1, forumId);
			try (ResultSet rs = st.executeQuery()) {
				List<Message> result = new ArrayList<Message>();
				while (rs.next()) {
					Subscriber sub = new Subscriber(rs.getInt(4), rs.getString(5));
					Message message = new Message(rs.getInt(1), rs.getString(2), sub, rs.getTimestamp(3));
					result.add(message);
				}
				return result;
			}
		} catch (SQLException se) {
			log.error("Can't get messages", se);
			throw new IllegalStateException("Database problem!");
		}
	}
}
