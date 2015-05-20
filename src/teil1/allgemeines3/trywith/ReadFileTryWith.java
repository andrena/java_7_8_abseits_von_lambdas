package teil1.allgemeines3.trywith;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileTryWith {

	static void printFile() {

		try (InputStream input = new FileInputStream("file.txt")) {

			// TODO read from input

		} catch (IOException e) {
			// TODO handle e

			// TODO handle Exception[] suppressed = e.getSuppressed();
			// contains Exception thrown by close() of input
		}

	}

}
