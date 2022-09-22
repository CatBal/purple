package purple.dao;

import java.util.Objects;

public class Subscriber {
	private int id;
	private String name;
	private String password;

	public Subscriber() {

	}

	public Subscriber(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Subscriber(int id, String name) {
		this(id, name, null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
