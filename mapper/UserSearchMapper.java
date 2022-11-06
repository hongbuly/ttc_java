package project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface UserSearchMapper {
		
		@Select("SELECT * from usersearch WHERE idUser=#{idUser}")
		List<UserProfile> getUserProfileList()(@Param("idUser") int idUser);
		
		@Insert("INSERT INTO usersearch VALUES(#{idUser}, #{search})")
		int insertUserProfile(@Param("idUser") int idUser, @Param("search") String search);
		
}
