package teil1.allgemeines3.trywith;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileClassic {

	static void printFile() {

		try {

			InputStream input = null;
			try {
				input = new FileInputStream("file.txt");

				// TODO read from input

			} finally {
				if (input != null) {
					input.close();
				}
			}

		} catch (IOException e) {
			// TODO handle e
		}

	}

}
