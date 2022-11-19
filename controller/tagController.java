package project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.TagMapper;
import project.model.Tag;

@RestController
public class TagController {
	private TagMapper mapper;
	
	public TagController(TagMapper mapper) {
		this.mapper = mapper;
	}
	
    // idTag로 해당 태그 이름 가져오기
	@PostMapping("/tag/get")
	public Tag getTag(@RequestParam("idTag") int idTag) {
		return mapper.getTag(idTag);
	}
	
    // 전체 태그 불러오기
	@GetMapping("/tag/all")
	public List<Tag> getTagList() {
		return mapper.getTagList();
	}
	
    // idChallenge로 해당 태그 가져오기
	@GetMapping("/tag/tagChallenge")
	public List<Tag> getTagByChallengeId(@RequestParam("idChallenge") int idChallenge){
		return mapper.getTagByChallengeId(idChallenge);
	}
}
