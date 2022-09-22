package purple.dao;

import java.sql.Timestamp;
import java.util.Objects;

public class Message {
	private int id;
	private String text;
	private Subscriber subscriber;
	private Timestamp timestamp;

	public Message() {

	}

	public Message(int id, String text, Subscriber subscriber, Timestamp timestamp) {
		this.id = id;
		this.text = text;
		this.subscriber = subscriber;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, subscriber, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return id == other.id && Objects.equals(subscriber, other.subscriber) && Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text +  ", timestamp=" + timestamp + "]";
	}

}
