package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Entity.Genre;
import Entity.Movie;




public class GenreDao {
	private MovieDao MovieDao;
	private RatingDao RatingDoa;
	private Connection connection;
	private final String GET_ALL_GENRES = "SELECT * FROM genre order by id";
	private final String GET_GENRE_QUERY = "SELECT * FROM genre";
	private final String GET_GENRE_BY_ID_QUERY = "SELECT * FROM genre WHERE id = ?";
	private final String CREATE_NEW_GENRE_QUERY = "INSERT INTO genre (genre_name) VALUES(?)";
	private final String DELETE_GENRE_BY_ID_QUERY = "DELETE FROM genre WHERE id = ?";
	

	public GenreDao() {
		connection = DBConnection.getConnection();
		MovieDao = new MovieDao();
	}
	
	public Genre getGenreById(int id) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(GET_GENRE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return new Genre(rs.getInt(1), rs.getString(2));
		 
	}
	
	public void createNewGenre(String genreName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_GENRE_QUERY);
		ps.setString(1, genreName);
		ps.executeUpdate();
	}
	
	public void updateGenre(int updateGenre, String updatedGenre) {
		
	}

	public List<Genre> getAllGenre() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_GENRES).executeQuery();
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()) {
			genres.add(rs.getInt(1), null);
		}
		return genres;
		}

	public String getGenreNameById(int genres) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_GENRE_BY_ID_QUERY);
		ps.setInt(1, genres);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String genreName = rs.getString(2);
		return genreName;
	}
}