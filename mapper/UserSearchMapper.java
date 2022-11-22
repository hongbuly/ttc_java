package project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

import project.model.UserSearch;

@Mapper
public interface UserSearchMapper {
		
		@Select("SELECT DISTINCT * FROM userSearch WHERE idUser=#{idUser}")
		List<UserSearch> getUserSearchList(@Param("idUser") int idUser);
		
		@Insert("INSERT INTO userSearch VALUES(#{search}, #{idUser})")
		int insertUserSearch(@Param("idUser") int idUser, @Param("search") String search);
		
}
