package project.model;

public class UserChallenge {
	private int idUser;
	private int idChallenge;
	private int userPostCount = 0; // 챌린지별 인증한 갯수
	private int ranking = 0;
	private int certification = 0; // 인증 여부
	private String certiificationDay; // 마지막으로 인증한 날짜 "22-11-05"
	public UserChallenge(int idUser, int idChallenge, int ranking) {
		super();
		this.idUser = idUser;
		this.idChallenge = idChallenge;
		this.ranking = ranking;
	}
	
	public int getCertification() {
		return certification;
	}

	public void setCertification(int certification) {
		this.certification = certification;
	}

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}
	public int getUserPostCount() {
		return userPostCount;
	}
	public void setUserPostCount(int userPostCount) {
		this.userPostCount = userPostCount;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getCertiificationDay() {
		return certiificationDay;
	}

	public void setCertiificationDay(String certiificationDay) {
		this.certiificationDay = certiificationDay;
	}
}
