package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	private Scanner input = new Scanner(System.in);
	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
	}
	
	public void test() {
		
		System.out.println(db.findFilmsByKeyword("super"));
	}

//	private void launch() {
//
//		boolean notDoneYet = true;
//		while (notDoneYet) {
//
//			System.out.println("Please choose a number from the menu below");
//			System.out.println();
//			System.out.println("1. Look up a film by its id");
//			System.out.println("2. Look up a film by a search keyword");
//			System.out.println("3. Exit the application");
//
//			String choice = input.nextLine();
//
//			if (choice.equals("1")) {
//				System.out.print("Enter the film ID: ");
//				try {
//					int filmId = Integer.parseInt(input.nextLine());
//					Film film = db.findFilmById(filmId);
//					if (film != null) {
//						System.out.println(film);
//						System.out.println("Language: " + film.getLanguage().getName());
//						System.out.println("Cast: " + film.getActors());
//					} else {
//						System.out.println("Film not found.");
//					}
//				} catch (NumberFormatException e) {
//					System.out.println("Invalid input. Please enter a number.");
//				}
//			}
//
//			else if (choice.equals("2")) {
//				System.out.print("Enter a search keyword: ");
//				String keyword = input.nextLine();
//				List<Film> films = db.findFilmsByKeyword(keyword);
//				if (films.isEmpty()) {
//					System.out.println("No films found.");
//				} else {
//					for (Film film : films) {
//						System.out.println(film);
//						System.out.println("Language: " + film.getLanguage().getName());
//						System.out.println("Cast: " + film.getActors());
//						System.out.println();
//					}
//				}
//			}
//
//			else if (choice.equals("3")) {
//				notDoneYet = false;
//			}
//
//			else {
//				System.out.println("That is not a valid option, please try again");
//			}
//		}
//		System.out.println("See you next time!");
//	}
}
