package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import project.model.Tag;

@Mapper
public interface TagMapper {
	@Select("SELECT tagName FROM Tag WHERE idTag=#{idTag}")
	Tag getTag(@Param("idTag") int idTag);
	
	@Select("SELECT * FROM Tag")
	List<Tag> getTagList();
}