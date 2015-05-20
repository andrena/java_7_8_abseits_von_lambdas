package teil3.time;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class DateTimeDemo4PeriodAndDuration {

	@Test
	public void period() {
		Period einMonat = Period.ofMonths(1);
		LocalDateTime endeFebruar = LocalDateTime.of(2015, 3, 31, 0, 0).minus(einMonat);
		assertThat(endeFebruar, is(LocalDateTime.of(2015, 2, 28, 0, 0)));
	}

	@Test
	public void duration() {
		Duration einMonat = ChronoUnit.MONTHS.getDuration();
		LocalDateTime endeFebruar = LocalDateTime.of(2015, 3, 31, 0, 0).minus(einMonat);
		assertThat(endeFebruar, is(LocalDateTime.of(2015, 2, 28, 13, 30, 54)));
	}

	@Test
	public void durationBetween() throws InterruptedException {
		Instant start = Instant.now();

		TimeUnit.SECONDS.sleep(2);

		Duration aboutTwoSeconds = Duration.between(start, Instant.now());

		assertThat(aboutTwoSeconds, is(greaterThan(Duration.ofSeconds(1))));
		assertThat(aboutTwoSeconds, is(lessThan(Duration.ofSeconds(3))));
	}

	@Test
	public void periodUntil() {
		LocalDate weihnachtenDiesesJahr = Year.now().atMonth(Month.DECEMBER).atDay(24);
		Period period = LocalDate.now().until(weihnachtenDiesesJahr);
		System.out.println("Noch " + period.getMonths() + " Monate und " + period.getDays() + " Tage bis Weihnachten");
	}
}
