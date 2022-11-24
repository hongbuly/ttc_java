package project.mapper;

import project.model.UserChallenge;

import java.util.List;

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
	@Insert("INSERT INTO userChallenge VALUES(#{idUser}, #{idChallenge}, 0, #{ranking}, 0)")
	int insertUserChallenge(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge, @Param("ranking") int ranking);
	
	// 챌린지 참여중인 사람 수 구하기(랭킹)
	@Select("SELECT COUNT(*) FROM userChallenge WHERE idChallenge=#{idChallenge}")
	int getUserChallengeRanking(@Param("idChallenge") int idChallenge);
	
	// 인증센터 챌린지 불러오기
	@Select("SELECT c.nameChallenge, c.imageLink, up.name FROM userChallenge uc JOIN challenge c ON uc.idChallenge = c.idChallenge JOIN userProfile up ON c.madeIdUser = up.id WHERE idUser = #{idUser}")
	List<UserChallengeList> getChallengeInformation(@Param("idUser") int idUser);
	
	// 참여중인 챌린지 반환
	@Select("SELECT c.nameChallenge, c.imageLink, c.countUser, up.name, t.tagName "
			+ "FROM userChallenge uc JOIN challenge c ON uc.idChallenge = c.idChallenge "
			+ "JOIN userProfile up ON c.madeIdUser = up.id JOIN challengeTag ct ON c.idChallenge = ct.idChallenge "
			+ "JOIN tag t ON ct.idTag = t.idTag  WHERE idUser=#{idUser} AND DATEDIFF(#{nowDate}, uc.startDate) < c.endDate "
			+ "ORDER BY c.idChallenge")
	List<ChallengeList> getUserProgressChallenge(@Param("idUser") int idUser, @Param("nowDate") Date nowDate);
	
	// 완료
	@Select("SELECT c.nameChallenge, c.imageLink, c.countUser, up.name, t.tagName "
			+ "FROM userChallenge u JOIN challenge c ON u.idChallenge = c.idChallenge "
			+ "JOIN userProfile up ON c.madeIdUser = up.id "
			+ "JOIN challengeTag ct ON c.idChallenge = ct.idChallenge "
			+ "JOIN tag t ON ct.idTag = t.idTag "
			+ "WHERE u.idUser=#{idUser} AND DATEDIFF(#{nowDate}, u.startDate) >= c.endDate "
			+ "ORDER BY c.idChallenge")
	List<ChallengeList> getUserCompleteChallenge(@Param("idUser") int idUser, @Param("nowDate") Date nowDate);
	    
	// 내가 개설
	@Select("SELECT c.nameChallenge, c.imageLink, c.countUser, up.name, t.tagName "
			+ "FROM challenge c JOIN userProfile up ON c.madeIdUser = up.id "
			+ "JOIN challengeTag ct ON c.idChallenge = ct.idChallenge "
			+ "JOIN tag t ON ct.idTag = t.idTag "
			+ "WHERE madeIdUser=#{idUser} "
			+ "ORDER BY c.idChallenge")
	List<ChallengeList> getUserUploadChallenge(@Param("idUser") int idUser);
}
