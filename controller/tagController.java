import java.util.List;

public class tagController {
	private tagMapper mapper;
	
	public tagController(tagMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/tag/get")
	public tag getTag(@RequestParam("idTag") int idTag) {
		return mapper.getUserProfile(idTag);
	}
	
	@GetMapping("/tag/all")
	public List<tag> getTagList() {
		return mapper.getTagList();
	}
}
