package Application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display a list of all movies", 
			"Find information about a specific movie", 
			"Find movies that start with a letter",
			"Delete a movie from the list",
			"Update information about the movie",
			"Close App");
	
	public void start() {
		
		String userSelection = "";
		
		do {
			
			displayMenu();
			userSelection = scanner.nextLine();
			
			if ( userSelection.equals("1") ) {
				displayAllMovies();
			} else if ( userSelection.equals("2") ) {
				findSpecificMovie();
			} else if ( userSelection.equals("3") ) {
				letterSearch();
			} else if ( userSelection.equals("4") ) {
				deleteMovie();
			} else if ( userSelection.equals("5") ) {
				updateMovie();
			} else if ( userSelection.equals("0") ) {
				//CLOSE APP
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
	private void updateMovie() {
		// TODO Auto-generated method stub
		
	}

	private void deleteMovie() {
		// TODO Auto-generated method stub
		
	}

	private void letterSearch() {
		// TODO Auto-generated method stub
		
	}

	private void findSpecificMovie() {
		// TODO Auto-generated method stub
		
	}

	private void displayAllMovies() {
		// TODO Auto-generated method stub
		
	}


}
