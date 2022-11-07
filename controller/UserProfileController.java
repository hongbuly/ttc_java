package project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.UserProfileMapper;
import project.model.UserProfile;

@RestController
public class UserProfileController {
	private UserProfileMapper mapper;

	// 생성자. mapper를 전달받아서 private변수에 설정함.
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper; // 전달받은 mapper 로 api를 호출 가능.
	}

	// 유저 리스트 얻기
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return mapper.getUserProfileList();
	}

	// 이메일로 해당 유저 정보 얻기
	@PostMapping("/user/email")
	public UserProfile getUserProfile(@RequestParam("email") String email) {
		return mapper.getUserProfile(email);
	}

	// 유저 회원가입
	@PostMapping("/user/add")
	public void postUserProfile(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("pw") String pw) {
		mapper.insertUserProfile(id, name, email, pw, 1);
	}

	// 로그인이 되면 1, 아니면 0
	@PostMapping("/user/login")
	public int postUserProfile(@RequestParam("email") String email, @RequestParam("pw") String pw) {
		return mapper.getUserLogin(email, pw);
	}
	
	@PostMapping("/user/levelUp")
	public int postUserLevel(@RequestParam("email") String email, @RequestParam("level") int level) {
		return mapper.updateUserLevel(email, level);
	}
}