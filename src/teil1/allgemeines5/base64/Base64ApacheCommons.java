package teil1.allgemeines5.base64;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class Base64ApacheCommons {

	@Test
	public void apacheCommonsEncode() throws Exception {
		String encoded = Base64.encodeBase64String("user:password".getBytes("UTF8"));

		assertThat(encoded, is(equalTo("dXNlcjpwYXNzd29yZA==")));
	}

	@Test
	public void apacheCommonsDecode() throws Exception {
		byte[] decoded = Base64.decodeBase64("dXNlcjpwYXNzd29yZA==");

		assertThat(new String(decoded, "UTF8"), is(equalTo("user:password")));
	}
}
