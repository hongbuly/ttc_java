package project.model;

public class ChallengeTag {
	private int idChallenge;
	private int idTag;
	public ChallengeTag(int idChallenge, int idTag) {
		super();
		this.idChallenge = idChallenge;
		this.idTag = idTag;
	}
	public int getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
}
