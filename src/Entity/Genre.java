package Entity;

import java.util.List;

public class Genre {
	private int genreId;
	private String genreName;
	private List<Movie> movies;
	
	public Genre (int genreId, String genreName, List<Movie> movies) {
		this.setGenreId(genreId);
		this.setGenreName(genreName);
		this.setMovies(movies);

}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}