package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Genre;
import Entity.Rating;

public class RatingDao {
	
	private Connection connection; 
	private final String CREATE_NEW_RATING = "INSERT INTO rating (rating_scale) VALUE (?)";
	private final String GET_ALL_RATINGS = "SELECT * FROM rating";
	
	public RatingDao() {
		connection = DBConnection.getConnection();
	}

	public void createNewRating(String ratingScale) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_RATING);
		ps.setString(1, ratingScale);
		ps.executeUpdate();
		System.out.println("You have successfully added " + ratingScale + " to the list of possible ratings.");
	}
		

	public void updateRatingById(int ratingId, int starRating) {
		// TODO Auto-generated method stub
		
	}

	public List<Rating> getAllRatings() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_RATINGS).executeQuery();
		List<Rating> ratings = new ArrayList<Rating>();
		while(rs.next()) {
			ratings.add(populateRatings(rs.getInt(1), rs.getString(2)));
		}
		return ratings;
		}

	private Rating populateRatings(int int1, String string) {
		// TODO Auto-generated method stub
		return new Rating(int1, string);
	}
}
	

