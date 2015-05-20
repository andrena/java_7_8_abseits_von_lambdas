package teil2.nio2;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Nio2Demo3aFilesAdvanced {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	private Path testFolder;

	@Before
	public void setUp() throws IOException {
		testFolder = folder.getRoot().toPath();
		folder.newFile("text.txt");
		List<String> zeilen = new ArrayList<>();
		zeilen.add("Erste Zeile");
		zeilen.add("Zweite Zeile");
		Files.write(testFolder.resolve("text.txt"), zeilen);
	}

	@SuppressWarnings("unused")
	@Test
	public void readBytes() throws Exception {
		Path source = testFolder.resolve("text.txt");
		byte[] bytes = Files.readAllBytes(source);
	}

	@Test
	public void readLines() throws Exception {
		Path source = testFolder.resolve("text.txt");
		List<String> zeilen = Files.readAllLines(source, StandardCharsets.UTF_8);

		assertThat(zeilen.get(0), is(equalTo("Erste Zeile")));
		assertThat(zeilen.get(1), is(equalTo("Zweite Zeile")));
	}

	@Test
	public void writeBytes() throws Exception {
		Files.write(testFolder.resolve("neu.txt"), "getBytes()-Write-Test".getBytes(StandardCharsets.UTF_8));
	}

	@Test
	public void writeIterable() throws Exception {
		List<String> zeilen = new ArrayList<>();
		zeilen.add("Hilfreiche Neuerungen für Softwareentwickler in Java7 und Java8 abseits von Lambdas");
		zeilen.add("Karlsruher Entwicklertag 2015");
		Files.write(testFolder.resolve("neu.txt"), zeilen, StandardOpenOption.CREATE);
	}

}
