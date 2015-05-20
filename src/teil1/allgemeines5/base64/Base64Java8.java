package teil1.allgemeines5.base64;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Test;

public class Base64Java8 {

	@Test
	public void java8Encode() throws Exception {
		String encoded = Base64.getEncoder().encodeToString("user:password".getBytes("UTF8"));

		assertThat(encoded, is(equalTo("dXNlcjpwYXNzd29yZA==")));
	}

	@Test
	public void java8Decode() throws Exception {
		byte[] decoded = Base64.getDecoder().decode("dXNlcjpwYXNzd29yZA==");

		assertThat(new String(decoded, "UTF8"), is(equalTo("user:password")));
	}

	@SuppressWarnings("unused")
	@Test
	public void weitere() throws Exception {

		// weitere En-/Decoder
		Encoder mimeEncoder = Base64.getMimeEncoder();
		Decoder mimeDecoder = Base64.getMimeDecoder();
		Encoder urlEncoder = Base64.getUrlEncoder();
		Decoder urlDecoder = Base64.getUrlDecoder();

	}
}
