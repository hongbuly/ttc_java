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
public interface tagMapper {
	@Select("SELECT * FROM Tag WHERE idTag=#{idTag}")
	Tag getTag(@Param("idTag") int idTag);
	
	@Select("SELECT tagName FROM Tag")
	List<Tag> getTagList();
	
	@Select("SELECT * FROM challenge c JOIN challengeTag ct ON c.idChallenge = ct.idChallenge JOIN tag t ON ct.idTag = t.idTag WHERE c.idChallenge=#{idChallenge} ")
	List<Tag> getTagByChallengeId(@Param("idChallenge") int idChallenge);
}
