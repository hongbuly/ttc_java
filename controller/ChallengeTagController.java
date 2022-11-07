package com.example.androidsever.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.androidsever.mapper.ChallengeTagMapper;
import com.example.androidsever.model.ChallengeTag;

@RestController
public class ChallengeTagController {
	private ChallengeTagMapper mapper;
	
	public ChallengeTagController(ChallengeTagMapper mapper) {
		this.mapper = mapper;
	}
	
	// 태그 리스트들 가져오기
	@PostMapping("/tag/all")
	public List<ChallengeTag> getChallengeTag(@RequestParam("idChallenge") int idChallenge) {
		return mapper.getChallengeTagList(idChallenge);
	}
	
	// 태그 추가
	@PostMapping("/tag/add")
	public int insertChallengeTag(@RequestParam("idChallenge") int idChallenge, @RequestParam("idTag") int idTag) {
		return mapper.insertChallengeTag(idChallenge, idTag);
	}
	
	// 태그 삭제
	@PostMapping("/tag/delete")
	public int deleteChallengeTag(@RequestParam("idChallenge") int idChallenge, @RequestParam("idTag") int idTag) {
		return mapper.deleteChallengeTag(idChallenge, idTag);
	}
}
