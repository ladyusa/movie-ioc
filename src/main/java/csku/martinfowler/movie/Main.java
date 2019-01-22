package csku.martinfowler.movie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {

		MovieFinder finder = new CSVMovieFinder("movies1.txt");
		MovieLister lister = new MovieLister(finder);
		Movie[] ronHoward = lister.moviesDirectedBy("Ron Howard");
		for (Movie movieRH : ronHoward) {
			System.out.println(movieRH.getName());
		}
	}
}

