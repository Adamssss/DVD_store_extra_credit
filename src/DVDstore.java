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
		// this init is used for test only
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
				System.out.println("Are you sure you want to quit? - all your data will be lost.");
				String quit = scanner2.nextLine();
				if (quit.equals("yes")) {
					break;
				}
			}
			System.out.println("Not a valid option. Please try again.\n");
		}
		System.out.println("DVD Store closed.");
	}

	/*
	 * init some dvds to test run; contains some random dvd information
	 */
	public static void testinit() {
		DVD d0 = new DVD("Her", 12);
		d0.setGenre(genre.romance);
		DVDstore = new Linked(d0, null);
		DVD d1 = new DVD("Finding Nemo", 12);
		d1.setRentedTimes(5);
		DVDstore.insert(d1);
		DVD d2 = new DVD("The Avengers", 39);
		d2.flipsale();
		d2.setOnSalePrice(19);
		d2.setRentedTimes(1);
		DVDstore.insert(d2);
		DVD d3 = new DVD("Chicago", 10.9);
		d3.setRentedTimes(2);
		d3.setGenre(genre.musical);
		DVDstore.insert(d3);
		DVD d4 = new DVD("Hangover", 7.9);
		d4.setGenre(genre.comedy);
		DVDstore.insert(d4);
		DVD d5 = new DVD("Saw", 9.9);
		d5.setGenre(genre.horror);
		DVDstore.insert(d5);
		DVD d6 = new DVD("Avatar", 15);
		d6.flipsale();
		d6.setOnSalePrice(3.2);
		d6.setRentedTimes(8);
		DVDstore.insert(d6);
		DVD d7 = new DVD("Cats", 9.9);
		d7.flipsale();
		d7.setOnSalePrice(7.9);
		d7.setGenre(genre.musical);
		d7.setRentedTimes(5);
		DVDstore.insert(d7);
		DVD d8 = new DVD("The Sound of Music",4.9);
		d8.flipsale();
		d8.setOnSalePrice(0);
		d8.setGenre(genre.musical);
		d8.setRentedTimes(41);
		DVDstore.insert(d8);
		DVD d9 = new DVD("Planet Earth",3.9);
		d9.setGenre(genre.documentary);
		d9.setRentedTimes(2);
		DVDstore.insert(d9);
		DVD temp = new DVD("Les Miserables",9.9);
		temp.flipsale();
		temp.setOnSalePrice(8.8);
		temp.setGenre(genre.musical);
		DVDstore.insert(temp);
		temp = new DVD("Argo",6.9);
		DVDstore.insert(temp);
		temp = new DVD("Scream",9.9);
		temp.flipsale();
		temp.setOnSalePrice(7.9);
		temp.setGenre(genre.horror);
		temp.setRentedTimes(2);
		DVDstore.insert(temp);
		temp = new DVD("The Ring",2.9);
		temp.setGenre(genre.horror);
		DVDstore.insert(temp);
		temp = new DVD("A Bite of China",0);
		temp.setGenre(genre.documentary);
		temp.setRentedTimes(17);
		DVDstore.insert(temp);
		temp = new DVD("Citizenfour",15.9);
		temp.setGenre(genre.documentary);
		DVDstore.insert(temp);
		temp = new DVD("Titanic",3.9);
		temp.flipsale();
		temp.setOnSalePrice(0.9);
		temp.setGenre(genre.romance);
		temp.setRentedTimes(74);
		DVDstore.insert(temp);
		temp = new DVD("Twilight",9.9);
		temp.setGenre(genre.romance);
		DVDstore.insert(temp);
		temp = new DVD("Pride & prejudice",9.9);
		temp.setGenre(genre.romance);
		temp.setRentedTimes(1);
		DVDstore.insert(temp);
		temp = new DVD("The Interview",9.9);
		temp.flipsale();
		temp.setOnSalePrice(0);
		temp.setGenre(genre.comedy);
		temp.setRentedTimes(14);
		DVDstore.insert(temp);
		temp = new DVD("The LEGO Movie",12.9);
		temp.setGenre(genre.comedy);
		DVDstore.insert(temp);
	}

	/*
	 * While the dvd rental store program is running, the interface should look
	 * like this:
	 */
	public static void displayMainMenu() {
		System.out
				.println("Welcome to the DVD Store! Select an option below: \n");
		System.out.println("1) add an DVD");
		System.out.println("2) remove an DVD");
		System.out.println("3) display inventory");
		System.out.println("4) on sale / off sale");
		System.out.println("5) display genre");
		System.out.println("6) rent DVD");
		System.out.println("7) quit ");
		System.out.println("\nSelect an option above: ");
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
		System.out.println("Please enter the title of the new DVD:");
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
						.println("Please enter the title of the new DVD: (type \"-quit\" to quit)");
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
				.println("Please enter the title of the DVD you want to remove:");
		String title = scanner2.nextLine();
		while (!DVDstore.contains(title)) {
			// no dvd exception
			System.out.println("There is no such DVD. Please try again.\n");
			// take the alternate title
			System.out
					.println("Please enter the title of the DVD you want to remove: (type \"-quit\" to quit)");
			title = scanner2.nextLine();
			if (title.equals("-quit")) {
				return;
			}
		}
		DVDstore.remove(title);
		// confirm
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
		DVDstore.displayInventory();
		// wait for some time
		System.out.println("\nPress Enter to continue.");
		String wait = scanner2.nextLine();
	}

	/*
	 * the user will be prompted for a title. The ¡®on sale¡¯ status of the DVD
	 * will be toggled. If the ¡®on sale¡¯ status of the DVD is now true the user
	 * will be prompted for a sale price.
	 */
	public static void onOffSale() {
		System.out.println("Now you can change the on/off sale status.\n");
		System.out
				.println("Please enter the title of the DVD you want to change:");
		String title = scanner2.nextLine();
		DVD temp = DVDstore.find(title);
		while (temp == null) {
			// wrong title exception
			System.out.println("There is no such DVD. Please try again.\n");
			// take the alternate title
			System.out
					.println("Please enter the title of the DVD you want to change: (type \"-quit\" to quit)");
			title = scanner2.nextLine();
			if (title.equals("-quit")) {
				return;
			}
			temp = DVDstore.find(title);
		}
		temp.flipsale();
		if (temp.isOnSale()) {
			System.out.println("This DVD is now on sale.");
			System.out.println("Please type the on sale price:");
			// set onsale price
			double price = scanner1.nextInt();
			temp.setOnSalePrice(price);
		}
		// confirm
		System.out.println("Status changed.\n");
	}

	/*
	 * the user will be prompted for the genre of movie they are interested in.
	 * The current inventory of the store for the selected genre will be
	 * displayed in alphabetical order - DVD title, current price, and number of
	 * times rented. Price displayed is the original price unless the DVD is
	 * currently on sale, then display the sale price. As a promotional tool, if
	 * the price is 0.00, display ¡°Currently Free!¡± next to the DVD. If it is on
	 * sale, display ¡°On Sale!¡± next to the DVD.
	 */
	public static void displaygenre() {
		if (DVDstore.getDVD() == null) {
			System.out.println("There is no DVD in the inventory.\n");
			return;
		}
		System.out
				.println("Genre: \n\tcomedy, drama, documentary, horror, romance, musical");
		System.out
				.println("Please enter the genre of the DVD from the list above:");
		String g = scanner2.nextLine();
		while (true) {
			if (g.equals("comedy") || g.equals("drama")
					|| g.equals("documentary") || g.equals("horror")
					|| g.equals("romance") || g.equals("musical")) {
				if (DVDstore.countGenre(g) > 0) {
					System.out.println("The " + g + " DVD is listed below:\n");
					break;
				} else {
					System.out.println("The inventory doesn't contain " + g
							+ " DVD. Please try again.\n");
				}
			} else {
				System.out
						.println("There is no such genre. Please try again.\n");
			}
			// exception
			System.out
					.println("Genre: comedy, drama, documentary, horror, romance, musical");
			System.out
					.println("Please enter the genre of the DVD from the list above: (type \"-quit\" to quit)");
			g = scanner2.nextLine();
			if (g.equals("-quit")) {
				return;
			}
		}
		System.out.println("DVD title \t\t\trental price \ttimes rented");
		DVDstore.displayGenre(g);
		// keep checking?
		System.out.println("\nWould you like to see another genre? (yes/no)");
		String keepCheck = scanner2.nextLine();
		if (keepCheck.equals("yes")) {
			displaygenre();
		}
	}

	/*
	 * the current store inventory will be displayed in alphabetical order.
	 * Then, the user will be prompted for which DVD he/she would like to rent.
	 * A warning message will be displayed: ¡°Are you sure you would like us to
	 * deduct $X from your credit card?¡± The user can answer yes, or no. A count
	 * of the number of times each DVD is rented is maintained as part of the
	 * store inventory
	 */
	public static void rentDVD() {
		if (DVDstore.getDVD() == null) {
			System.out.println("There is no DVD in the inventory.\n");
			return;
		}
		System.out.println("The DVD you can rent is listed below:\n");
		System.out.println("DVD title \t\t\trental price \ttimes rented");
		DVDstore.displayInventory();
		System.out.println();
		System.out
				.println("Please enter the title of the DVD you want to rent:");
		String title = scanner2.nextLine();
		DVD temp = DVDstore.find(title);
		while (temp == null || temp.isRented()) {
			// exception
			System.out
					.println("There is no such DVD or the DVD is rented. Please try again.\n");
			// take the alternate title
			System.out
					.println("Please enter the title of the DVD you want to rent: (type \"-quit\" to quit)");
			title = scanner2.nextLine();
			if (title.equals("-quit")) {
				return;
			}
			temp = DVDstore.find(title);
		}
		double price = temp.getPrice();
		System.out.print("Are you sure you would like us to deduct $");
		System.out.print(price);
		System.out.print(" from your credit card?");
		String deduct = scanner2.nextLine();
		if (deduct.equals("yes")) {
			temp.rent();
			// confirm
			System.out.println("DVD rented.\n");
		}
		// keep renting?
		System.out.println("Would you like to rent another DVD? (yes/no)");
		String keepRent = scanner2.nextLine();
		if (keepRent.equals("yes")) {
			rentDVD();
		}
	}

}
