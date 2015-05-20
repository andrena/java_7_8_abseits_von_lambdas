package teil3.time;

import static java.time.LocalTime.NOON;
import static java.time.Month.MAY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

import org.junit.Test;

public class DateTimeDemo5Format {

	private LocalDateTime dateTime = LocalDate.of(2015, MAY, 20).atTime(NOON);

	@Test
	public void formatter() throws Exception {

		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		assertThat(ofPattern.format(dateTime), is("20.05.2015 12:00:00"));

		DateTimeFormatter ofLocalizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		assertThat(ofLocalizedDateTime.format(dateTime), is("20.05.2015 12:00:00"));

		DateTimeFormatter fromBuilder = new DateTimeFormatterBuilder() //
				.appendValue(ChronoField.DAY_OF_MONTH, 2).appendLiteral('.') //
				.appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('.') //
				.appendValue(ChronoField.YEAR) //
				.appendLiteral(' ') //
				.appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':') //
				.appendValue(ChronoField.MINUTE_OF_HOUR, 2).appendLiteral(':') //
				.appendValue(ChronoField.SECOND_OF_MINUTE, 2) //
				.toFormatter();

		assertThat(fromBuilder.format(dateTime), is("20.05.2015 12:00:00"));

	}
}
