package csku.martinfowler.movie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVMovieFinder implements MovieFinder {

	private String filename;

    public CSVMovieFinder(String filename) {
        this.filename = filename;
    }

	@Override
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<Movie>();

		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));

			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String[] data = line.split(",");
				// data[0] = name, data[1] = director
				movies.add(new Movie(data[0], data[1]));	
			}
		} catch(FileNotFoundException e) {
			System.err.println("Movie data file name is incorrect");
			System.exit(1);
		} catch(IOException e) {
			System.err.println("Problems reading movie data file");
			System.exit(1);
		}
		return movies;
	}
}
