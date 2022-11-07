package project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.UserSearchMapper;
import project.model.UserSearch;

@RestController
public class UserSearchController {
	private UserSearchMapper mapper;
	
	public UserSearchController(UserSearchMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/usersearch/get")
	public List<UserSearch> getUserSearchList(@RequestParam("idUser") int idUser) {
		return mapper.getUserSearchList(idUser);
	}
	
	@PostMapping("/usersearch/add")
	public void postUserSearch(@RequestParam("idUser") int idUser, @RequestParam("search") String search) {
		mapper.insertUserSearch(idUser, search);
	}
	
}
