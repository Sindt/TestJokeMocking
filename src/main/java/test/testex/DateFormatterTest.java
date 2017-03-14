package test.testex;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import testex.DateFormatter;
import testex.JokeException;

public class DateFormatterTest {

	DateFormatter formatter = new DateFormatter();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetFormattedDateGMTReturnDate() throws JokeException {

		Date date = new Date(1489400183929L);
		String input = "GMT";
		String time = formatter.getFormattedDate(input, date);

		assertThat(time, is(equalTo("13 mar. 2017 10:16 AM")));
	}

	@Test
	public void testGetFormattedDateCETReturnDate() throws JokeException {

		Date date = new Date(1489400183929L);
		String input = "CET";
		String time = formatter.getFormattedDate(input, date);

		assertThat(time, is(equalTo("13 mar. 2017 11:16 AM")));
	}

	@Test(expected = JokeException.class)
	public void testGetFormattedDate() throws JokeException {

		Date date = new Date(1489400183929L);
		String input = "GMTT";
		String time = formatter.getFormattedDate(input, date);

		assertThat(time, is(equalTo("13 mar. 2017 10:16 AM")));
	}

}
