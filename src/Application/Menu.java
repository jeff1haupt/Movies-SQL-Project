package Application;

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

	private void displayAllMovies() {
		// TODO Auto-generated method stub
		
	}

	private void deleteMovie() {
		// TODO Auto-generated method stub
		
	}

	private void createGenre() {
		// TODO Auto-generated method stub
		
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
	
	private void createRating() {
		// TODO Auto-generated method stub
		
	}
	
	private void updateRating() {
		// TODO Auto-generated method stub
		
	}
	
	private void displayAllMoviesByRating() {
		// TODO Auto-generated method stub
		
	}
	
	private void deleteRating() {
		// TODO Auto-generated method stub
		
	}
}
