package pojo;

public class LoginUser {
	
	private int userId;
	private String userName;
	private String passWord;
	
	
	
	public LoginUser(int userId, String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "LoginUser [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
}
