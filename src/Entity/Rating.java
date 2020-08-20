package Entity;

import java.util.List;

public class Rating {
	
	private int ratingId;
	private int starRating;
	private List<Movie> movies;
	
	public Rating (int ratingId, int starRating, List<Movie> movies) {
		this.setRatingId(ratingId);
		this.setStarRating(starRating);
		this.setMovies(movies);

}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}