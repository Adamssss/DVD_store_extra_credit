import java.util.Scanner;

public class DVDstore {

	private static Linked DVDstore = new Linked(null, null);
	// two scanners for String and numbers
	private static Scanner scanner1 = new Scanner(System.in);
	private static Scanner scanner2 = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testinit();

		while (true) {
			displayMainMenu();
			int func = scanner1.nextInt();
			if (func == 1) {
				add();
				continue;
			}
			if (func == 2) {
				remove();
				continue;
			}
			if (func == 3) {
				display();
				continue;
			}
			if (func == 4) {
				onOffSale();
				continue;
			}
			if (func == 5) {
				displaygenre();
				continue;
			}
			if (func == 6) {
				rentDVD();
				continue;
			}
			if (func == 7) {
				break;
			}
		}
	}

	public static void testinit() {
		DVDstore = new Linked(new DVD("c", 1), new Linked(new DVD("e", 3),
				new Linked(new DVD("t", 4), new Linked(new DVD("z", 2), null))));
	}

	public static void displayMainMenu() {
		System.out
				.println("Welcome to the DVD Store! Select an option below: ");
		System.out.println();
		System.out.println("1) add an DVD");
		System.out.println("2) remove an DVD");
		System.out.println("3) display inventory");
		System.out.println("4) on sale / off sale");
		System.out.println("5) display genre");
		System.out.println("6) rent DVD");
		System.out.println("7) quit ");
		System.out.println();
		System.out.println("Select an option above: ");
	}

	/*
	 * The user will be prompted for a title of a new DVD and a price (original
	 * price). The store will add the DVD in the appropriate location in the
	 * alphabetically sorted (by title) inventory, provided the DVD name does
	 * not already exist in the list. If it exists, the user will be prompted
	 * for an alternate DVD title.
	 */
	public static void add() {
		System.out.println("Now you can add a new DVD.\n");
		// get the new dvd information
		System.out.println("Please type the title of the new DVD:");
		String title = scanner2.nextLine();
		// check if any dvd exist
		if (DVDstore.getDVD() == null) {
			System.out.println("And the price is?");
			double price = scanner1.nextDouble();
			DVD temp = new DVD(title, price);
			DVDstore = new Linked(temp, null);
		} else {
			while (DVDstore.contains(title)) {
				// same title exception
				System.out
						.println("This DVD already exists. Please try again.\n");
				// take the alternate title
				System.out
						.println("Please type the title of the new DVD: (type \"-quit\" to quit)");
				title = scanner2.nextLine();
				if (title.equals("-quit")) {
					return;
				}
			}
			System.out.println("And the price is?");
			double price = scanner1.nextDouble();
			DVD temp = new DVD(title, price);
			DVDstore.insert(temp);
		}
		// confirm
		System.out.println("DVD added.\n");
		// keep adding?
		System.out.println("Would you like to add another DVD? (yes/no)");
		String keepAdd = scanner2.nextLine();
		if (keepAdd.equals("yes")) {
			add();
		}
	}

	/*
	 * the user will be prompted for a title. The DVD with that title will be
	 * removed from the inventory
	 */
	public static void remove() {
		// check if dvd exists
		if (DVDstore.getDVD() == null) {
			System.out.println("There is no DVD in the inventory.\n");
			return;
		}

		System.out.println("Now you can remove a DVD.\n");
		// get the dvd information
		System.out
				.println("Please type the title of the DVD you want to remove:");
		String title = scanner2.nextLine();
		while (!DVDstore.contains(title)) {
			// no dvd exception
			System.out.println("There is no such DVD. Please try again.\n");
			// take the alternate title
			System.out
					.println("Please type the title of the DVD you want to remove: (type \"-quit\" to quit)");
			title = scanner2.nextLine();
			if (title.equals("-quit")) {
				return;
			}
		}
		DVDstore.remove(title);
		// confrim
		System.out.println("DVD removed.\n");
		// keep removing?
		System.out.println("Would you like to remove another DVD? (yes/no)");
		String keepRemove = scanner2.nextLine();
		if (keepRemove.equals("yes")) {
			remove();
		}
	}

	/*
	 * the current inventory of the store will be displayed in alphabetical
	 * order - DVD title, current rental price and number of times the DVD was
	 * rented. Display information about the DVD only if it is currently NOT
	 * rented. Price displayed is the original rental price unless the DVD is
	 * currently on sale, then display the sale price. As a promotional tool, if
	 * the price is 0.00, display ¡°Currently Free!¡± next to the DVD listing. If
	 * it is on sale, display ¡°On Sale!¡± next to the DVD.
	 */
	public static void display() {
		if (DVDstore.getDVD() == null) {
			System.out.println("There is no DVD in the inventory.\n");
			return;
		}
		System.out.println("DVD title \t\t\trental price \ttimes rented");
		DVDstore.display();
		// wait for some time
		System.out.println("\nPress Enter to continue.");
		String wait = scanner2.nextLine();
	}

	public static void onOffSale() {
		String title = scanner2.nextLine();
		DVD temp = DVDstore.find(title);
		while (temp == null) {
			// exception
		}
		temp.flipsale();
		if (temp.isOnSale()) {
			// set onsale price

		}
	}

	public static void displaygenre() {

	}

	public static void rentDVD() {

	}

}
