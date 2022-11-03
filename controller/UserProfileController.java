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
	
	//생성자. mapper를 전달받아서 private변수에 설정함.
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper; //전달받은 mapper 로 api를 호출 가능.
	}
    
    @GetMapping("/connect")
    public String getConnectText() {
        return "연결 되었습니다!";
    }
	
	@GetMapping("/user/{email}")
	public UserProfile getUserProfile(@PathVariable("email") String email) {
		return mapper.getUserProfile(email);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return mapper.getUserProfileList();
	}
	
	//데이터 생성
	@PostMapping("/user/{email}")
	public void postUserProfile(@PathVariable("email") String email, @RequestParam("pw") String pw, @RequestParam("name") String name) {
		mapper.insertUserProfile(email, pw, name);
	}
	
	//데이터 수정
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("email") String email, @RequestParam("pw") String pw, @RequestParam("name") String name) {
		mapper.updateUserProfile(email, pw, name);
	}
	
}