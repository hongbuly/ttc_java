package project.controller;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.UserChallengeCountMapper;
import project.mapper.UserChallengeCountMapper;
import project.model.UserChallenge;
import project.model.UserChallengeCount;

@RestController
public class UserChallengeCountController {
	private UserChallengeCountMapper mapper;
	
	public UserChallengeCountController(UserChallengeCountMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/userChallenge/getRef")
	public UserChallengeCount getUserChallengeCount(@RequestParam int idUser) {
		// 진행
		int progress = mapper.getUserProgressCount(idUser);
		
		// 완료
		Date nowDate = Date.valueOf(LocalDate.now());
		int complete = mapper.getUserCompleteCount(idUser, nowDate);
				
		// 내가 업로드
		int upload = mapper.getUserUploadCount(idUser);
		
		UserChallengeCount u = new UserChallengeCount(idUser, progress, complete, upload);
		return u;
	}
}
