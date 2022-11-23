package project.model;

public class UserChallengeCount {
	private int idUser;
	private int progress;
	private int complete;
	private int upload;
	
	public UserChallengeCount(int idUser, int progress, int complete, int upload) {
		super();
		this.idUser = idUser;
        this.progress = progress;
        this.complete = complete;
        this.upload = upload;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public int getUpload() {
		return upload;
	}

	public void setUpload(int upload) {
		this.upload = upload;
	}
}
