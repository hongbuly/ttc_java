package project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.sql.Date;

@Mapper
public interface UserChallengeCountMapper {
    // 참여중인 챌린지 갯수 / 진행
	@Select("SELECT COUNT(*) FROM userChallenge WHERE idUser=#{idUser}")
	int getUserProgressCount(@Param("idUser") int idUser);
    
    // 완료
	@Select("SELECT COUNT(*) FROM userChallenge u INNER JOIN challenge c ON u.idChallenge = c.idChallenge WHERE u.idUser=#{idUser} AND DATEDIFF(u.startDate, #{nowDate}) > c.endDate")
	int getUserCompleteCount(@Param("idUser") int idUser, @Param("nowDate") Date nowDate);
    
    // 내가 개설
    @Select("SELECT COUNT(*) FROM challenge WHERE madeIdUser=#{idUser}")
    int getUserUploadCount(@Param("idUser") int idUser);
}
