package test.testex;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import testex.DateFormatter;
import testex.IDateFormatter;
import testex.JokeException;
import testex.JokeFetcher;
import testex.Jokes;
import testex.jokefetching.FetcherFactory;

public class JokeFetcherTest {

	IDateFormatter formatter = mock(DateFormatter.class);

	private JokeFetcher fetcher = new JokeFetcher(new FetcherFactory());

	@Test
	public void testGetAvailableTypes() {
		List<String> result = fetcher.getAvailableTypes();

		assertThat(result.isEmpty(), is(false));
	}

	@Test
	public void testIsStringValidReturnTrue() {
		boolean result = fetcher.isStringValid("moma");

		assertThat(result, is(true));
	}

	@Test
	public void testIsStringValidReturnFalse() {
		boolean result = fetcher.isStringValid("");

		assertThat(result, is(false));
	}

	@Test
	public void testGetJokesReturnJokes() throws JokeException {

		when(formatter.getFormattedDate(anyString(), anyObject())).thenReturn("13 mar. 2017 11:16 AM");
		Jokes result = fetcher.getJokes("eduprog,chucknorris,moma,tambal", "GMT");

		assertThat(result.getJokes().isEmpty(), is(false));
	}

	@Test(expected = JokeException.class)
	public void testGetJokesThrowEx() throws JokeException {
		Jokes result = fetcher.getJokes("qwerty", "GMT");

		assertThat(result, is(equalTo(null)));
	}

}
