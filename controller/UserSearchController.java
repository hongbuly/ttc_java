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
	
	//유저 아이디로 유저 최근검색어 불러오기
	@GetMapping("/usersearch/get")
	public List<UserSearch> getUserSearchList(@RequestParam("idUser") int idUser) {
		return mapper.getUserSearchList(idUser);
	}
	
	//유저 최근검색어 추가하기
	@PostMapping("/usersearch/add")
	public void postUserSearch(@RequestParam("idUser") int idUser, @RequestParam("search") String search) {
		if(mapper.getUserSearchByIdSearch(search, idUser).size() > 0) {
			mapper.deleteUserSearch(idUser, search);
			mapper.insertUserSearch(idUser, search);
		}
		else {
			mapper.insertUserSearch(idUser, search);
		}
	}
	
	@DeleteMapping("/usersearch/delete")
	public void deleteUserSearch(@RequestParam("idUser") int idUser, @RequestParam("search") String search) {
		mapper.deleteUserSearch(idUser, search);
	}
	
	@GetMapping("/usersearch/getIdSearch")
	public List<UserSearch> getUserSearchByIdSearch(@RequestParam("search") String search, @RequestParam("idUser") int idUser){
		return mapper.getUserSearchByIdSearch(search, idUser);
	}
	
}
