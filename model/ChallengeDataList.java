package project.model;

public class ChallengeDataList {
	private String nameChallenge;
	private String imageLink;
	private int countUser;
	private String name;
	private String tagName1;
	private String tagName2;
	public ChallengeDataList(String nameChallenge, String imageLink, int countUser, String name,
			String tagName1, String tagName2) {
		super();
		this.nameChallenge = nameChallenge;
		this.imageLink = imageLink;
		this.countUser = countUser;
		this.name = name;
		this.tagName1 = tagName1;
		this.tagName2 = tagName2;
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
	public String getTagName1() {
		return tagName1;
	}
	public void setTagName1(String tagName1) {
		this.tagName1 = tagName1;
	}
	public String getTagName2() {
		return tagName2;
	}
	public void setTagName2(String tagName2) {
		this.tagName2 = tagName2;
	}
}
