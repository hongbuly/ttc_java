package project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.mapper.UserRequestChallengeMapper;

@RestController
public class UserRequestChallengeController {
	
	private UserRequestChallengeMapper mapper;
	
	public UserRequestChallengeController(UserRequestChallengeMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostMapping("/request/add")
	public int requestChallenge(@RequestParam("idRequestUser") int idRequestUser, @RequestParam("idChallenge") int idChallenge, @RequestParam int madeIdUser) {
		return mapper.requestChallenge(idRequestUser, idChallenge, madeIdUser);
	}
	
	@DeleteMapping("/request/delete")
	public int requestDeleteChallenge(@RequestParam("idRequestUser") int idRequestUser, @RequestParam("idChallenge") int idChallenge, @RequestParam("madeIdUser") int madeIdUser) {
		return mapper.requestDeleteChallenge(idRequestUser, idChallenge, madeIdUser);
	}
}