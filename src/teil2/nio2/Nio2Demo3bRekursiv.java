package teil2.nio2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Test;

public class Nio2Demo3bRekursiv {

	@Test
	public void rekursivesAblaufen() throws Exception {
		FileVisitor<? super Path> printVisitor = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path currentPath, BasicFileAttributes attributes) {
				System.out.println(currentPath);
				return FileVisitResult.CONTINUE;
			}
		};

		Path rootPath = Paths.get("dateien");
		Files.walkFileTree(rootPath, printVisitor);
	}

	@Test
	public void rekursivesAblaufenInhaltEinerZipDatei() throws IOException {
		FileVisitor<? super Path> printVisitor = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
				System.out.println(path);
				return FileVisitResult.CONTINUE;
			}
		};

		Path path = Paths.get("dateien", "misc.zip");

		try (FileSystem zipFileSystem = FileSystems.newFileSystem(path, null)) {
			Path zipRoot = zipFileSystem.getPath("/");
			Files.walkFileTree(zipRoot, printVisitor);
		}
	}

	@Test
	public void rekursiveSucheNachGrosserDatei() throws Exception {
		FileVisitor<? super Path> searchVisitor = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path currentPath, BasicFileAttributes attributes) throws IOException {
				if (Files.size(currentPath) > 20 * 1024) {
					System.out.println("Grosse Datei: " + currentPath);
					return FileVisitResult.TERMINATE;
				}

				return FileVisitResult.CONTINUE;
			}
		};

		Path rootPath = Paths.get("dateien");
		Files.walkFileTree(rootPath, searchVisitor);
	}

}
