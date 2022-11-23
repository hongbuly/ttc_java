package project.model;

public class Challenge {
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
	private int endDate;

	public Challenge(int idChallenge, String nameChallenge, String intruduce, String imageLink, int frequency,
			int possibleStartTime, int possibleEndTime, int count, String countInterval, int challengePostCount,
			int madeIdUser, int countUser, int endDate) {
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
		this.endDate = endDate;
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
	
}