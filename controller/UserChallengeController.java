package project.controller;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
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
		return mapper.getUserChallengeList(idUser);
	}
    
    // 오늘 인증했는지 여부
    @GetMapping("/userChallenge/today")
    public int getUserChallengeToday(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
        Date certificationDate = Date.valueOf(LocalDate.now());
        return mapper.getUserChallengeToday(idUser, idChallenge, certificationDate);
    }
    
    // 인증 날짜
    @GetMapping("/userChallenge/getDate")
    public List<Date> getUserChallengeDate(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
        return mapper.getUserChallengeDate(idUser, idChallenge);
    }
	
	// 인증하기
	@PostMapping("/userChallenge/certification")
	public int insertUserChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		UserChallenge temp = mapper.getUserChallenge(idUser, idChallenge);
		int userPostCount = temp.getUserPostCount() + 1;
        int ranking = temp.getUserChallengeRanking;
        Date certificationDate = Date.valueOf(LocalDate.now());
		Date startDate = temp.getStartDate();
        
        // 오늘 인증을 하지 않았다면
        if (mapper.getUserChallengeToday(idUser, idChallenge, certificationDate) == 0)
		    return mapper.insertCertification(idUser, idChallenge, userPostCount, ranking, certificationDate, startDate);
        else
            return -1;
	}
	
	// 챌린지 참여하기
	@PostMapping("userChallenge/add")
	public int insertUserChallenge(@RequestParam("idUser") int idUser, @RequestParam("idChallenge") int idChallenge) {
		int ranking = mapper.getUserChallengeRanking(idChallenge) + 1;
		Date startDate = Date.valueOf(LocalDate.now());
		return mapper.insertUserChallenge(idUser, idChallenge, ranking, startDate);
	}
}
