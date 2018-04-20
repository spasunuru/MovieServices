package com.accionlabs.srik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the Movie service.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	//Map to store Movies, ideally we should use database
	Map<Integer, Movie> movieData = new HashMap<Integer, Movie>();
	
	@RequestMapping(value = "dummy", method = RequestMethod.GET)
	public @ResponseBody Movie getDummyMovie() {
		logger.info("Start getDummyMovie");
		Movie movie = new Movie();
		movie.setId(9999);
		movie.setName("Dummy");
		movie.setDirector("james cameron");
		movieData.put(9999, movie);
		return movie;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Movie getMovie(@PathVariable("id") int movieId) {
		logger.info("Start getMovie. ID="+movieId);
		
		return movieData.get(movieId);
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody List<Movie> getAllMovies() {
		logger.info("Start getAllMovies.");
		List<Movie> movies = new ArrayList<Movie>();
		Set<Integer> movieIdKeys = movieData.keySet();
		for(Integer i : movieIdKeys){
			movies.add(movieData.get(i));
		}
		return movies;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public @ResponseBody Movie createMovie(@RequestBody Movie movie) {
		logger.info("Start createMovie.");
		movieData.put(movie.getId(), movie);
		return movie;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public @ResponseBody Movie updateMovie(@PathVariable("id") int movieId, @RequestBody Movie movie) {
		logger.info("Start deleteMovie.");
		Movie movie1 = movieData.get(movieId);
		movieData.put(movie1.getId(),movie);
		return movie;
	}

	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
	public @ResponseBody Movie deleteMovie(@PathVariable("id") int movieId) {
		logger.info("Start deleteMovie.");
		Movie movie = movieData.get(movieId);
		movieData.remove(movieId);
		return movie;
	}
	
	
	
}
