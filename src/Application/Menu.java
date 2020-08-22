package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Dao.GenreDao;
import Dao.MovieDao;
import Dao.RatingDao;
import Entity.Movie;
import Entity.Genre;
import Entity.Rating;

import Dao.MovieDao;

public class Menu {



	private GenreDao genreDao = new GenreDao();
	private MovieDao movieDao = new MovieDao();
	//private RatingDao ratingDao = new RatingDao();

	Scanner intScanner = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Create a movie",
			"Update a movie by id",
			"Display a list of all movies", 
			"Delete a movie by id", 
			"Create a genre",
			"Update a genre by id",
			"Display all movies by genre",
			"Delete a genre by id",
			"Create a rating by movie id",
			"Update rating by id",
			"Display all movies by number of stars",
			"Delete a rating",
			"Get Genre By ID",
			"Close App");
	
	public void start() throws SQLException {
		
		String userSelection = "";
		
		do {
			
			displayMenu();
			userSelection = scanner.nextLine();
			
			if ( userSelection.equals("1") ) {
				createMovie();
			} else if ( userSelection.equals("2") ) {
				updateMovie();
			} else if ( userSelection.equals("3") ) {
				displayAllMovies();
			} else if ( userSelection.equals("4") ) {
				deleteMovie();
			} else if ( userSelection.equals("5") ) {
				createGenre();
			} else if ( userSelection.equals("6") ) {
				updateGenre();
			} else if ( userSelection.equals("7") ) {
				displayAllMoviesByGenre();
			} else if ( userSelection.equals("8") ) {
				deleteGenre();
			} else if ( userSelection.equals("9") ) {
				//createRating();
			} else if ( userSelection.equals("10") ) {
				//updateRating();
			} else if ( userSelection.equals("11") ) {
				displayAllMoviesByRating();
			} else if ( userSelection.equals("12") ) {
				//deleteRating();
			} else if (userSelection.equals("13")) {
				getGenreByIdMenu();
			} else if ( userSelection.equals("0") ) {
				closeApp();
			} 
			
			System.out.println("Press enter to continue....\n ");
			scanner.nextLine();
			
		} while (!userSelection.equals("0"));
		
	}

	private void getGenreByIdMenu() throws SQLException {
		System.out.println("Enter the genre id: \n");
		int id = scanner.nextInt();
		genreDao.getGenreById(id);
	}

	private void displayMenu() {
		
		System.out.println("Select an option: \n------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			if ( i == options.size()-1 ) {
				System.out.println("0) " + options.get(i));
			} else {
				System.out.println((i+1) + ") " + options.get(i));
			}
		}
		
	}
	
	// Need to finish and potential add more methods 
	private void closeApp() {
		System.out.println("\n\n---------------------------------------\n");
		System.out.println("Thank you for using the application");
		System.exit(0);
	}
	
	private void createMovie() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter the movie title: \n");
		String movieTitle = scanner.nextLine();
		System.out.println("Enter the total length in minutes: \n");
		int movieLength = intScanner.nextInt();
		System.out.println("Enter the release date: \n");
		String releaseDate = scanner.nextLine();
		System.out.println("Enter movie's director: \n");
		String director = scanner.nextLine();
		System.out.println("Enter movie's actor: \n");
		String actor = scanner.nextLine();
		System.out.println("Enter movie's revenue earned: \n");
		String moneyMade = scanner.nextLine();
		System.out.println("Select the movies genre: \n"
				+ "1) Action\n"
				+ "2) Animation\n"
				+ "3) Comedy\n"
				+ "4) Crime\n"
				+ "5) Drama\n"
				+ "6) Romance\n"
				+ "7) War\n");
		int genreId = intScanner.nextInt();
		System.out.println("Enter a 1 to 5 star rating: \n");
		int ratingId = intScanner.nextInt();
		
		movieDao.createMovie(movieTitle, movieLength, releaseDate, director, actor, moneyMade, genreId, ratingId);
	}

	private void updateMovie() {
		// TODO Auto-generated method stub
		
	}
	
	//displays all movies with their title and id
	private void displayAllMovies() throws SQLException {
		List<Movie> movies = movieDao.getMovie(); 
		for ( Movie m : movies ) {
			System.out.println(m.getMovieTitle() + " : " + m.getMovieLength() + " : " 
					+ m.getReleaseDate() + " : " + m.getDirector() + " : " 
					+ m.getLeadActor() + " : " + m.getRevenue() + " : " 
					+ genreDao.getGenreById(m.getGenres()));
			}
		
	}

	private void deleteMovie() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter the movie ID number you would like to delete: \n");
		int movieIdDelete = scanner.nextInt();
		movieDao.deleteMovie(movieIdDelete);
	}

	// creates a new move genre
	private void createGenre() throws SQLException {
		System.out.print("Enter new genre: ");
		String genreName = scanner.nextLine();                                                             
		genreDao.createNewGenre(genreName);
	}

	private void updateGenre() throws SQLException {
		System.out.println("Enter the id for the genre you would like to update: \n");
		int updateGenre = scanner.nextInt();
		System.out.println("Please enter the updated genre: ");
		String updatedGenre = scanner.nextLine();
		genreDao.updateGenre(updateGenre, updatedGenre);
	}

	private void displayAllMoviesByGenre() throws SQLException {
		List<Genre> moviesByGenre = genreDao.getAllGenre();
		int counter = 1;
		for(Genre m : moviesByGenre) {
			System.out.println(" " + counter + ":  " + m);
		}
		System.out.println("Please enter the Genre Id for the list of movies you would like to see: \n");
		int genreId = scanner.nextInt();

	}

	private void deleteGenre() {
		
	}
	
	/*I think we should remove the createRating Method.
	 * From a logical flow standpoint, it doesn't seem to 
	 * really make a lot of sense.  
	 * The rating system would be better served by just being another column in the 
	 * Movie Entity and then we can still complete a search on the rating 
	 * or perhaps even an update on the rating itself?
	 * -- from jeff -- 
	 */
	//creates a rating of a movie. Star rating is only 1-5
	/*
	private void createRating() throws SQLException {
		int starRating;
		
		System.out.print("Enter the movie id you wish to rate: ");
		int movieId = Integer.parseInt(scanner.nextLine());
		
		do {
		System.out.print("Enter the number of stars you wish to rate the movie, 1-5 ONLY: ");
		starRating = scanner.nextInt();
		} while (starRating < 0 || starRating > 5);
		System.out.println("Thank you for entering a " + starRating + " star rating.");
		
		ratingDao.createNewRating(movieId, starRating);
	} */
	
	//updates a rating by entering id and can only enter stars 1-5
	//should this be more of a movieDao function?
	//meaning if we update the rating, we would want to update the rating for the particular
	// movie and not update the actual rating?
	// my thought is that ratings should only have 5 possible id's 
	// and those id's should be a foreign key on movie
	
	/*
	private void updateRating() throws SQLException {
		int starRating;
		
		System.out.print("Enter rating id to update star rating: ");
		int ratingId = Integer.parseInt(scanner.nextLine());
		
		do {
		System.out.print("Enter the number of stars you wish to rate the movie, 1-5 ONLY: ");
		starRating = scanner.nextInt();
		} while (starRating < 0 || starRating > 5);
		System.out.println("Thank you for entering a " + starRating + " star rating.");
			
		ratingDao.updateRatingById(ratingId, starRating);
	}
	*/
	
	private void displayAllMoviesByRating() throws SQLException {
		System.out.println("Enter a rating between 1 and 5 to see a list of movies with that rating: \n");
		int movieRating = intScanner.nextInt();
		List<Movie> moviesByRating = movieDao.getMovieByRating(movieRating);
		System.out.println("Here is your list of "+ movieRating + " star movie(s)");
		for ( Movie m : moviesByRating ) {
			System.out.println(m.getMovieTitle() + " : " + m.getMovieLength() + " : " 
					+ m.getReleaseDate() + " : " + m.getDirector() + " : " 
					+ m.getLeadActor() + " : " + m.getRevenue() + " : " 
					+ m.getGenres());
			}
	}
	
	
	/* 
	 * I set out above why I think this should be deleted, so I am commenting it out for now
	 * 

	private void deleteRating() {
		// TODO Auto-generated method stub
		
		
	} */
}
