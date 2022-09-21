package purple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubscriberDao {
	private static final Logger log = LogManager.getLogger(SubscriberDao.class);

	private static final String GET_BY_NAME_AND_PASSWORD = """
			SELECT subscriber_id, name, password
			FROM subscriber
			WHERE name = ? AND password = ?""";

	private DataSource ds;

	public SubscriberDao(DataSource ds) {
		this.ds = ds;
	}

	public Subscriber getSubscriber(String name, String password) {
		try (Connection conn = ds.getConnection(); //
				PreparedStatement ps = conn.prepareStatement(GET_BY_NAME_AND_PASSWORD)) {
			ps.setString(1, name);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Subscriber(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			}
		} catch (SQLException se) {
			log.error("Can't get subscriber " + name, se);
		}

		return null;
	}
}
