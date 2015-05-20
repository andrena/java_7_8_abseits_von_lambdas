package teil2.nio2;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Nio2Demo2FilesBasics {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	private Path testFolder;

	@Before
	public void setUp() throws IOException {
		testFolder = folder.getRoot().toPath();
		folder.newFile("text.txt");
	}

	@Test
	public void filesExistsDeleteCreate() throws Exception {
		Path path = testFolder.resolve("text.txt");

		assertThat(Files.exists(path), is(true));
		Files.delete(path);
		Files.deleteIfExists(path);
		Path neueDatei = testFolder.resolve("neueDatei");
		Files.createFile(neueDatei);
	}

	@Test
	public void filesCopyMove() throws Exception {
		Path original = testFolder.resolve("text.txt");
		Path duplikat = testFolder.resolve("duplikat.txt");

		Files.copy(original, duplikat, StandardCopyOption.REPLACE_EXISTING);
		assertThat(Files.exists(duplikat), is(true));

		Path moveZiel = testFolder.resolve("moveTarget.bak");

		Files.move(original, moveZiel, StandardCopyOption.REPLACE_EXISTING);
		assertThat(Files.exists(moveZiel), is(true));
		assertThat(Files.exists(original), is(false));
	}

}
