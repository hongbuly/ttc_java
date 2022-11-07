package project.mapper;

import project.model.ChallengeTag;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface ChallengeTagMapper {
	// 태그 리스트들 가져오기
	@Select("SELECT * FROM challengeTag WHERE idChallenge=#{idChallenge}")
	List<ChallengeTag> getChallengeTagList(@Param("idChallenge") int idChallenge);
	
	// 태그 추가
	@Insert("INSERT INTO challengeTag VALUES(#{idChallenge}, #{idTag})")
	int insertChallengeTag(@Param("idChallenge") int idChallenge, @Param("idTag") int idTag);

	// 태그 삭제
	@Delete("DELETE FROM challengeTag WHERE idChallenge=#{idChallenge} AND idTag=#{idTag}")
	int deleteChallengeTag(@Param("idChallenge") int idChallenge, @Param("idTag") int idTag);
}
