package teil2.nio2;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class Nio2Demo1Paths {

	@Test
	public void erzeugungVonPathObjekten() throws Exception {
		Path path1 = FileSystems.getDefault().getPath("dateien/text.txt");
		Path path2 = Paths.get("dateien/text.txt");
		Path path3 = Paths.get("dateien", "text.txt");

		assertThat(path1, is(path2));
		assertThat(path1, is(path3));
	}

	@Test
	public void arbeitenMitPathObjekten() throws Exception {
		Path ordner = Paths.get("mein/pfad/zum/ordner");
		Path datei = Paths.get("mein/pfad/zum/ordner/unterordner/eine_datei.txt");

		assertThat(ordner.resolve("testDatei"), is(Paths.get("mein/pfad/zum/ordner/testDatei")));
		assertThat(ordner.relativize(datei), is(Paths.get("unterordner/eine_datei.txt")));
		assertThat(datei.getParent(), is(Paths.get("mein/pfad/zum/ordner/unterordner")));
	}
}
