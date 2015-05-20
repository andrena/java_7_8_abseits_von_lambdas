package teil1.allgemeines2.stringjoining;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.Test;

public class StringJoiningJava8 {

	private List<String> cityList = Arrays.asList("Karlsruhe", "K�ln", "Berlin");

	@Test
	public void stringJoin() throws Exception {
		String variante1 = String.join(", ", cityList);
		String variante2 = String.join(", ", "Karlsruhe", "K�ln", "Berlin");

		assertThat(variante1, is(equalTo("Karlsruhe, K�ln, Berlin")));
		assertThat(variante2, is(equalTo("Karlsruhe, K�ln, Berlin")));
	}

	@Test
	public void collectorsJoining() throws Exception {
		String variante1 = cityList.stream().collect(Collectors.joining());
		String variante2 = cityList.stream().collect(Collectors.joining(" | "));
		String variante3 = cityList.stream().collect(Collectors.joining(" | ", "[", "]"));

		assertThat(variante1, is(equalTo("KarlsruheK�lnBerlin")));
		assertThat(variante2, is(equalTo("Karlsruhe | K�ln | Berlin")));
		assertThat(variante3, is(equalTo("[Karlsruhe | K�ln | Berlin]")));
	}

	@Test
	public void stringJoiner() throws Exception {
		StringJoiner stringJoiner = new StringJoiner(", ", "", ".");
		// Alternative ohne Prefix und Suffix: new StringJoiner(", ");
		for (String city : cityList) {
			stringJoiner.add(city);
		}

		assertThat(stringJoiner.toString(), is(equalTo("Karlsruhe, K�ln, Berlin.")));
	}
}
