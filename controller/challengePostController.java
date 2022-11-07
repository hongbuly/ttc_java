package project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.ChallengePostMapper;
import project.model.ChallengePost;

@RestController
public class ChallengePostController {
	
	private ChallengePostMapper mapper;
	
	public ChallengePostController(ChallengePostMapper mapper) {
		this.mapper = mapper; 
	}
    
	@GetMapping("/challengePost/get")
	public ChallengePost getChallengePost(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		return mapper.getChallengePost(idUser, idChallenge, postPhoto);
	}
	
	@GetMapping("/challengePost/all")
	public List<ChallengePost> getChallengePostList(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		return mapper.getChallengePostList(idUser, idChallenge);
	}
	
	@PostMapping("/challengePost/post")
	public void postUserProfile(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		mapper.insertUserProfile(idUser, idChallenge, postPhoto);
	}
	
	@PutMapping("/challengePost/update")
	public void putUserProfile(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		mapper.updateUserProfile(idUser, idChallenge, postPhoto);
	}
}