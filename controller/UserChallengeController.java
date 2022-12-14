package project.controller;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.UserChallengeMapper;
import project.model.UserChallenge;

@RestController
public class UserChallengeController {
	private UserChallengeMapper mapper;
	
	public UserChallengeController(UserChallengeMapper mapper) {
		this.mapper = mapper;
	}
	
	// 참여중인 챌린지 목록
	@PostMapping("/userChallenge/all")
	public List<UserChallenge> getUserChallengeList(@RequestParam("idUser") int idUser) {
		List<UserChallenge> temp = mapper.getUserChallengeList(idUser);
		for (int i = 0; i < temp.size(); i++) {
			String day = temp.get(i).getCertiificationDay();
			String now = LocalDate.now().toString();
			// 오늘 인증을 하지 않았다면 0
			if (!day.equals(now)) {
				temp.get(i).setCertification(0);
			}
		}
		return temp;
	}
	
	// 인증하기
	@PostMapping("/userChallenge/certification")
	public int updateUserChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		UserChallenge temp = mapper.getUserChallenge(idUser, idChallenge);
		int userPostCount = temp.getUserPostCount() + 1;
		
		return mapper.updateCertification(idUser, idChallenge, userPostCount, 1);
	}
	
	// 챌린지 참여하기
	@PostMapping("userChallenge/add")
	public int insertUserChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		int ranking = mapper.getUserChallengeRanking(idChallenge) + 1;
		Date startDate = Date.valueOf(LocalDate.now());
		return mapper.insertUserChallenge(idUser, idChallenge, ranking, startDate);
	}
	// 인증센터 챌린지 불러오기
	@GetMapping("userChallenge/UserChallengeList")
	public List<UserChallengeList> getChallengeInformation(@RequestParam("idUser") int idUser){
		return mapper.getChallengeInformation(idUser);
	}
	
	// 진행중인 챌린지 불러오기
	@GetMapping("userChallenge/processChallenge")
	public List<ChallengeDataList> getUserProgressChallenge(@RequestParam("idUser") int idUser){
		Date nowDate = Date.valueOf(LocalDate.now());
		return mapper.getUserProgressChallenge(idUser, nowDate);
	}
	
	// 완료한 챌린지 불러오기
	@GetMapping("userChallenge/completeChallenge")
	public List<ChallengeDataList> getUserCompleteChallenge(@RequestParam("idUser") int idUser){
		Date nowDate = Date.valueOf(LocalDate.now());
		return mapper.getUserCompleteChallenge(idUser, nowDate);
	}
	
	// 내가 만든 챌린지 불러오기
	@GetMapping("/userChallenge/userUploadChallenge")
	public List<ChallengeDataList> getUserUploadChallenge(@RequestParam("idUser") int idUser){
		return mapper.getUserUploadChallenge(idUser);
	}
}
