package tw.cddb.dao.bean;

public class User {
	
	private long id;
	private String name;
	private String password;
	private String role;
	
	public User(long id, String name, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	} 
	public String getName() {
		return name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password.trim();
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
