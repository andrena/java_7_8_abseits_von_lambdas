package teil1.allgemeines2.stringjoining;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringJoiningCommonsLang {

	private List<String> cityList = Arrays.asList("Karlsruhe", "Köln", "Berlin");

	@Test
	public void commonsLangJoin() throws Exception {
		// Apache Commons
		String variante1 = StringUtils.join("Karlsruhe", "Köln", "Berlin");
		String variante2 = StringUtils.join(cityList, " | ");

		assertThat(variante1, is(equalTo("KarlsruheKölnBerlin")));
		assertThat(variante2, is(equalTo("Karlsruhe | Köln | Berlin")));
	}

}
