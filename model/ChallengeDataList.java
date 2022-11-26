package project.model;

public class ChallengeDataList {
	private String nameChallenge;
	private String imageLink;
	private int countUser;
	private String name;
	public ChallengeDataList(String nameChallenge, String imageLink, int countUser, String name) {
		super();
		this.nameChallenge = nameChallenge;
		this.imageLink = imageLink;
		this.countUser = countUser;
		this.name = name;
	}
	public String getNameChallenge() {
		return nameChallenge;
	}
	public void setNameChallenge(String nameChallenge) {
		this.nameChallenge = nameChallenge;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public int getCountUser() {
		return countUser;
	}
	public void setCountUser(int countUser) {
		this.countUser = countUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
