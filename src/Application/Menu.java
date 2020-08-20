package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
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
			"Close App");
	
	public void start() {
		
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
			}else if ( userSelection.equals("0") ) {
				closeApp();
			} 
			
			System.out.println("Press enter to continue....\n ");
			scanner.nextLine();
			
		} while (!userSelection.equals("0"));
		
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
		System.out.println("What run record do you want to delete?\n");
		int movieDeleteId = scanner.nextInt();
		movieDao.deleteMovie(movieDeleteId);
	}

	// creates a new move genre
	private void createGenre() throws SQLException {
		System.out.print("Enter new genre: ");
		String genreName = scanner.nextLine();                                                             
		genreDao.createNewGenre(genreName);
	}

	private void updateGenre() {
		// TODO Auto-generated method stub
		
	}

	private void displayAllMoviesByGenre() {
		// TODO Auto-generated method stub
		
	}

	private void deleteGenre() {
		// TODO Auto-generated method stub
		
	}
	
	//creates a rating of a movie. Star rating is only 1-5
	private void createRating() throws SQLException {
		int starRating;
		
		System.out.print("Enter the movie id you wish to rate: ");
		int movieId = scanner.nextInt();
		
		do {
		System.out.print("Enter the number of stars you wish to rate the movie, 1-5 ONLY: ");
		starRating = scanner.nextInt();
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
		starRating = in.nextInt();
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
