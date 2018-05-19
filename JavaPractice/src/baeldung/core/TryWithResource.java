package baeldung.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) throws FileNotFoundException {
		try(Scanner scanner = new Scanner(new File("src/resource/text.txt"))){
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
	}
}
