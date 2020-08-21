package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Entity.Movie;
import Entity.Genre;
import Entity.Rating;
import Dao.GenreDao;
import Dao.MovieDao;
import Dao.RatingDao;

public class Menu {
	private Dao.GenreDao genreDao = new GenreDao();
	private MovieDao movieDao = new MovieDao();
	private RatingDao ratingDao = new RatingDao();


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
			"Display all movies by number of stars",
			"Update rating by id",
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
				createRating();
			} else if ( userSelection.equals("10") ) {
				updateRating();
			} else if ( userSelection.equals("11") ) {
				displayAllMoviesByRating();
			} else if ( userSelection.equals("12") ) {
				deleteRating();
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
	
	private void createMovie() {
		// TODO Auto-generated method stub
		System.out.println("Enter the movie title: \n");
		String movieTitle = scanner.next();
		System.out.println("Enter the total length in minutes: \n");
		int movieLength = scanner.nextInt();
		System.out.println("Enter the release date: \n");
		String releaseDate = scanner.next();
		System.out.println("Enter movie's director: \n");
		String director = scanner.next();
		System.out.println("Enter movie's actor: \n");
		String actor = scanner.next();
		System.out.println("Enter movie's revenue earned: \n");
		String moneyMade = scanner.next();
		movieDao.addRun(movieTitle, movieLength, releaseDate, director, actor, moneyMade);
	}

	private void updateMovie() {
		// TODO Auto-generated method stub
		
	}
	
	//displays all movies with their title and id
	private void displayAllMovies() throws SQLException {
		List<Movie> movies = movieDao.getMovies(); 
		for(Movie movie : movies) {
			System.out.println(movie.getMovieId() + " : " + movie.getMovieTitle());
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
		// TODO Auto-generated method stub
		System.out.println("Enter the id for the genre you would like to update: \n");
		int updateGenre = scanner.nextInt();
		System.out.println("Please enter the updated genre: ")
		String updatedGenre = scanner.nextLine();
		genreDao.updateGenre(updateGenre, updatedGenre);
	}

	private void displayAllMoviesByGenre() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Please enter the Genre Id for the list of movies you would like to see: \n");
		int genreId = scanner.nextInt();
		List<Movie> moviesByGenre = genreDao.getMoviesByGenre(genreId);
		
	}

	private void deleteGenre() {
		// TODO Auto-generated method stub
		
	}
	
	//creates a rating of a movie. Star rating is only 1-5
	private void createRating() throws SQLException {
		int starRating;
		
		System.out.print("Enter the movie id you wish to rate: ");
		int movieId = Integer.parseInt(scanner.nextLine());
		
		do {
		System.out.print("Enter the number of stars you wish to rate the movie, 1-5 ONLY: ");
		starRating = in.nextInt();
		} while (starRating < 0 || starRating > 5);
		System.out.println("Thank you for entering a " + starRating + " star rating.");
		
		ratingDao.createNewRating(movieId, starRating);
	}
	
	//updates a rating by entering id and can only enter stars 1-5
	private void updateRating() throws SQLException {
		int starRating;
		
		System.out.print("Enter rating id to update star rating: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		do {
		System.out.print("Enter the number of stars you wish to rate the movie, 1-5 ONLY: ");
		starRating = scanner.nextInt();
		} while (starRating < 0 || starRating > 5);
		System.out.println("Thank you for entering a " + starRating + " star rating.");
			
		ratingDao.updateRatingById(ratingId, starRating);
	}
	
	private void displayAllMoviesByRating() {
		// TODO Auto-generated method stub
		
	}
	
	private void deleteRating() {
		// TODO Auto-generated method stub
		
	}
}
