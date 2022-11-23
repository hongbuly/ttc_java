package project.model;

import java.sql.Date;

public class ChallengeList {
	private int idChallenge;
	private String nameChallenge;
	private String intruduce;
	private String imageLink;
	private int frequency;
	private int possibleStartTime;
	private int possibleEndTime;
	private int count;
	private String countInterval;
	private int challengePostCount;
	private int madeIdUser;
	private int countUser;
	private Date endTime;
	private int id;
	private String name;
	private String email;
	private String pw;
	private int level;
	private int idChallenge2;
	private int idTag;
	private int idTag2;
	private String tagName;
	public ChallengeList(int idChallenge, String nameChallenge, String intruduce, String imageLink, int frequency,
			int possibleStartTime, int possibleEndTime, int count, String countInterval, int challengePostCount,
			int madeIdUser, int countUser, Date endTime, int id, String name, String email, String pw, int level,
			int idChallenge2, int idTag, int idTag2, String tagName) {
		super();
		this.idChallenge = idChallenge;
		this.nameChallenge = nameChallenge;
		this.intruduce = intruduce;
		this.imageLink = imageLink;
		this.frequency = frequency;
		this.possibleStartTime = possibleStartTime;
		this.possibleEndTime = possibleEndTime;
		this.count = count;
		this.countInterval = countInterval;
		this.challengePostCount = challengePostCount;
		this.madeIdUser = madeIdUser;
		this.countUser = countUser;
		this.endTime = endTime;
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.level = level;
		this.idChallenge2 = idChallenge2;
		this.idTag = idTag;
		this.idTag2 = idTag2;
		this.tagName = tagName;
	}
	public int getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}
	public String getNameChallenge() {
		return nameChallenge;
	}
	public void setNameChallenge(String nameChallenge) {
		this.nameChallenge = nameChallenge;
	}
	public String getIntruduce() {
		return intruduce;
	}
	public void setIntruduce(String intruduce) {
		this.intruduce = intruduce;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getPossibleStartTime() {
		return possibleStartTime;
	}
	public void setPossibleStartTime(int possibleStartTime) {
		this.possibleStartTime = possibleStartTime;
	}
	public int getPossibleEndTime() {
		return possibleEndTime;
	}
	public void setPossibleEndTime(int possibleEndTime) {
		this.possibleEndTime = possibleEndTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCountInterval() {
		return countInterval;
	}
	public void setCountInterval(String countInterval) {
		this.countInterval = countInterval;
	}
	public int getChallengePostCount() {
		return challengePostCount;
	}
	public void setChallengePostCount(int challengePostCount) {
		this.challengePostCount = challengePostCount;
	}
	public int getMadeIdUser() {
		return madeIdUser;
	}
	public void setMadeIdUser(int madeIdUser) {
		this.madeIdUser = madeIdUser;
	}
	public int getCountUser() {
		return countUser;
	}
	public void setCountUser(int countUser) {
		this.countUser = countUser;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getIdChallenge2() {
		return idChallenge2;
	}
	public void setIdChallenge2(int idChallenge2) {
		this.idChallenge2 = idChallenge2;
	}
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
	public int getIdTag2() {
		return idTag2;
	}
	public void setIdTag2(int idTag2) {
		this.idTag2 = idTag2;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}