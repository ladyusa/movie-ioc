package csku.martinfowler.movie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("config.xml");

		MovieLister lister = context.getBean("lister", MovieLister.class);
		Movie[] ronHoward = lister.moviesDirectedBy("Ron Howard");

		for (Movie movieRH : ronHoward) {
			System.out.println(movieRH.getName());
		}
	}
}

