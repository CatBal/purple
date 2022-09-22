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
				Message message = new Message(rs.getSubscriber(1), rs.getString(2), rs.getTimestamp(3));
				result.add(message);
			}
			return result;
		} catch (SQLException se) {
			log.error("Can't get message", se);
			throw new IllegalStateException("Database problem!");
		}
	}
}
