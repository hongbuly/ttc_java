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
        
	// 게시물 한개 가져오기
	@GetMapping("/challengePost/get")
	public ChallengePost getChallengePost(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		return mapper.getChallengePost(idUser, idChallenge, postPhoto);
	}
	
	// 게시물 전체 가져오기
	@GetMapping("/challengePost/all")
	public List<ChallengePost> getChallengePostList(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		return mapper.getChallengePostList(idUser, idChallenge);
	}
	
	// 챌린지에 사진 올리기
	@PostMapping("/challengePost/post")
	public void postUserProfile(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		mapper.insertUserProfile(idUser, idChallenge, postPhoto);
	}
	
	// 챌린지 사진 수정
	@PutMapping("/challengePost/update")
	public void putUserProfile(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("postPhoto") String postPhoto) {
		mapper.updateUserProfile(idUser, idChallenge, postPhoto);
	}
}
