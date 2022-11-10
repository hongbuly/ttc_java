package com.example.androidsever.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.androidsever.mapper.UserFavoriteChallengeMapper;
import com.example.androidsever.model.UserFavoriteChallenge;

@RestController
public class UserFavoriteChallengeController {
private UserFavoriteChallengeMapper mapper;
	
	public UserFavoriteChallengeController(UserFavoriteChallengeMapper mapper) {
		this.mapper = mapper;
	}
	
	//
	@GetMapping("/UserFavoriteChallenge/all")
	public List<UserFavoriteChallenge> getUserFavoriteChallenge(@RequestParam("idUser") int idUser) {
		return mapper.getUserFavoriteChallenge(idUser);
	}
	
	@PostMapping("UserFavoriteChallenge/post")
	public int insertUserFavoriteChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		return mapper.insertUserFavoriteChallenge(idUser, idChallenge);
	}
	
 	@PostMapping("UserFavoriteChallenge/delete")
 	public int deleteUserFavoriteChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
 		return mapper.deleteUserFavoriteChallenge(idUser, idChallenge);
 	}
}
