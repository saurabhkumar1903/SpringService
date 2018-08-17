package dto;

public class User {
	private int id;
	private String userid;
	private String password;
	
	public User(String userid2, String password2) {
		userid=userid2;
		password=password2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
