package project.model;

public class Tag {
	int idTag;
	String tagName;
	
	public Tag(int idTag, String tagName) {
		this.idTag = idTag;
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
}
