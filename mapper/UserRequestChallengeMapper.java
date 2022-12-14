package project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRequestChallengeMapper {
	@Insert("INSERT INTO userRequestChallenge VALUES(#{idRequestUser}, #{idChallenge}, #{madeIdUser})")
	int requestChallenge(@Param("idRequestUser") int idRequestUser, @Param("idChallenge") int idChallenge, @Param("madeIdUser") int madeIdUser);
	
	@Delete("DELETE FROM userRequestChallenge WHERE idRequestUser=#{idRequestUser} AND idChallenge=#{idChallenge} AND madeIdUser=#{madeIdUser}")
	int requestDeleteChallenge(@Param("idRequestUser") int idRequestUser, @Param("idChallenge") int idChallenge, @Param("madeIdUser") int madeIdUser);
}