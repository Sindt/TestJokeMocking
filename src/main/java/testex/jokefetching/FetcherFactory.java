package testex.jokefetching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetcherFactory implements IFetcherFactory {

	private final List<String> availableTypes = Arrays.asList("EduJoke", "ChuckNorris", "Moma", "Tambal");

	@Override
	public List<String> getAvailableTypes() {
		return availableTypes;
	}

	@Override
	public List<IJokeFetcher> getJokeFetchers(String jokesToFetch) {
		List<IJokeFetcher> fetchers = new ArrayList<IJokeFetcher>();

		for (String token : jokesToFetch.split(",")) {
			switch (token.toLowerCase()) {
			case "eduprog":
				fetchers.add(new EduJoke());
				break;
			case "moma":
				fetchers.add(new Moma());
				break;
			case "chucknorris":
				fetchers.add(new ChuckNorris());
				break;
			case "tambal":
				fetchers.add(new Tambal());
				break;
			}
		}

		return fetchers;
	}

}
