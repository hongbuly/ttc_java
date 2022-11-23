package project.model;

public class UserChallengeList {
	String nameChallenge;
	String imageLink;
	String name;
	public UserChallengeList(String nameChallenge, String imageLink, String name) {
		super();
		this.nameChallenge = nameChallenge;
		this.imageLink = imageLink;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}