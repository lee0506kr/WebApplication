package model;

public class Message {
	private int id; //id 는 int형 으로 선언
	private String name; // name 은 string 형으로 선언
	private String password; //password를 String 형으로 선언
	private String message;
	
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", password=" + password + ", message=" + message + "]";
	}
	
}
