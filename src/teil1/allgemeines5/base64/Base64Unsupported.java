package teil1.allgemeines5.base64;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

//unsupported
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64Unsupported {

	@Test
	public void unsupportedEncode() throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		String encodedString = encoder.encode("user:password".getBytes("UTF8"));

		assertThat(encodedString, is(equalTo("dXNlcjpwYXNzd29yZA==")));
	}

	@Test
	public void unsupportedDecode() throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		String decodedString = new String(decoder.decodeBuffer("dXNlcjpwYXNzd29yZA=="), "UTF8");

		assertThat(decodedString, is(equalTo("user:password")));
	}
}
