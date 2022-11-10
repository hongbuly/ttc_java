package project.model;

public class UserFavoriteChallenge {
	int idUser;
	int idChallenge;
	public UserFavoriteChallenge(int idUser, int idChallenge) {
		super();
		this.idUser = idUser;
		this.idChallenge = idChallenge;
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
}
