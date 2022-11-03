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
	@Select("SELECT * from user WHERE email=#{email}") //파라미터와 id를 연결할 때는 $가 아니라 #로 표시해야 함.
	UserProfile getUserProfile(@Param("email") String email);
	
	@Select("SELECT * from user")
	List<UserProfile> getUserProfileList();
	
	//insert, update, delete 는 결과로 int값 즉 이 SQL문으로 영향을 받은 레코드 개수가 반환됨.
	@Insert("INSERT INTO user VALUES(#{email}, #{pw}, #{name})")
	int insertUserProfile(@Param("email") String email, @Param("pw") String pw, @Param("name") String name);
	
	@Update("UPDATE user SET pw=#{pw}, name=#{name} WHERE email=#{email}")
	int updateUserProfile(@Param("email") String email, @Param("pw") String pw, @Param("name") String name);
	
}
