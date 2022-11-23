package project.mapper;

import java.util.List;
import java.sql.Date;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import project.model.Challenge;
import project.model.ChallengeMadeUser;
import project.model.ChallengeList;


@Mapper
public interface ChallengeMapper {
	// 챌린지 전체 검색
	@Select("SELECT * FROM challenge")
	List<Challenge> getChallengeList();

	// 챌린지 이름 기준 검색
	@Select("SELECT * FROM challenge WHERE nameChallenge LIKE CONCAT('%', #{nameChallenge}, '%')")
	List<Challenge> getChallengeByName(@Param("nameChallenge") String nameChallenge);

	// 챌린지 아이디 기준 검색
	@Select("SELECT * FROM challenge WHERE idChallenge=#{idChallenge}")
	Challenge getChallengeById(@Param("idChallenge") int idChallenge);

	//챌린지 이름 기준 챌린지+챌린지만든 유저이름 검색
	@Select("SELECT * FROM challenge c JOIN userProfile uf ON c.madeIdUser = uf.id WHERE name=#{name}")
	ChallengeMadeUser getMadeUserNameByName(@Param("name") String name);
	
	//challengeListModel 리턴
	@Select("SELECT * FROM challenge c JOIN userProfile uf ON c.madeIdUser = uf.id JOIN challengeTag ct ON c.idChallenge = ct.idChallenge JOIN tag t ON ct.idTag = t.idTag WHERE nameChallenge LIKE CONCAT('%',#{nameChallenge},'%')")
	List<ChallengeList> getChallengeListByName(@Param("nameChallenge") String nameChallenge);
	
	//찜 챌린지 불러오기
	@Select("SELECT * FROM userFavoriteChallenge uc JOIN challenge c ON uc.idChallenge = c.idChallenge JOIN userProfile u ON c.madeIdUser = u.id JOIN challengeTag ct ON c.idChallenge = ct.idChallenge JOIN tag t ON ct.idTag = t.idTag WHERE idUser=#{idUser}")
	List<ChallengeFavoriteList> getChallengeListByIdUser(@Param("idUser") int idUser);

	// 챌린지 삭제
	@Delete("DELETE FROM challenge WHERE idChallenge=#{idChallenge}")
	int deleteChallengeById(@Param("idChallenge") int idChallenge);

	// 챌린지 내용 수정

	// 챌린지 등록
	@Insert("INSERT INTO challenge VALUES(#{idChallenge}, #{nameChallenge}, #{intruduce}, #{imageLink}, #{frequency}, #{possibleStartTime}, #{possibleEndTime}, #{count}, #{countInterval}, #{challengePostCount}, #{madeIdUser})")
	int insertChallenge(@Param("idChallenge") int idChallenge, @Param("nameChallenge") String nameChallenge,
			@Param("intruduce") String intruduce, @Param("imageLink") String imageLink,
			@Param("frequency") int frequency, @Param("possibleStartTime") int possibleStartTime,
			@Param("possibleEndTime") int possibleEndTime, @Param("count") int count,
			@Param("countInterval") String countInterval, @Param("challengePostCount") int challengePostCount,
			@Param("madeIdUser") int madeIdUser, @Param("endDate") Date endDate);
}
