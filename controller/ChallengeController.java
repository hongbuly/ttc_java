package project.controller;

import java.util.List;

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
	public Challenge getChallengeByName(@RequestParam("nameChallenge") String nameChallenge) {
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
		List<ChallengeList> temp = mapper.getChallengeListByName(nameChallenge);
		List<ChallengeDataList> re = new ArrayList<>();
		for(int i = 0; i<temp.size(); i=i+2) {
			ChallengeDataList reli = new ChallengeDataList(temp.get(i).getNameChallenge(), temp.get(i).getImageLink(), temp.get(i).getCountUser(), temp.get(i).getName(), temp.get(i).getTagName(), temp.get(i+1).getTagName());
			re.add(reli);
		}
		return re;
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
			@RequestParam("challengePostCount") int challengePostCount, @RequestParam("madeIdUser") int madeIdUser) {
		mapper.insertChallenge(idChallenge, nameChallenge, intruduce, imageLink, frequency, possibleStartTime,
				possibleEndTime, count, countInterval, challengePostCount, madeIdUser);
	}
}
