package project.controller;

import java.util.List;

@RestController
public class UserSearchController {
private UserSearchMapper mapper;
	
	public UserSearchController(UserSearchMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/usersearch/get")
	public List<UserSearch> getUserSearchList() {
		return mapper.getUserSearchList();
	}
	
	@PostMapping("/usersearch/add")
	public void postUserSearch(@RequestParam("search") String search) {
		mapper.insertUserSearch(search);
	}
	
}
