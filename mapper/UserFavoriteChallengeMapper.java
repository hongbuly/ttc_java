package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import project.model.UserFavoriteChallenge;

@Mapper
public interface UserFavoriteChallengeMapper {
	
		@Select("SELECT idchallenge from userFavoritechallenge WHERE idUser=#{idUser}")
		List<UserFavoriteChallenge> getUserFavoriteChallenge(@Param("idUser") int idUser);
		
		@Insert("INSERT INTO userfavoritechallenge VALUES(#{idUser}, #{idChallenge})")
		int insertUserFavoriteChallenge(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge);
		
		@Delete("DELETE FROM userfavoritechallenge WHERE idUser=#{idUser} AND idChallenge=#{idChallenge}")
		int deleteUserFavoriteChallenge(@Param("idUser") int idUser, @Param("idChallenge") int idChallenge);
}
