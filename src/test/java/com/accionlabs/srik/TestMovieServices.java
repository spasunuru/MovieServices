package com.accionlabs.srik;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class TestMovieServices {

	public static final String SERVER_URI = "http://localhost:9090/MovieServices/movie/";
	
	public static void main(String args[]){
		
		testGetDummyMovie();
		System.out.println("*****create movie");
		testCreateMovie();
		System.out.println("*****get movie");
		testGetMovie();
		System.out.println("*****get all movies");
		testGetAllMovie();
	}

	private static void testGetAllMovie() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Movie> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> movies = restTemplate.getForObject(SERVER_URI+"list", List.class);
		System.out.println(movies.size());
		for(LinkedHashMap map : movies){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",Director="+map.get("director"));;
		}
	}

	private static void testCreateMovie() {
		RestTemplate restTemplate = new RestTemplate();
		Movie movie = new Movie();
		movie.setId(1);
		movie.setName("SpiderMan");
		movie.setDirector("James");
		Movie response = restTemplate.postForObject(SERVER_URI+"create", movie, Movie.class);
		printmoviedata(response);
	}

	private static void testGetMovie() {
		RestTemplate restTemplate = new RestTemplate();
		Movie movie = restTemplate.getForObject(SERVER_URI+"1", Movie.class);
		printmoviedata(movie);
	}

	private static void testGetDummyMovie() {
		RestTemplate restTemplate = new RestTemplate();
		Movie movie = restTemplate.getForObject(SERVER_URI+"dummy", Movie.class);
		printmoviedata(movie);
	}
	
	public static void printmoviedata(Movie movie){
		System.out.println("ID="+movie.getId()+",Name="+movie.getName()+",Director="+movie.getDirector());
	}
}
