package project.model;

public class UserProfile {
	private int id;
	private String name;
	private String email;
	private String pw;
	private int level = 1;
	
	public UserProfile(int id, String name, String email, String pw) {
		super();
        this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
	}
    
    public UserProfile(int id, String name, String email, String pw, int level) {
        this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
        this.level = level;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
