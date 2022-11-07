package project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.UserProfileMapper;
import project.model.UserProfile;

@RestController
public class ChallengeController {
	
	private ChallengePostMapper mapper;
	
	public ChallengePostMapper(ChallengePostMapper mapper) {
		this.mapper = mapper; 
	}
    
	@GetMapping("/challengePost/get")
	public ChallengePost getchallengePost(@RequestParam("idUser") int idUser, @RequestParam("idchallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		return mapper.getchallengePost(idUser, idChallenge, postPhoto);
	}
	
	@GetMapping("/challengePost/all")
	public List<ChallengePost> getchallengePostList() {
		return mapper.getchallengePostList();
	}
	
	@PostMapping("/challengePost/post")
	public void postUserProfile(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		mapper.insertUserProfile(idUser, idChallenge, postPhoto);
	}
	
	@PutMapping("/challengePost/update")
	public void putUserProfile(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		mapper.updateUserProfile(idUser, idChallenge, postPhoto);
	}