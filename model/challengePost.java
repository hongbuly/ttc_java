
public class challengePost {
	String postPhoto;
	int idUser;
	int idChallenge;
	public challengePost(String postPhoto, int idUser, int idChallenge) {
		super();
		this.postPhoto = postPhoto;
		this.idUser = idUser;
		this.idChallenge = idChallenge;
	}
	public String getPostPhoto() {
		return postPhoto;
	}
	public void setPostPhoto(String postPhoto) {
		this.postPhoto = postPhoto;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getidChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(String idChallenge) {
		this.idChallenge = idChallenge;
	}
	
}
