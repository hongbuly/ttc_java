package com.example.androidsever.model;

public class UserSearch {
	private int idUser;
	private String search;
	
	public UserSearch(int idUser, String search) {
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
	public int getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
