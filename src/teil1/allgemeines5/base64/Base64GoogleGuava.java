package teil1.allgemeines5.base64;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.io.BaseEncoding;

public class Base64GoogleGuava {

	@Test
	public void googleGuavaEncode() throws Exception {
		String encoded = BaseEncoding.base64().encode("user:password".getBytes("UTF8"));

		assertThat(encoded, is(equalTo("dXNlcjpwYXNzd29yZA==")));
	}

	@Test
	public void googleGuavaDecode() throws Exception {
		byte[] decoded = BaseEncoding.base64().decode("dXNlcjpwYXNzd29yZA==");

		assertThat(new String(decoded, "UTF8"), is(equalTo("user:password")));
	}

}
