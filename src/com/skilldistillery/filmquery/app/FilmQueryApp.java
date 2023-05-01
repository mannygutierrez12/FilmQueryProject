package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() throws SQLException {
		int userInput = 0;
		while (userInput != 3) {
			System.out.println("---------------------------");
			System.out.println("Choose one");
			System.out.println("1: Look up film by film ID");
			System.out.println("2: Look up film by keyword");
			System.out.println("3: Exit");

			userInput = input.nextInt();

			if (userInput == 1) {
				filmByFilmId();
			}

			else if (userInput == 2) {
				filmByKeyword();
			}

			else if (userInput == 3) {
				break;
			}

			else {
				System.out.println("That was not a valid input");
			}
		}
		System.out.println("See you next time!");

	}

	private void filmByFilmId() {
		int userInput;
		do {
			System.out.println("Please enter a film ID");
			while (!input.hasNextInt()) {
				System.out.println("Invalid film ID");
				System.out.println("Please enter a film ID");
				input.next();
			}
			userInput = input.nextInt();
		} while (userInput <= 0);

		Film film = db.findFilmById(userInput);

		if (film != null) {
			System.out.println();
			System.out.println("                    MOVIE INFORMATION");
			System.out.println("----------------------------------------------------------");
			System.out.println("Title: " + film.getTitle());
			System.out.println();
			System.out.println("Description");
			System.out.println(film.getDescription());
			System.out.println();
			IntLanguageToStringLanguage(film.getLanguageId());
			System.out.println("Released year: " + film.getReleaseYear());
			System.out.println("Ratings : " + film.getRating());

			System.out.println("----------------------------------------------");
			System.out.println("The actors and actresses in this film are:");
			List<Actor> actors = db.findActorsByFilmId(film.getId());
			if (actors != null) {
				System.out.println("");
				for (Actor actor : actors) {
					System.out.println(actor.getFirstName() + " " + actor.getLastName());
				}
			} else {
				System.out.println("There were no actors found in this film.");
			}

			System.out.println();
		} else {
			System.out.println("We have not found a field that matched your criteria");
		}

	}

	private void filmByKeyword() throws SQLException {
		Scanner input = new Scanner(System.in);
		boolean notDoneYet = true;
		while (notDoneYet) {
			System.out.println("Please enter a keyword");
			String keyword = input.nextLine();
			List<Film> films = db.findFilmsByKeyword(keyword);

			if (films != null && films.size() > 0) {
				System.out.println(films.size() + " result(s) were found:");

				for (Film film : films) {
					System.out.println();
					System.out.println("                    MOVIE INFORMATION");
					System.out.println("----------------------------------------------------------");
					System.out.println("Title: " + film.getTitle());
					System.out.println();
					System.out.println("Description");
					System.out.println(film.getDescription());
					System.out.println();
					IntLanguageToStringLanguage(film.getLanguageId());
					System.out.println("Released year: " + film.getReleaseYear());
					System.out.println("Ratings : " + film.getRating());

					System.out.println("----------------------------------------------");
					System.out.println("The Actors in this film are:");
					List<Actor> actors = db.findActorsByFilmId(film.getId());
					if (actors != null && actors.size() > 0) {
						System.out.println("Actors:");
						for (Actor actor : actors) {
							System.out.println("-" + actor.getFirstName() + " " + actor.getLastName());
						}
						notDoneYet = false;
					} else {
						System.out.println("No actors found for this film.");
					}

					System.out.println();
				}
			} else {
				System.out.println("No films found with the keyword: " + keyword);
			}

		}

	}

	private void IntLanguageToStringLanguage(int language) {
		if (language == 1) {
			System.out.println("Released Language: English");
		}

		else if (language == 2) {
			System.out.println("Released Language: Italian");
		}

		else if (language == 3) {
			System.out.println("Released Language: Japanese");
		}

		else if (language == 4) {
			System.out.println("Released Language: Mandarin");
		}

		else if (language == 5) {
			System.out.println("Released Language: French");
		}

		else if (language == 6) {
			System.out.println("Released Language: German");
		}

		else {
			System.out.println("Language not found");
		}

	}
}