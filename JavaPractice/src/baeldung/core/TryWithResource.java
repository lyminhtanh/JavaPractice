package baeldung.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) throws FileNotFoundException {
		try(Scanner scanner = new Scanner(new File("src/resource/printAndWrite.txt"));
			PrintWriter writer = new PrintWriter(new File("src/resource/generatedFile.txt"))){
			while(scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				System.out.println(nextLine);
				writer.write(nextLine);
			}
		}
		
	}
}
