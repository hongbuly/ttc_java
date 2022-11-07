package project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mapper.TagMapper;
import project.model.Tag;

public class TagController {
	private TagMapper mapper;
	
	public TagController(TagMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/tag/get")
	public Tag getTag(@RequestParam("idTag") int idTag) {
		return mapper.getUserProfile(idTag);
	}
	
	@GetMapping("/tag/all")
	public List<Tag> getTagList() {
		return mapper.getTagList();
	}
}
