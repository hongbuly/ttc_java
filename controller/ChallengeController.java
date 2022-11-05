package project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.ChallengeMapper;
import project.Challenge;

@RestController
public class ChallengeController {
	private ChallengeMapper mapper;
	
	public ChallengeController(ChallengeMapper mapper) {
		this.mapper = mapper;
	}
	
	// 챌린지 전체 검색
	@GetMapping("/challenge/all")
	public List<Challenge> getChallengeList() {
		return mapper.getChallengeList();
	}
	
	// 챌린지 이름 기준 검색
	@PostMapping("/challenge/nameChallenge")
	public Challenge getChallengeByName(@RequestParam("nameChallenge") String nameChallenge) {
		return mapper.getChallengeByName(nameChallenge);
	}
	
	// 챌린지 아이디 기준 검색
	@PostMapping("/challenge/idChallenge")
	public Challenge getChallengeById(@RequestParam("idChallenge") int idChallenge) {
		return mapper.getChallengeById(idChallenge);
	}
	
	// 챌린지 삭제
	@PostMapping("/challenge/idChallenge")
	public Challenge deleteChallengeById(@RequestParam("idChallenge") int idChallenge) {
		return mapper.deleteChallengeById(idChallenge);
	}
	
	// 챌린지 내용 수정
}
