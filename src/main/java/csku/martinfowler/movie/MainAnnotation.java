package csku.martinfowler.movie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {

	public static void main(String[] args) throws Exception {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("config-annotation.xml");

		MovieLister lister = context.getBean(MovieLister.class);
		Movie[] jamesCamerons = lister.moviesDirectedBy("James Cameron");

		for (Movie movie : jamesCamerons) {
			System.out.println(movie.getName());
		}
	}
}

