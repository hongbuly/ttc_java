package project.controller;

import java.time.LocalDate;
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
	
	// 李몄뿬以묒씤 梨뚮┛吏� 紐⑸줉
	@PostMapping("/userChallenge/all")
	public List<UserChallenge> getUserChallengeList(@RequestParam("idUser") int idUser) {
		List<UserChallenge> temp = mapper.getUserChallengeList(idUser);
		for (int i = 0; i < temp.size(); i++) {
			String day = temp.get(i).getCertiificationDay();
			String now = LocalDate.now().toString();
			// �삤�뒛 �씤利앹쓣 �븯吏� �븡�븯�떎硫� 0
			if (!day.equals(now)) {
				temp.get(i).setCertification(0);
			}
		}
		return temp;
	}
	
	// �씤利앺븯湲�
	@PostMapping("/userChallenge/certification")
	public int updateUserChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		UserChallenge temp = mapper.getUserChallenge(idUser, idChallenge);
		int userPostCount = temp.getUserPostCount() + 1;
		
		return mapper.updateCertification(idUser, idChallenge, userPostCount, 1);
	}
	
	// 梨뚮┛吏� 李몄뿬�븯湲�
	@PostMapping("/userChallenge/add")
	public int insertUserChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		int ranking = mapper.getUserChallengeRanking(idChallenge) + 1;
		return mapper.insertUserChallenge(idUser, idChallenge, ranking);
	}
	
	// 인증센터 챌린지 불러오기
	@GetMapping("userChallenge/UserChallengeList")
	public List<UserChallengeList> getChallengeInformation(@RequestParam("idUser") int idUser){
		return mapper.getChallengeInformation(idUser);
	}
	
}
