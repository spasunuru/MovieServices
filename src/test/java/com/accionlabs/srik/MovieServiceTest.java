package com.accionlabs.srik;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class MovieServiceTest {
	
	MovieController service = new MovieController();
	
	@Test
	public void testGetDummyMovie() {
	  Movie movie = service.getDummyMovie();
	  assertEquals("Dummy", movie.getName());
	}
	
	
	@Test
	public void testCreateMovie() {
	  Movie movie = new Movie(1, "Inception", "James");
	  Movie resultMovie = service.createMovie(movie);
	  assertEquals("Inception", resultMovie.getName());
	}
	
	@Test
	public void testUpdateMovie() {
		Movie movie = new Movie(1, "Inception", "James");
		Movie resultMovie = service.createMovie(movie);
		Movie movie1 = new Movie(1, "Avatar", "James");
		Movie resultmovie = service.updateMovie(1, movie1);
		assertEquals("Avatar", resultmovie.getName());
	}
	
	
	@Test
	public void testListAllMovies() {
		Movie movie = new Movie(1, "Inception", "James");
		Movie resultMovie = service.createMovie(movie);
	  List<Movie> movieList = service.getAllMovies();
	  assertEquals("Inception", movieList.get(0).getName());
	}

	
  
}