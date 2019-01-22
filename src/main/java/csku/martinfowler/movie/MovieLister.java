package csku.martinfowler.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class MovieLister {

	private MovieFinder finder;

	@Autowired
	public MovieLister(MovieFinder finder) {
		this.finder = finder;
	}

	public Movie[] moviesDirectedBy(String arg) {

		List<Movie> allMovies = finder.findAll();

        Iterator<Movie> it = allMovies.iterator();
		while (it.hasNext()) {
			Movie movie = (Movie) it.next();
			if (!movie.getDirector().equals(arg))
				it.remove();
		}

		return allMovies.toArray(
				new Movie[allMovies.size()]);
	}
}
