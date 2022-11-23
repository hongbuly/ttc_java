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
    
    // 오늘 인증 여부
    @Select("SELECT COUNT(*) FROM userChallenge WHERE idUser=#{idUser} AND idChallenge=#{idChallenge} AND certificationDay=#{certificationDay}")
    int getUserChallengeToday(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("certificationDay") Date certificationDay);

    // 인증 날짜
    @Select("SELECT certificationDay FROM userChallenge WHERE idUser=#{idUser} AND idChallenge=#{idChallenge} AND certificationDay IS NOT NULL")
    List<Date> getUserChallengeDate(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge);
    
	// 인증하기
	@Insert("INSERT INTO userChallenge VALUES(#{idUser}, #{idChallenge}, #{userPostCount}, #{ranking}, #{certification}, #{certificationDate}, #{startDate})")
	int insertCertification(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge,
			@Param("userPostCount") int userPostCount, @Param("ranking") int ranking, @Param("certificationDate") Date certificationDate, @Param("startDate") Date startDate);
	
	// 챌린지 참여하기
	@Insert("INSERT INTO userChallenge VALUES(#{idUser}, #{idChallenge}, 0, #{ranking}, null, #{startDate})")
	int insertUserChallenge(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("ranking") int ranking, @Param("startDate") Date startDate);
	
	// 챌린지 참여중인 사람 수 구하기(랭킹)
	@Select("SELECT COUNT(*) FROM userChallenge WHERE idChallenge=#{idChallenge}")
	int getUserChallengeRanking(@Param("idChallenge") int idChallenge);
}
