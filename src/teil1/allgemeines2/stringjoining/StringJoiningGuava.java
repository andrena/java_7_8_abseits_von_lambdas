package teil1.allgemeines2.stringjoining;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;

public class StringJoiningGuava {
	private List<String> cityList = Arrays.asList("Karlsruhe", "Köln", "Berlin");

	@Test
	public void guavaJoiner() throws Exception {
		// Google Guava
		String joined = Joiner.on(", ").join(cityList);

		assertThat(joined, is(equalTo("Karlsruhe, Köln, Berlin")));
	}
}
