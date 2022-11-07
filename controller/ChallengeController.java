package project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.ChallengeMapper;
import project.model.Challenge;

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
	public int deleteChallengeById(@RequestParam("idChallenge") int idChallenge) {
		return mapper.deleteChallengeById(idChallenge);
	}

	// 챌린지 내용 수정

	// 챌린지 등록
	@PostMapping("/challenge/add")
	public void postChallenge(@RequestParam("idChallenge") int idChallenge,
			@RequestParam("nameChallenge") String nameChallenge, @RequestParam("intruduce") String intruduce,
			@RequestParam("imageLink") String imageLink, @RequestParam("frequency") int frequency,
			@RequestParam("possibleStartTime") int possibleStartTime,
			@RequestParam("possibleEndTime") int possibleEndTime, @RequestParam("count") int count,
			@RequestParam("countInterval") String countInterval,
			@RequestParam("challengePostCount") int challengePostCount, @RequestParam("madeIdUser") int madeIdUser) {
		mapper.insertChallenge(idChallenge, nameChallenge, intruduce, imageLink, frequency, possibleStartTime,
				possibleEndTime, count, countInterval, challengePostCount, madeIdUser);
	}
}
