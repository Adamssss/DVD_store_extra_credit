import java.util.Scanner;


public class DVDstore {
	
	private static Linked DVDstore = new Linked (null,null);
	private static Scanner scanner1 = new Scanner(System.in);
	private static Scanner scanner2 = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//init();
			
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
	
	public static void init() {
		DVDstore = new Linked (new DVD("s",0),null);
	}
	
	public static void displayMainMenu() {
		System.out.println("Welcome to the DVD Store! Select an option below: ");
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
	
	public static void add() {
		System.out.println("now you can add a new DVD");
		System.out.println("please type the title of the new DVD");
		String title = scanner2.nextLine();
		System.out.println("please give the price of the new DVD");
		double price = scanner1.nextDouble();
		DVD temp = new DVD(title,price);
		if (DVDstore.getDVD() == null) {
			DVDstore = new Linked(temp,null);
		} else {
		while (DVDstore.contains(title)){
			//exception
			System.out.println("this DVD already exists, please try again");
			System.out.println("please type the title of the new DVD");
			title = scanner2.nextLine();
			System.out.println("please give the price of the new DVD");
			price = scanner1.nextDouble();
			temp = new DVD(title,price);
		}
		DVDstore.insert(temp);
		}
	}
	
	public static void remove() {
		String title = scanner2.nextLine();
		while (!DVDstore.contains(title)){
			//exception
		}
		DVDstore.remove(title);
	}
	
	public static void display(){
		System.out.println("DVD title \t\t\trental price \ttimes rented");
		DVDstore.display();
	}
	
	public static void onOffSale(){
		String title = scanner2.nextLine();
		DVD temp = DVDstore.find(title);
		while (temp == null) {
			//exception
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
