package Dao;

import java.sql.Connection;

public class RatingDao {
	
	private Connection connection; 
	
	public RatingDao() {
		connection = DBConnection.getConnection();
	}

	public void createNewRating(int movieId, int starRating) {
		// TODO Auto-generated method stub
		
	}

	public void updateRatingById(int ratingId, int starRating) {
		// TODO Auto-generated method stub
		
	}
	

}
