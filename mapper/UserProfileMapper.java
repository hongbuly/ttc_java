package project.mapper;

import project.model.UserProfile;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserProfileMapper {
	//getUserProfile를 호출했을 때 이 SQL문이 실행되어 UserProfile형태로 데이터를 가져옴
	@Select("SELECT * from userProfile WHERE email=#{email}") // 파라미터와 id를 연결할 때는 $가 아니라 #로 표시해야 함.
	UserProfile getUserProfile(@Param("email") String email);
	
	@Select("SELECT * from userProfile")
	List<UserProfile> getUserProfileList();
	
	// insert, update, delete 는 결과로 int값 즉 이 SQL문으로 영향을 받은 레코드 개수가 반환됨.
	// 회원가입
	@Insert("INSERT INTO userProfile VALUES(#{id}, #{name}, #{email}, #{pw}, #{level})")
	int insertUserProfile(@Param("id") int id, @Param("name") String name, @Param("email") String email, @Param("pw") String pw, @Param("level") int level);
	
	// 비번과 이름 변경 가능
	@Update("UPDATE userProfile SET name=#{name}, pw=#{pw} WHERE email=#{email}")
	int updateUserProfile(@Param("email") String email, @Param("pw") String pw, @Param("name") String name);
	
	// 이메일과 비번이 맞다면 행 개수 1개가 리턴될 것임.
	@Select("SELECT COUNT(*) from userProfile WHERE email=#{email} AND pw=#{pw}")
	int getUserLogin(@Param("email") String email, @Param("pw") String pw);
	
	// level 올리기.
	@Update("UPDATE userProfile SET level=#{level} WHERE email=#{email}")
	int updateUserLevel(@Param("email") String email, @Param("level") int level);
}
