package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface tagMapper {
	
	@Select("SELECT tagName from tag WHERE idTag=#{idTag}")
	UserProfile getTag(@Param("idTag") int idTag);
	
	@Select("SELECT tagName from tag")
	List<tag> getTagList();
	
	
}

