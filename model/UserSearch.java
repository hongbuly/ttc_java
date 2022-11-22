package project.model;

public class UserSearch {
	private int idUser;
	private String search;
	
	public UserSearch(String search, int idUser) {
		super();
		this.idUser = idUser;
		this.search = search;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
