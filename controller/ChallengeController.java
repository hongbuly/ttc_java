package project.controller;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.ChallengeMapper;
import project.model.Challenge;
import project.model.ChallengeList;
import project.model.ChallengeMadeUser;
import project.model.ChallengeDataList;

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
	@GetMapping("/challenge/nameChallenge")
	public List<Challenge> getChallengeByName(@RequestParam("nameChallenge") String nameChallenge) {
		return mapper.getChallengeByName(nameChallenge);
	}

	// 챌린지 아이디 기준 검색
	@GetMapping("/challenge/idChallenge")
	public Challenge getChallengeById(@RequestParam("idChallenge") int idChallenge) {
		return mapper.getChallengeById(idChallenge);
	}

	//챌린지 만든 사람 검색
	@GetMapping("/challenge/username")
	public ChallengeMadeUser getMadeUserNameById(@RequestParam("name") String name){
		return mapper.getMadeUserNameByName(name);
	}
	
	// 챌린지 이름 기준 데이터 모델 검색
	@GetMapping("/challenge/challengeList")
	public List<ChallengeDataList> getChallengeListByName(@RequestParam("nameChallenge") String nameChallenge) {
		return mapper.getChallengeListByName(nameChallenge);
		
	}
	
	//찜 챌린지 불러오기
	@GetMapping("/challenge/challengeFavorite")
	public List<ChallengeDataList> getChallengeListByIdUser(@RequestParam("idUser") int idUser) {
		return mapper.getChallengeListByIdUser(idUser);
	}
	
	//모든 챌린지 데이터 리스트 불러오기
	@GetMapping("/challenge/allChallengeDataList")
	public List<ChallengeDataList> getAllChallengeList(){
		return mapper.getAllChallengeList();
	}

	// 챌린지 삭제
	@PostMapping("/challenge/delete")
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
			@RequestParam("challengePostCount") int challengePostCount, 
			@RequestParam("madeIdUser") int madeIdUser, @RequestParam("endDate") Date endDate) {
		mapper.insertChallenge(idChallenge, nameChallenge, intruduce, imageLink, frequency, possibleStartTime,
				possibleEndTime, count, countInterval, challengePostCount, madeIdUser, endDate);
	}
}
