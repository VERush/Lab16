import java.util.Scanner;

public class CountryApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String prompt, country;
		String fileString = "countries.txt";
		int menu = 0;
		System.out.println("Welcome to the Countries Maintenance Application!");
		do {

			printMenu();

			prompt = "Enter menu number: ";
			menu = Validator.getInt(scan, prompt, 1, 3);
			if (menu == 1) {
				CountriesTextFile.readFromFile(fileString);
			} else if (menu == 2) {
				prompt = "Enter country: ";
				country = Validator.getString(scan, prompt);
				CountriesTextFile.writeToFile(country);
			} else {
				System.out.println("Buh-bye!");
			}
		} while (menu < 3);

	}

	public static void printMenu() {
		System.out.println("1 - See the list of countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit");
		System.out.println();
	}
}
