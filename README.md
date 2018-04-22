# MovieServices

Movie Restfull Services with Spring mvc
It is maven project and can be imported as a eclipse maven project 

To build the artifacts

mvn clean install

To run the test cases alone

mvn test

The services that being developed are 

1. 	create movie : /movie/create
	: Sample Payload
	: {"id":2, "name": "Inception", "director": "james"}

2.  update movie : /movie/update/{id}
	: Sample Payload
	: {"id":2, "name": "Inception", "director": "james"}

3. 	delete movie : /movie/delete/{id}

4. list all movies: /movie/list
