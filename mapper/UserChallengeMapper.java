package project.mapper;

import project.model.UserChallenge;

import java.util.List;
import java.sql.Date;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserChallengeMapper {
	// 참여중인 챌린지 목록
	@Select("SELECT * FROM userChallenge WHERE idUser=#{idUser}")
	List<UserChallenge> getUserChallengeList(@Param("idUser") int idUser);

	// 챌린지에 대한 나의 레벨과 인증 정보
	@Select("SELECT * FROM userChallenge WHERE idUser=#{idUser} AND idChallenge=#{idChallenge}")
	UserChallenge getUserChallenge(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge);

	// 인증하기
	@Update("UPDATE userChallenge SET userPostCount=#{userPostCount}, certification=#{certification} WHERE idUser=#{idUser}")
	int updateCertification(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge,
			@Param("userPostCount") int userPostCount, @Param("certification") int certification);
	
	// 챌린지 참여하기
	@Insert("INSERT INTO userChallenge VALUES(#{idUser}, #{idChallenge}, 0, #{ranking}, 0, null, #{startDate})")
	int insertUserChallenge(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("ranking") int ranking, @Param("startDate") Date startDate);
	
	// 챌린지 참여중인 사람 수 구하기(랭킹)
	@Select("SELECT COUNT(*) FROM userChallenge WHERE idChallenge=#{idChallenge}")
	int getUserChallengeRanking(@Param("idChallenge") int idChallenge);
}
