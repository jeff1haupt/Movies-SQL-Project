package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Entity.Genre;




public class GenreDao {
//	private MovieDao MovieDao;
//	private RatingDao RatingDoa;
	private Connection connection;
	private final String GET_GENRE_QUERY = "SELECT * FROM genre";
	private final String GET_GENRE_BY_ID_QUERY = "SELECT * FROM genre WHERE id = ?";
	private final String CREATE_NEW_GENRE_QUERY = "INSERT INTO genre(name) VALUES(?)";
	private final String DELETE_GENRE_BY_ID_QUERY = "DELETE FROM genre WHERE id = ?";
	

	public GenreDao() {
		connection = DBConnection.getConnection();
		//MovieDao = new MovieDao();
	}
	
	public Genre getGenreById(int id) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(GET_GENRE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return new Genre(rs.getInt(1), rs.getString(2), null);
		 
	}

	public void createNewGenre(String genreName) {
		// TODO Auto-generated method stub
		
	}
}


