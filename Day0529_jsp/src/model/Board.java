package model;

public class Board {

	private String name;
	private String pass;
	private String email;
	private String title;
	private String content;

	public Board() {

	}

	public Board(String name, String pass, String email, String title, String content) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.content = content;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [name=" + name + ", pass=" + pass + ", email=" + email + ", title=" + title + ", content="
				+ content + "]";
	}

}
