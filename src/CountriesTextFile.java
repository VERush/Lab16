import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {


	public static void readFromFile(String c) {
		Path readFile = Paths.get("countries.txt");
		File file = readFile.toFile(); // convert to a file object

		try {
			FileReader fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}

	public static void writeToFile(String c) {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			// "true" parameter allows us to append to the end of the file, otherwise it
			// will overwrite the text file each time
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true)); // FileOutputStream can take 2
																					// parameters
			// outW.println();
			outW.println(c);
			outW.close(); // flushes data, closes the stream

		} catch (FileNotFoundException e) {
			createFile("countries.txt");
			System.out.println("The file was not found here...");
		}

	}

	public static void createFile(String fileString) {

		Path filePath = Paths.get(fileString);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was created successfully.");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation!");
			}
		}

		System.out.println("File Name: " + filePath.getFileName());
		System.out.println("Absolute Path: " + filePath.toAbsolutePath());
	}

public static void createDirectory(String path) {
	Path dirPath = Paths.get(path);

	if (Files.notExists(dirPath)) {
		try {
			Files.createDirectories(dirPath);
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}

}

}