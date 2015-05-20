package teil3.time;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class DateTimeDemo2Locals {

	@Test
	public void constructingLocals() {
		LocalDate aprilsFool = LocalDate.of(2015, Month.APRIL, 1);
		LocalDateTime aprilsFoolLunchTime = aprilsFool.atTime(LocalTime.NOON);

		assertThat(aprilsFoolLunchTime, is(LocalDateTime.of(2015, Month.APRIL, 1, 12, 00)));

		DayOfWeek dayOfWeek = aprilsFoolLunchTime.getDayOfWeek();
		assertThat(dayOfWeek, is(DayOfWeek.WEDNESDAY));
	}

	@Test
	public void factoryMethodParse() {
		assertThat(LocalTime.parse("17:42"), is(LocalTime.of(17, 42)));
		assertThat(LocalDate.parse("2015-11-23"), is(LocalDate.of(2015, 11, 23)));
		assertThat(LocalDateTime.parse("2015-11-23T17:42"), is(LocalDateTime.of(2015, 11, 23, 17, 42)));
	}

	@Test
	public void minusPlusWithCompare() {
		LocalDateTime diff = LocalDateTime.now() //
				.minusWeeks(2) //
				.plusHours(240) //
				.withMinute(55);

		assertTrue(diff.isBefore(LocalDateTime.now()));
		assertThat(diff, is(lessThan(LocalDateTime.now())));
	}

	@Test
	public void temporalAdjusters() {
		LocalDate nextFriday = LocalDate.of(2015, Month.MAY, 20).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		assertThat(nextFriday, is(LocalDate.of(2015, Month.MAY, 22)));

		LocalDate firstDayOfNextYear = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
		assertThat(firstDayOfNextYear, is(Year.now().plusYears(1).atDay(1)));
	}
}
