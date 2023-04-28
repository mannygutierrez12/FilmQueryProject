package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//    app.launch();
	}

	private void test() {
		
//		  public Film findFilmById(int filmId);
//		 *************** public Actor findActorById(int actorId);
//		  public List<Actor> findActorsByFilmId(int filmId);
//		  public List<Film> findFilmByActorId(int actorId);
		
		
		Film film = db.findFilmById(14);
	    if (film != null) {
	        System.out.println(film);
	    } else {
	        System.out.println("Film not found with ID");
	    }
//    Film film = db.findFilmById(1);
//    System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

	}

}
