package project.model;

public class UserRequestChallenge {
	int idRequestUser;
	int idChallenge;
	int madeIdUser;
	public UserRequestChallenge(int idRequestUser, int idChallenge, int madeIdUser) {
		super();
		this.idRequestUser = idRequestUser;
		this.idChallenge = idChallenge;
		this.madeIdUser = madeIdUser;
	}
	public int getIdRequestUser() {
		return idRequestUser;
	}
	public void setIdRequestUser(int idRequestUser) {
		this.idRequestUser = idRequestUser;
	}
	public int getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}
	public int getMadeIdUser() {
		return madeIdUser;
	}
	public void setMadeIdUser(int madeIdUser) {
		this.madeIdUser = madeIdUser;
	}
	
}