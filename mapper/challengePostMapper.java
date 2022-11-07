package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ChallengePostMapper {
	
	@Select("SELECT * FROM challengePost WHERE idUser=#{idUser} AND idChallenge=#{idChallenge} AND postChallenge=#{postChallenge}") 
	challengePost getchallengePost(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("postChallenge") String postChallenge);
	
	@Select("SELECT * FROM challengePost WHERE idUser=#{idUser} AND idChallenge=#{idChallenge}")
	List<challengePost> getchallengePostList()(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge);
	
	@Insert("INSERT INTO user VALUES(#{idUser}, #{idChallenge}, #{postChallenge})")
	int insertUserProfile(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("postChallenge") String postChallenge);
	
	@Update("UPDATE user SET idUser=#{idUser} AND idChallenge=#{idChallenge} AND postChallenge=#{postChallenge}")
	int updateUserProfile(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("postChallenge") String postChallenge);
	
}
