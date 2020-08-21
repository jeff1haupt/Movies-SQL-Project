package Dao;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
=======
import java.util.List;

import Entity.Movie;

public class MovieDao {
>>>>>>> branch 'master' of https://github.com/jeff1haupt/Movies-SQL-Project.git

<<<<<<< HEAD
import Entity.Movie;


public class MovieDao {
	
	private Connection connection;
	private final String CREATE_NEW_MOVIE_QUERY = "INSERT INTO movie(String movieTitle, int movieLength, String releaseDate, String director, \n" + 
			"				String leadActor, String revenue, int genreId) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE_MOVIE_BY_ID_QUERY = "UPDATE movie SET movie_title = ?, movie_length = ?, release_date =?, director =?,"
			+ "lead_actor= ?, revenue =?, genre_id =? WHERE id =?";
	private final String DISPLAY_ALL_MOVIES_QUERY = "SELECT * FROM movie";
	private final String DELETE_MOVIE_BY_ID_QUERY = "DELETE FROM movie WHERE id = ?";
	
	public MovieDao() {
		connection = DBConnection.getConnection();
	}
	
	//1. create a new movie
		public void createMovie(String movieTitle, int movieLength, String releaseDate, String director, 
				String leadActor, String revenue, int genreId) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MOVIE_QUERY);
			ps.setString(1, movieTitle);
			ps.setInt(2, movieLength);
			ps.setString(3, releaseDate);
			ps.setString(4, director);
			ps.setString(5, leadActor);
			ps.setString(6, revenue);
			ps.setInt(7, genreId);
			ps.executeUpdate();
		}
		
	// 2. update a movie
		public void updateMovie(String movieTitle, int movieLength, String releaseDate, String director, 
				String leadActor, String revenue, int genreId) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(UPDATE_MOVIE_BY_ID_QUERY);
			ps.setString(1, movieTitle);
			ps.setInt(2, movieLength);
			ps.setString(3, releaseDate);
			ps.setString(4, director);
			ps.setString(5, leadActor);
			ps.setString(6, revenue);
			ps.setInt(7, genreId);
			ps.executeUpdate();
		}
	
	//3. display all movies
	public List<Movie> getMovie() throws SQLException {
		ResultSet rs = connection.prepareStatement(DISPLAY_ALL_MOVIES_QUERY).executeQuery();
		List<Movie> movies = new ArrayList<Movie>();
		
		return movies;
	}

	//4. delete a movie by id
		public void deleteMovie(int id) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DELETE_MOVIE_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	
=======
	public void addRun(String movieTitle, int movieLength, String releaseDate, String director, String actor,
			String moneyMade) {
		// TODO Auto-generated method stub
		
	}

	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> branch 'master' of https://github.com/jeff1haupt/Movies-SQL-Project.git
}
