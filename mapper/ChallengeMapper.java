package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import project.model.Challenge;

@Mapper
public interface ChallengeMapper {
	// 챌린지 전체 검색
	@Select("SELECT * FROM challenge")
	List<Challenge> getChallengeList();
	
	// 챌린지 이름 기준 검색
	@Select("SELECT * FROM challenge WHERE nameChallenge=#{nameChallenge}")
	Challenge getChallengeByName(@Param("nameChallenge") String nameChallenge);
	
	// 챌린지 아이디 기준 검색
	@Select("SELECT * FROM challenge WHERE idChallenge=#{idChallenge}")
	Challenge getChallengeById(@Param("idChallenge") int idChallenge);
	
	// 챌린지 삭제
	@Delete("DELETE FROM challenge WHERE idChallenge=#{idChallenge}")
	Challenge deleteChallengeById(@Param("idChallenge") int idChallenge);
	
	// 챌린지 내용 수정
}
